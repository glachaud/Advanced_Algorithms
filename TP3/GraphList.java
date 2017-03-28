import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GraphList<T> {
  private int nodeCount;
  private int edgeCount;
  ArrayList<Node<T>> adj;


  public GraphList(int nodeCount) {
    this.nodeCount = nodeCount;
    this.edgeCount = 0;
    adj = new ArrayList<>();
  }

  public GraphList(String file, String splitDelimiter) throws java.io.IOException {
    Map<Node, Integer> mappingOfVertices = GraphFunctions.countNumberOfNodes(file, splitDelimiter);
    this.nodeCount = mappingOfVertices.size();
    this.adj = new ArrayList<>();
    Set<Node> keySet = mappingOfVertices.keySet();
    Iterator<Node> iterator = keySet.iterator();
    Node node;
    while (iterator.hasNext()) {
      node = iterator.next();
      adj.add(node);
    }
    fillAdjList(file, splitDelimiter);
  }


  public void fillAdjList(String file, String splitDelimiter) throws java.io.IOException {
    List<String> lines = Files.readAllLines(Paths.get(file), Charset.defaultCharset());
    String line;
    String[] edge;
    Iterator<String> lineIterator = lines.iterator();
    Node<T> tail, head;
    Edge newEdge;
    int weight;
    while (lineIterator.hasNext()) {
      line = lineIterator.next();
      line = line.replaceAll("\" ","-");
      line = line.replaceAll("\"","");
      edge = line.split(splitDelimiter);
      tail = this.getNode((T) edge[0]);
      head = this.getNode((T) edge[1]);
      weight = 1;
      if (edge.length  == 3) {
        edge[2] = edge[2].replaceAll("^\"|\"$", "");
        weight = Integer.parseInt(edge[2]);
      }
      newEdge = new Edge(tail, head, weight);
      adj.get(adj.indexOf(tail)).addEdge(newEdge);
      adj.get(adj.indexOf(head)).addEdge(newEdge);
    }
  }

  public Node getNode(T nodeName) {
    Iterator<Node<T>> iterator = adj.iterator();
    Node node;
    while (iterator.hasNext()) {
      node = iterator.next();
      if (node.getNodeName().equals(nodeName)) {
        return node;
      }
    }
    return null;
  }

  public T[] getNodeNeighbors(Node node) {
    int neighborIndex = 0;
    List<Edge> neighbors = node.getNeighbors();
    T[] nodeNeighbors = (T[]) new Object[neighbors.size()];
    Node[] nodes;
    Iterator<Edge> iterator = neighbors.iterator();
    Edge edge;
    while (iterator.hasNext()) {
      edge = iterator.next();
      nodes = edge.getNodes();
      if (!nodes[0].equals(node)) {
        nodeNeighbors[neighborIndex] = (T) nodes[0].getNodeName();
        neighborIndex++;
      } else {
        nodeNeighbors[neighborIndex] = (T) nodes[1].getNodeName();
        neighborIndex++;
      }
    }
    return nodeNeighbors;
  }


  public int getNodeCount() {
    return nodeCount;
  }

  public int getEdgeCount() {
    return edgeCount;
  }

  public ArrayList<Node<T>> getAdjList() {
    return adj;
  }

  public static void main(String[] args) throws java.io.IOException {
    GraphList graph = new GraphList("src/karate_weighted.txt", "-");
    Iterator<Node> firstIterator = graph.getAdjList().iterator();
    Node nodePasser;
    while (firstIterator.hasNext()) {
      nodePasser = firstIterator.next();
      System.out.print(nodePasser.getNodeName() + ": ");
      System.out.println(Arrays.toString(graph.getNodeNeighbors(nodePasser)));
      // System.out.println(graph.getNodeNeighbors(nodePasser).length);
      // System.out.println("----------------------------------------------");
    }
  }
}
