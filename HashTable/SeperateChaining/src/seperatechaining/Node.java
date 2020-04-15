package seperatechaining;

public class Node {
    public String data;
    public Node next, prev;
    
    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}
