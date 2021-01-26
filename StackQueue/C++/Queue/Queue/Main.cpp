#include <iostream>
#include "Queue.cpp";

using namespace std;

int main()
{
	Queue queue(5);

	cout << queue.enqueue(1) << "\n";
	cout << queue.enqueue(2) << "\n";
	cout << queue.enqueue(3) << "\n";
	cout << queue.enqueue(4) << "\n";
	cout << queue.enqueue(5) << "\n";

	cout << "Count " << queue.count() << "\n";
	for (int i=0; i < 5; i++) {
		cout << queue.dequeue();
	}
	cout << "Count " << queue.count() << "\n";
}
