class Node {
    
public:
    int data;
    Node* next; // same as Node *next;
    
    Node() {
        this->data = 0;
        this->next = nullptr;
    };
    
    Node(int data) {
        this->data = data;
        this->next = nullptr;
    };
};