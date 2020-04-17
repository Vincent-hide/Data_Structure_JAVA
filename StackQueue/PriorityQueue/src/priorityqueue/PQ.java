package priorityqueue;

public class PQ {

    private int num;
    private int max;
    private String[] arr;

    public PQ(int max) {
        this.max = max;
        this.num = 0;
        this.arr = new String[max];
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.num; i++) {
            s += String.format("Value is %s\n", this.arr[i]);
        }
        return s;
    }

    public int NumOfItems() {
        return this.num;
    }

    public String root() {
        return this.arr[0];
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
        String temp = this.arr[from];
        this.arr[from] = this.arr[to];
        this.arr[to] = temp;
    }

    private void shiftUp(int index) {
        int pIndex = this.getParentIndex(index);

        while (pIndex >= 0 && this.arr[pIndex].compareTo(this.arr[index]) > 0) {
            this.swap(pIndex, index);

            index = pIndex;
            pIndex = this.getParentIndex(index);
        }
    }

    public boolean enqueue(String key) {
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

        if(this.arr[left] == null) {
            return;
        }

        if(this.arr[right] == null && this.arr[index].compareTo(this.arr[left]) < 0) {
            return;
        }

        if (this.arr[index].compareTo(this.arr[left]) < 0 && this.arr[index].compareTo(this.arr[right]) < 0) {
            return;
        }


        while(this.arr[index].compareTo(this.arr[left]) > 0 && this.arr[index].compareTo(this.arr[right]) > 0) {
            if (this.arr[left].compareTo(this.arr[right]) < 0) {
                this.swap(index, left);
                index = left;
            } else {
                this.swap(index, right);
                index = right;
            }
            left = getLeftIndex(index);
            right = getRightIndex(index);
            if (right > this.num) {
                break;
            }
        }
    }

    public String dequeue() {
        if (this.num == 0) {
            return null;
        }
        String dequeued = this.arr[0];
        this.arr[0] = this.arr[this.num - 1];
        this.num--;
        this.shiftDown(0);
        return dequeued;
    }

}
