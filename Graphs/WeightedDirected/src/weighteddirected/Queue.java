package weighteddirected;

class QNode {

    public String data;
    public QNode next;

    public QNode(String data) {
        this.data = data;
        this.next = null;
    }
}

public class Queue {

    private QNode head;

    public Queue() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void enqueue(String key) {
        if (this.head == null) {
            this.head = new QNode(key);
            return;
        }

        QNode node = this.head;
        while (node.next != null) {
            node = node.next;
        }

        node.next = new QNode(key);
    }

    public QNode dequeue() {
        if (this.head == null) {
            return null;
        }
        
        QNode node = this.head;
        this.head = this.head.next;
        return node;
    }
}
