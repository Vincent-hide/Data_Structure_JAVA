package dijkstra.salgorithm;

public class PriorityQueue {

    private int max;
    private int num;
    public PQNode[] arr;

    public PriorityQueue(int max) {
        this.max = max;
        this.num = 0;
        this.arr = new PQNode[max];
    }

    public void print() {
        for (int i = 0; i < this.num; i++) {
            System.out.println(this.arr[i].edge + " = " + this.arr[i].label);
        }
    }

    public PQNode root() {
        return this.arr[0];
    }

    public String NumOfItems() {
        return String.format("Currently we have %d items in this heap tree", this.num);
    }

    public boolean isEmpty() {
        return this.num == 0;
    }

    public boolean isFull() {
        return this.num == this.num;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftIndex(int index) {
        return (index * 2) + 1;
    }

    private int getRightIndex(int index) {
        return (index * 2) + 2;
    }

    private void swap(int from, int to) {
        PQNode temp = this.arr[from];
        this.arr[from] = this.arr[to];
        this.arr[to] = temp;
    }

    public int contains(String label) {
        for (int i = 0; i < this.num; i++) {
            if (this.arr[i].label.equals(label)) {
                return i;
            }
        }
        return -1;
    }

    private void shiftUp(int index) {
        int pIndex = this.getParentIndex(index);

        while (pIndex >= 0 && this.arr[pIndex].edge > this.arr[index].edge) {
            this.swap(pIndex, index);

            index = pIndex;
            pIndex = this.getParentIndex(index);
        }

    }

    // helper function to swap the weight if the existing one is bigger than new one
    public void weightSwap(int index, PQNode node) {
        if (this.arr[index].edge > node.edge) {
            this.arr[index] = node;
            this.shiftUp(index);
        }
    }

    public boolean enqueue(PQNode node) {
        if (this.max == this.num) {
            return false;
        }

        this.arr[this.num++] = node;
        this.shiftUp(this.num - 1);
        return true;
    }

    private int smallerIndex(int index) {
        int left = getLeftIndex(index);
        int right = getRightIndex(index);

        if (right > this.num - 1) {
            if (left > this.num - 1) {
                return -1;
            }
            return left;
        } else {
            if (this.arr[left].edge < this.arr[right].edge) {
                return left;
            } else {
                return right;
            }
        }
    }

    private void shiftDown(int index) {
        int smaller = this.smallerIndex(index);

        if (smaller == -1) {
            return;
        }

        if (this.arr[index].edge < this.arr[smaller].edge) {
            return;
        }

        while (this.arr[index].edge > this.arr[smaller].edge) {
            this.swap(index, smaller);
            index = smaller;
            smaller = this.smallerIndex(index);
            if (smaller == -1) {
                return;
            }
        }
    }

    public PQNode dequeue() {
        if (this.num == 0) {
            return null;
        }
        PQNode dequeued = this.arr[0];
        this.arr[0] = this.arr[this.num - 1];
        this.num--;
        this.shiftDown(0);
        return dequeued;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.num; i++) {
            if (this.arr[i].edge == Integer.MAX_VALUE) {
                s += String.format("%s - NA | ", this.arr[i].label);
            } else {
                s += String.format("%s - %d/%s | ", this.arr[i].label, this.arr[i].edge, this.arr[i].prev);
            }
        }
        return s;
    }
}
