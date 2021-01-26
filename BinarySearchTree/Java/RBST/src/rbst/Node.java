package rbst;

public class Node {
    public String data;
    public Node left, right;
    public Node next;
    
    public Node(String data) {
        this.data = data;
        this.left = this.right = null;
    }
    
}
