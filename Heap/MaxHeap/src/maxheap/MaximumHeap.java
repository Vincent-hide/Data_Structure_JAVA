package maxheap;

// the number of items is stored in the first index of the array
// the root value is stored in the second index of array. 
// Left Child -> arr[(i*2)]
// Right Child -> arr[(i*2)+1]
// Parent Child -> arr[i/2]
public class MaximumHeap {

    private int max;
    private int[] arr;
    // the value at the first index in this array keeps track of the number of items in this max heap

    public MaximumHeap(int max) {
        this.max = max + 1;
        this.arr = new int[max + 1];
    }

    @Override
    public String toString() {
        String s = String.format("The number of items is %d\n", this.arr[0]);
        for (int i = 1; i <= this.arr[0]; i++) {
            s += String.format("Value is %d\n", this.arr[i]);
        }
        return s;
    }

    public int root() {
        return this.arr[1];
    }

    public String NumOfItems() {
        return String.format("Currently we have %d items in this heap tree", this.arr[0]);
    }

    public boolean isEmpty() {
        return this.arr[0] == 0;
    }

    public boolean isFull() {
        return this.arr[0] == this.max - 1;
    }

    private int getParentIndex(int index) {
        return index / 2;
    }

    private int getLeftIndex(int index) {
        return index * 2;
    }

    private int getRightIndex(int index) {
        return (index * 2) + 1;
    }

    private void swap(int from, int to) {
        int temp = this.arr[from];
        this.arr[from] = this.arr[to];
        this.arr[to] = temp;
    }

    private void shiftUp(int index) {
        int pIndex = this.getParentIndex(index);
        if (pIndex == 0) {
            return;
        }
        if (this.arr[index] > this.arr[pIndex]) {
            this.swap(index, pIndex);
            index = pIndex;
            this.shiftUp(index);
        }
    }

    public boolean enqueue(int key) {
        if (this.arr[0] == this.max - 1) {
            return false;
        }

        this.arr[this.arr[0]++ + 1] = key;
        this.shiftUp(this.arr[0]);
        return true;
    }

    private void shiftDown(int index) {

        int left = this.getLeftIndex(index);
        int right = this.getRightIndex(index);

        if(left > this.arr[0]) {
            return;
        }

        if (this.arr[index] > this.arr[left] && this.arr[index] > this.arr[right]) {
            return;
        }

        if (this.arr[index] < this.arr[left] || this.arr[index] < this.arr[right]) {
            if (this.arr[left] > this.arr[right]) {
                this.swap(index, left);
                index = left;
                this.shiftDown(index);
            } else {
                this.swap(index, right);
                index = right;
                this.shiftDown(index);
            }

        }

    }

    public int dequeue() {
        if (this.arr[0] == 0) {
            return -1;
        }

        int dequeued = this.arr[1];
        this.arr[1] = this.arr[this.arr[0]];
        this.arr[0]--;
        this.shiftDown(1);
        return dequeued;
    }
}
