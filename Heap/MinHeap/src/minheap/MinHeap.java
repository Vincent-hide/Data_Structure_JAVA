package minheap;

public class MinHeap {

    public static void main(String[] args) {
        MinimumHeap heap = new MinimumHeap(10);
        
        heap.enqueue(2);
        heap.enqueue(-10);
        heap.enqueue(12);
        heap.enqueue(23);
        heap.enqueue(113);
        heap.enqueue(223);
        heap.enqueue(33);
        heap.enqueue(3);
        heap.enqueue(9);
        heap.enqueue(5);
        
        System.out.println(heap);
        
        System.out.println(heap.dequeue());
        
        System.out.println(heap);
    }
    
}
