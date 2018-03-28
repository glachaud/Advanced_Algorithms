public class Edge {
  Node tail;
  Node head;
  double weight;

  public Edge(Node u, Node v) {
    this(u,v,1);
  }

  public Edge(Node u, Node v, int weight) {
    this.tail = u;
    this.head = v;
    this.weight = weight;
  }
  public Node getTail(){
    return tail;
  }
  public Node getHead(){
    return head;
  }
  public double getWeight(){
    return weight;
  }

  public Node[] getNodes() {
    Node[] nodes = new Node[2];
    nodes[0] = tail;
    nodes[1] = head;
    return nodes;
  }
}
