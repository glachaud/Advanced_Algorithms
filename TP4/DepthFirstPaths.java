import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/**
 * Created by guillaumelachaud on 4/19/17.
 */
public class DepthFirstPaths<T> {
  private Map<Node, Boolean> marked;
  private Map<Node, Node> edgeTo;
  private final Node s;

  public DepthFirstPaths(GraphList G, Node s) {
    marked = new HashMap<>();
    edgeTo = new HashMap<>();
    this.s = s;
    dfs(G, s);
  }

  private void dfs(GraphList G, Node v) {
    marked.put(v, true);
    Iterator<Node<T>> iterator = v.getListNeighbors().iterator();
    while (iterator.hasNext()) {
      Node nodeIteration = iterator.next();
      if (!marked.containsKey(nodeIteration)) {
        edgeTo.put(nodeIteration, v);
        dfs(G, nodeIteration);
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
    while (currentNode != s) {
      path.push(currentNode);
      currentNode = edgeTo.get(currentNode);
    }
    path.push(s);
    return path;
  }

  public static void main(String[] args) throws java.io.IOException {
    GraphList graph = new GraphList("src/karate.txt", " ");
    Node firstNode = graph.getNode("27");
    DepthFirstPaths dfsPaths = new DepthFirstPaths(graph, firstNode);
    System.out.println(dfsPaths.hasPathTo(graph.getNode("1")));
    Iterable<Node> path = dfsPaths.pathTo(graph.getNode("1"));
    Iterator<Node> iterator = path.iterator();
    Node currentNode;
    System.out.println("A path between " + firstNode.getNodeName() + " and 1 is ");
    System.out.println(firstNode.getNodeName());
    while (iterator.hasNext()) {
      currentNode = iterator.next();
      System.out.print(" - " + currentNode.getNodeName());
    }
  }
}
