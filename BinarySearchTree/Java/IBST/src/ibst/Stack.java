package ibst;

public class Stack {

    private Node[] arr;
    private int top;

    public Stack() {
        this.arr = new Node[1000000];
        this.top = 0;
    }

    public boolean push(Node key) {
        if (this.top == 1000000) {
            return false;
        }

        this.arr[this.top++] = key;
        return true;
    }

    public Node pop() {
        if (this.top == 0) {
            return null;
        }
        Node popped = this.arr[this.top-1];
        this.arr[this.top---1] = null;
        return popped;
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public String numOfItems() {
        return String.format("Currently you have %d items in this queue", this.top);
    }
    
}
