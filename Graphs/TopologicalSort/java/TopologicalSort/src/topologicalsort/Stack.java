package topologicalsort;

public class Stack {

    private int head;
    private int max;
    private Vertex[] arr;

    public Stack(int max) {
        this.max = max;
        this.arr = new Vertex[max];
        this.head = 0;
    }

    public boolean isEmpty() {
        return this.head == 0;
    }

    public boolean isFull() {
        return this.head == this.max;
    }
    
    public int head() {
        return this.head;
    }

    public boolean push(Vertex node) {
        if (this.head == this.max) {
            return false;
        }

        this.arr[this.head++] = node;
        return true;
    }

    public Vertex pop() {
        if (this.head == 0) {
            return null;
        }

        Vertex popped = this.arr[this.head---1];
        return popped;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.head; i++) {
            s += String.format("[%s] => ", this.arr[i].label);
//            s += String.format("[label: %s, value: %d] => ", this.arr[i].label, this.arr[i].value);
        }
        return s;
    }
}
