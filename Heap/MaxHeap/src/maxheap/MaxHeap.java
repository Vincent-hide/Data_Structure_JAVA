package maxheap;

public class MaxHeap {

    public static void main(String[] args) {
        MaximumHeap heap = new MaximumHeap(10);

        heap.enqueue(-10);
        heap.enqueue(2);
        heap.enqueue(12);
        heap.enqueue(23);
        heap.enqueue(113);
        
        heap.enqueue(223);
        heap.enqueue(33);
        heap.enqueue(3);
        heap.enqueue(9);
        heap.enqueue(5);

        
        System.out.println(heap);
        System.out.println(heap.NumOfItems());
       
        
        System.out.println(heap.dequeue());
        System.out.println(heap);
        System.out.println(heap.NumOfItems());
    }

}
