from PriorityQueue import PriorityQueue

pq = PriorityQueue(10)
pq.enqueue(5)
pq.enqueue(10)
pq.enqueue(30)
pq.enqueue(20)

pq.dequeue()

pq.print()