import java.util.*;

/**
 * Created by guillaumelachaud on 3/29/17.
 */
public class BreadthFirstPaths<T> {
  private Map<Node, Boolean> marked;
  private Map<Node, Node> edgeTo;
  private final Node s;

  public BreadthFirstPaths(GraphList G, Node s) {
    marked = new HashMap<>();
    edgeTo = new HashMap<>();
    this.s = s;
    bfs(G, s);
  }

  private void bfs(GraphList G, Node s) {
    Queue<Node> queue = new LinkedList<>();
    marked.put(s, true);
    queue.add(s);
    while (!queue.isEmpty()) {
      Node v = queue.remove();
      Iterator<Node<T>> iterator = v.getListNeighbors().iterator();
      while (iterator.hasNext()) {
        Node nodeIteration = iterator.next();
        if (!marked.containsKey(nodeIteration)) {
          edgeTo.put(nodeIteration, v);
          marked.put(nodeIteration, true);
          queue.add(nodeIteration);
        }
      }
    }
  }

  public boolean hasPathTo(Node v) {
    if (marked.containsKey(v)) {
      return marked.get(v);
    }
    return false;
  }

  public Iterable<Node> pathTo(Node v) {
    if (!hasPathTo(v)) {
      return null;
    }
    Stack<Node> path = new Stack<Node>();
    Node currentNode = v;
    while(currentNode != s){
      path.push(currentNode);
      currentNode = edgeTo.get(currentNode);
    }
    path.push(s);
    return path;
  }

  public static void main(String[] args) throws java.io.IOException {
    // TO DO: Generic Search, interface to implement that
    GraphList graph = new GraphList("src/karate.txt", " ");
    Node firstNode = graph.getNode("27");
    BreadthFirstPaths bfsPaths = new BreadthFirstPaths(graph, firstNode);
    System.out.println(bfsPaths.hasPathTo(graph.getNode("1")));
    Iterable<Node> path = bfsPaths.pathTo(graph.getNode("1"));
    Iterator<Node> iterator = path.iterator();
    Node currentNode;
    System.out.println("The path between " + firstNode.getNodeName() + " and 1 is ");
    System.out.println(firstNode.getNodeName());
    while(iterator.hasNext()){
      currentNode = iterator.next();
      System.out.print(" - " + currentNode.getNodeName());
    }
  }
}
