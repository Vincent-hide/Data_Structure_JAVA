class Node {
public:
	int data;
	Node* next;
	Node* prev;

	Node(int data) {
		this->data = data;
		this->next = nullptr;
		this->prev = nullptr;
	}
};