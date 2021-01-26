package hungrybird;

public class List {
  private Node head;

  public List() {
    this.head = null;
  }

  @Override
  public String toString() {
    String s = "";
    Node temp = this.head;

    while(temp != null) {
      s += String.format("Item: %d\n", temp.getData());
      temp = temp.getNext();
    }
    return s;
  }

  public void print() {
    Node node = this.head;
    print(node);
  }

  public void print(Node node) {
    if(node == null) return;
    System.out.println(node.getData());
    print(node.getNext());
  }


  public String print2() {
    Node node = this.head;
    String s = "";
    s += print2(node, s);
    System.out.println(s);
    return "TEST";
  }

  public String print2(Node node, String s) {
    if(node != null) {
      s += String.format("Item: %d\n", node.getData());
      return print2(node.getNext(), s);
    };
    return s;
  }


  public void addFront(int data) {
    Node node = new Node(data);
    node.setNext(this.head);
    this.head = node;
  }

  public List flip() {
    List newList = new List();
    flip(this.head, newList);
    return newList;
  }

  private void flip(Node node, List newList) {
    if(node == null) return;
    newList.addFront(node.getData());
    flip(node.getNext(), newList);
  }
}
