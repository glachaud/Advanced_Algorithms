import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Node<T> implements Comparable<Node<T>> {
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

  public List<Node<T>> getListNeighbors() {
    List<Node<T>> listOfNodes = new ArrayList<>();
    Iterator<Edge> iterator = neighbors.iterator();
    Edge edgeIteration;
    Node tail, head;
    while (iterator.hasNext()) {
      edgeIteration = iterator.next();
      tail = edgeIteration.getTail();
      head = edgeIteration.getHead();
      if (this == tail) {
        listOfNodes.add(head);
      } else {
        listOfNodes.add(tail);
      }
    }
    return listOfNodes;
  }


  public T getNodeName() {
    return nodeName;
  }


  @Override
  public int compareTo(Node<T> node) {
    if (neighbors.size() < node.getNeighbors().size()) {
      return -1;
    } else if (neighbors.size() > node.getNeighbors().size()) {
      return 1;
    } else {
      return 0;
    }
  }
}
