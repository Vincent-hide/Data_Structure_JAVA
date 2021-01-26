#include <iostream>
#include "Node.cpp"

using namespace std;

class Linked {
private:
	Node* head;
	Node* tail;

public:
	Linked() {
		this->head = nullptr;
	}

	~Linked() {
		Node* ptr = this->head;
		Node* temp;

		while (ptr != nullptr) {
			temp = ptr;
			ptr = ptr->next;
			delete temp;
		}
	}

	void shift(int data) {
		Node* node = new Node(data);

		if (this->head == nullptr) {
			this->head = node;
			this->tail = node;
			return;
		}

		this->head->prev = node;
		node->next = this->head;
		this->head = node;
	}

	void push(int data) {
		Node* node = new Node(data);

		if (this->head == nullptr) {
			this->head = node;
			this->tail = node;
			return;
		}

		node->prev = this->tail;
		this->tail->next = node;
		this->tail = node;
	}

	void reverse() {
		cout << "Reverse: ";
		Node* ptr = this->tail;

		while (ptr != nullptr) {
			cout << ptr->data << " ";
			ptr = ptr->prev;
		}
		cout << "\n";
	}

	void print() {
		cout << "Linked List: ";
		Node* ptr = this->head;

		while (ptr != nullptr) {
			cout << ptr->data << " ";
			ptr = ptr->next;
		}
		cout << "\n";
	}

	int remove(int data) {
		if (this->head->data == data) {
			Node* ptr = this->head;
			this->head->next->prev = nullptr;
			this->head = this->head->next;
			delete ptr;
			return 1;
		}

		Node* node = this->head;
		while (node->next != nullptr && node->next->data != data) {
			node = node->next;
		}

		if (node->next == nullptr) return 0;

		// node->next is a node to be deleted
		Node* ptr = node->next;
		node->next->prev = node;
		node->next = node->next->next;
		if (this->tail == ptr) {
			this->tail = node;
		}
		delete ptr;
		return 1;
	}

	void getHead() {
		cout << "Head: " << this->head->data << "\n";
	}

	void getTail() {
		cout << "Tail: " << this->tail->data << "\n";
	}

	Linked operator+(Linked* list) {
		if (this->head == nullptr) {
			this->head = list->head;
			this->tail = this->returnTail(this);
			return *this;
		}

		this->tail->next = list->head;
		this->tail = this->returnTail(this);
		return *this;
	}

	Node* returnTail(Linked* list) {
		if (list->head == nullptr) return nullptr;
		Node* ptr = list->head;
		while (ptr->next != nullptr) {
			ptr = ptr->next;
		}
		return ptr;
	}
};