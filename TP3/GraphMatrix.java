import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GraphMatrix {
  private final int V;
  private int E;
  private boolean[][] adj;

  public GraphMatrix(int V) {
    this.V = V;
    this.E = 0;
    adj = initializeAdjMatrix(V);
  }

  // Adapt to accept weighted graph

  public GraphMatrix() throws java.io.IOException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("How do you want to call your graph?");
    String file = scanner.nextLine();
    file = "src/" + file + ".txt";
    System.out.println("Is the graph directed? (y/n)");
    boolean isDirectedGraph = scanner.nextLine().equals("y");
    System.out.println("Enter the number of vertices");
    int nodeCount = Integer.parseInt(scanner.nextLine());
    System.out.println("Enter the number of edges");
    int edgeCount = Integer.parseInt(scanner.nextLine());
    PrintWriter writer = new PrintWriter(file, "UTF-8");
    String line;
    String splitDelimiter = " ";
    for (int i = 0; i < edgeCount; i++) {
      System.out.println("Enter the edges in the graph: <to> <from> <weight>(optional)");
      line = scanner.nextLine();
      writer.println(line);
    }
    writer.close();
    scanner.close();

    int[] minAndMax = minAndMax(file, splitDelimiter);
    this.V = minAndMax[1] - minAndMax[0];
    adj = initializeAdjMatrix(V);
    fillAdjMatrix(file, minAndMax[0], splitDelimiter);

  }

  public GraphMatrix(String file, String splitDelimiter) throws java.io.IOException {
    int[] minAndMax = minAndMax(file, splitDelimiter);
    this.V = minAndMax[1] - minAndMax[0] + 1;
    adj = initializeAdjMatrix(V);
    fillAdjMatrix(file, minAndMax[0], splitDelimiter);
  }

  public void fillAdjMatrix(String file, int minIndex, String splitDelimiter) throws java.io.IOException {
    List<String> lines = Files.readAllLines(Paths.get(file), Charset.defaultCharset());
    String line;
    String[] edge;
    Iterator<String> lineIterator = lines.iterator();
    int tail, head;
    while (lineIterator.hasNext()) {
      line = lineIterator.next();
      edge = line.split(" ");
      tail = Integer.parseInt(edge[0]) - minIndex;
      head = Integer.parseInt(edge[1]) - minIndex;
      adj[tail][head] = true;
      adj[head][tail] = true;
    }
  }

  public static int[] minAndMax(String file, String splitDelimiter) throws java.io.IOException {
    int[] minAndMax = new int[2];
    ArrayList<Integer> verticesList = new ArrayList();
    List<String> lines = Files.readAllLines(Paths.get(file), Charset.defaultCharset());
    String line;
    String[] edge;
    Iterator<String> lineIterator = lines.iterator();
    while (lineIterator.hasNext()) {
      line = lineIterator.next();
      edge = line.split(splitDelimiter);
      verticesList.add(Integer.parseInt(edge[0]));
      verticesList.add(Integer.parseInt(edge[1]));
    }
    Integer vertex;
    int min, max;
    Iterator<Integer> verticesIterator = verticesList.iterator();
    vertex = verticesIterator.next();
    min = vertex;
    max = vertex;
    while (verticesIterator.hasNext()) {
      vertex = verticesIterator.next();
      if (vertex < min) {
        min = vertex;
      }
      if (vertex > max) {
        max = vertex;
      }

    }
    minAndMax[0] = min;
    minAndMax[1] = max;
    return minAndMax;
  }

  public static boolean[][] initializeAdjMatrix(int V) {
    boolean[][] adj = new boolean[V][V];
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        if (i == j) {
          adj[i][j] = true;
        } else {
          adj[i][j] = false;
        }
      }
    }
    return adj;
  }

  public boolean[][] getAdjMatrix() {
    return adj;
  }

  public int getV() {
    return V;
  }

  public int getE() {
    return E;
  }


  public int[][] getIntAdjMatrix() {
    int[][] intAdjMatrix = new int[V][V];
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        if (adj[i][j]) {
          intAdjMatrix[i][j] = 1;
        } else {
          intAdjMatrix[i][j] = 0;
        }
      }
    }
    return intAdjMatrix;
  }

  public static void main(String[] args) throws java.io.IOException {
    GraphMatrix graph = new GraphMatrix("src/karate.txt", " ");
    int[][] intAdjMatrix = graph.getIntAdjMatrix();
    for (int i = 0; i < graph.getV(); i++) {
      System.out.println(Arrays.toString(intAdjMatrix[i]));
    }
  }
}