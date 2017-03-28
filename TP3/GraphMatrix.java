import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GraphMatrix {
  private final int V;
  private int E;
  private boolean[][] adj;
  private Map mappingOfVertices;

  public GraphMatrix(int V) {
    this.V = V;
    this.E = 0;
    adj = initializeAdjMatrix(V);
    mappingOfVertices = new HashMap();
  }

  // Adapt to accept weighted graph

  public GraphMatrix(String file, String splitDelimiter) throws java.io.IOException {
    Map<Node, Integer> mappingOfVertices = GraphFunctions.countNumberOfNodes(file, splitDelimiter);
    this.mappingOfVertices = mappingOfVertices;
    this.V = mappingOfVertices.size();
    adj = initializeAdjMatrix(V);
    fillAdjMatrix(file, mappingOfVertices);
  }

  public void fillAdjMatrix(String file, Map<Node,Integer> mappingOfVertices) throws java.io.IOException{
    List<String> lines = Files.readAllLines(Paths.get(file), Charset.defaultCharset());
    String line;
    String[] edge;
    Iterator<String> lineIterator = lines.iterator();
    int tail, head;
    while (lineIterator.hasNext()) {
      line = lineIterator.next();
      edge = line.split(" ");
      tail = mappingOfVertices.get(Integer.parseInt(edge[0]));
      head = mappingOfVertices.get(Integer.parseInt(edge[1]));
      adj[tail][head] = true;
      adj[head][tail] = true;
    }
  }

  public static boolean[][] initializeAdjMatrix(int V){
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

  public Map getMappingOfVertices(){
    return mappingOfVertices;
  }

  public int[][] getIntAdjMatrix() {
    int[][] intAdjMatrix = new int[V][V];
    for(int i = 0; i < V; i++){
      for(int j = 0; j < V; j++){
        if(adj[i][j]){
          intAdjMatrix[i][j] = 1;
        }
        else{
          intAdjMatrix[i][j] = 0;
        }
      }
    }
    return intAdjMatrix;
  }

  public static void main(String[] args) throws java.io.IOException {
    GraphMatrix graph = new GraphMatrix("src/karate.txt", " ");
    Map mappingOfVertices = graph.getMappingOfVertices();
    int[][] intAdjMatrix = graph.getIntAdjMatrix();
    for (int i = 0; i < graph.getV(); i++) {
      System.out.print(i + " - " + mappingOfVertices.get(i) + ": ");
      System.out.println(Arrays.toString(intAdjMatrix[i]));
    }
  }
}