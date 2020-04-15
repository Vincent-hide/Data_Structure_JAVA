package minheap;

// the number of items is stored in the num variable
// the root value is stored in the first index of array. 
// Left Child -> arr[(i*2)+1]
// Right Child -> arr[(i*2)+2]
// Parent Child -> arr[(i-1)/2]
public class MinimumHeap {

    private int max;
    private int num;
    private int[] arr;

    public MinimumHeap(int max) {
        this.max = max;
        this.num = 0;
        this.arr = new int[max];
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.num; i++) {
            s += String.format("Value is %d\n", this.arr[i]);
        }
        return s;
    }

    public int root() {
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
        int temp = this.arr[from];
        this.arr[from] = this.arr[to];
        this.arr[to] = temp;
    }

    private void shiftUp(int index) {
        int pIndex = this.getParentIndex(index);

        while (pIndex >= 0 && this.arr[pIndex] > this.arr[index]) {
            this.swap(pIndex, index);

            index = pIndex;
            pIndex = this.getParentIndex(index);
        }
    }

    public boolean enqueue(int key) {
        if (this.max == this.num) {
            return false;
        }
        this.arr[this.num++] = key;
        this.shiftUp(this.num - 1);
        return true;
    }

    private void shiftDown(int index) {
        int left = getLeftIndex(index);
        int right = getRightIndex(index);

        if (this.arr[index] < this.arr[left] && this.arr[index] < this.arr[right]) {
            return;
        }

        while (this.arr[index] > this.arr[left] || this.arr[index] > this.arr[right]) {
                      
            if (this.arr[left] < this.arr[right]) {
                this.swap(index, left);
                index = left;
            } else {
                this.swap(index, right);
                index = right;
            }
            left = getLeftIndex(index);
            right = getRightIndex(index);
            if(right > this.num) break;
        }
    }

    public int dequeue() {
        if (this.num == 0) {
            return -1;
        }
        int dequeued = this.arr[0];
        this.arr[0] = this.arr[this.num - 1];
        this.num--;
        this.shiftDown(0);
        return dequeued;
    }

}
