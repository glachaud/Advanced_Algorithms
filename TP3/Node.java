import java.util.ArrayList;
import java.util.List;

public class Node<T> {
  T nodeName;
  List<Edge> neighbors;

  public Node(T nodeName) {
    this.nodeName = nodeName;
    this.neighbors = new ArrayList<>();
  }

  public Node(T nodeName, List<Edge> neighbors) {
    this.nodeName = nodeName;
    this.neighbors = neighbors;
  }

  public void addEdge(Edge u) {
    this.neighbors.add(u);
  }

  public List<Edge> getNeighbors() {
    return neighbors;
  }

  public T getNodeName() {
    return nodeName;
  }

}
