#include "Node.cpp"
#include <stdio.h>
#include <string>

using namespace std;

class Linked {
public:
    Node* head;

    // AKA default constructor

    Linked() {
        this->head = nullptr;
    }

    // destroy all the nodes attached to linked-list

    ~Linked() {
        Node* ptr = head;
        Node* temp;

        while (ptr != nullptr) {
            temp = ptr;
            ptr = ptr->next;
            delete temp;
        }
    }

    // newNode -> b -> c

    void shift(int data) {
        Node* temp = new Node(data);
        temp->next = this->head;
        this->head = temp;
    }

    // a -> b -> newNode

    void push(int data) {
        if (this->head == nullptr) {
            this->head = new Node(data);
            return;
        }

        Node* ptr = this->head;
        while (ptr->next != nullptr) {
            ptr = ptr->next;
        }

        ptr->next = new Node(data);
    }

    // Add to the end

    Linked operator-(Linked list) {
        if (this->head == nullptr) {
            this->head = list.head;
            return *this;
        } else {
            Node* ptr = this->head;
            while (ptr->next != nullptr) {
                ptr = ptr->next;
            }
            ptr->next = list.head;
            return *this;
        }
    }

    Linked* operator+(Linked* list) {
        Linked* newList = new Linked();
        Node* ptr = head;

        while (ptr != nullptr) {
            newList->push(ptr->data);
            ptr = ptr->next;
        }
        ptr = list->head;
        while (ptr != nullptr) {
            newList->push(ptr->data);
            ptr = ptr->next;
        }
        return newList;
    }

    // remove operations

    int remove(int data) {
        if (this->head->data == data) {
            Node* ptr = this->head->next;
            delete this->head;
            this->head = ptr;
            return 1;
        } else {
            Node* ptr = this->head;
            while (ptr->next != nullptr && ptr->next->data != data) {
                ptr = ptr->next;
            }

            if (ptr->next->data == data) {
                // ptr->next is a node to be deleted
                Node* temp = ptr->next;
                ptr->next = ptr->next->next;
                delete temp;
                // delete takes pointer variable to free the given memory address 
                return 1;
            }
        }
        return 0;
    }

    int remove2(int data) {
        Node* ptr;
        Node* prev;

        ptr = this->head;
        prev = this->head;
        
        if (this->head->data == data) {
            Node* ptr = this->head->next;
            delete this->head;
            this->head = ptr;
            return 1;
        }
        
        while (ptr != nullptr && ptr->data != data) {
            prev = ptr;
            ptr = ptr->next;
        }

        if (ptr != nullptr) {
            prev->next = ptr->next;
            delete ptr;
            return 1;
        }
        return 0;
    }

    // Output Function ---------------------------------------------------------

    void print() {
        Node* ptr = this->head;

        while (ptr != nullptr) {
            printf("value: %d\n", ptr->data);
            ptr = ptr->next;
        }
    }

    string printList() {
        string str = "*** Singly List ***\nhead ->";
        Node* ptr = this->head;

        while (ptr != nullptr) {
            str += to_string(ptr->data) + " -> ";
            ptr = ptr->next;
        }

        return str + "null\n";
    }
};
