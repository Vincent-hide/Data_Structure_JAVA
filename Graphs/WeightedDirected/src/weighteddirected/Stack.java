package weighteddirected;

class SNode {
    public String data;
    public SNode next;
    
    public SNode(String data) {
        this.data = data;
        this.next = null;
    }
}

public class Stack {
    private SNode head;
    
    public Stack() {
        this.head = null;
    }
    
    public boolean isEmpty() {
        return this.head == null;
    }
    
    public void push(String key) {
        if(this.head == null) {
            this.head = new SNode(key);
            return;
        }
        
        SNode node = new SNode(key);
        
        node.next = this.head;
        this.head = node;
    }
    
    public SNode pop() {
        if(this.head == null) return null;
        
        SNode node = this.head;
        this.head = this.head.next;
        return node;
    }
    
    public void print() {
        SNode node = this.head;
        
        while(node != null) {
            System.out.println(node.data + " => ");
            node = node.next;
        }
    }
}
