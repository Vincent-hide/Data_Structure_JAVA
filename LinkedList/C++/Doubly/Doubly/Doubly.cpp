#include <iostream>
#include "Linked.cpp"

int main() {
	Linked list;

	list.shift(5);
	list.shift(10);

	cout << list.remove(5) << endl;

	list.print();
	cout << endl;
	list.getHead();
	list.getTail();
	list.reverse();

	cout << "----------------------------------\n";

	Linked list2;
	Linked list3;

	list2.push(5);
	list3.push(10);

	Linked list4 = list2 + &list3;
	list4.print();
	list4.getTail();

}