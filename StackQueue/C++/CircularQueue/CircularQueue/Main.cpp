#include <iostream>
#include "CircularQueue.cpp";

using namespace std;

int main()
{
	CircularQueue queue(5);

	queue.enqueue(1);
	queue.enqueue(2);
	queue.enqueue(3);
	queue.enqueue(4);
	queue.enqueue(5);
	queue.enqueue(7);

	queue.dequeue();
	queue.dequeue();
	queue.dequeue();



	queue.enqueue(6);
	queue.print();

} 