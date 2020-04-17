package priorityqueue;

public class PriorityQueue {

    public static void main(String[] args) {
        PQ q = new PQ(10);
        
        q.enqueue("B");
        q.enqueue("A");
        q.enqueue("C");
        q.enqueue("D");
        
        System.out.println(q.dequeue());
        
        System.out.println(q);
    }
    
}
