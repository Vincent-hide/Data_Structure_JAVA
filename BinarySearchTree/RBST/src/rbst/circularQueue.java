package rbst;

// For Level Order
public class circularQueue {

    public int front, rear, max;
    private Node[] arr;

    public circularQueue() {
        this.max = 100000;
        this.arr = new Node[this.max];
        this.front = -1;
        this.rear = 0;
    }

    public boolean isEmpty() {
        return this.front == -1;
    }
    
    public boolean isFull() {
        return this.front == this.rear;
    }

    public boolean enqueue(Node node) {
        if (this.isFull()) {
            return false;
        }
        this.arr[this.rear] = node;
        if (this.front == -1) {
            this.front = this.rear;
        }
        this.rear = (this.rear + 1) % this.max;
        return true;
    }

    public Node dequeue() {
        if (this.isEmpty()) {
            return null;
        }
        Node node = this.arr[this.front];
        this.front = (this.front + 1) % this.max;
        if (this.front == this.rear) {
            this.front = -1;
        }
        return node;
    }

}
