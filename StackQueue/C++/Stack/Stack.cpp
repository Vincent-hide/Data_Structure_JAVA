#include <string>
#include <iostream>
#include <sstream>

using namespace std;

class Stack {
    private:
        int top;
        int size;
        int* arr;

    public:
        Stack(int size) {
            this->top = 0;
            this->size = size;
            this->arr = new int[this->size];
            for(int i=0; i<this->size; i++) {
                this->arr[i] = 0;
            }
        }

        ~Stack() {
            delete[] this->arr;
        }

        bool isEmpty() {
            if(this->top == 0)
                return true;
            return false;
        }

        bool isFull() {
            if(this->top == 5)
                return true;
            return false;
        }

        bool push(int val) {
            if(this->isFull())
                return false;

            this->arr[this->top++] = val;
            return true;
        }

        int  pop() {
            if(this->isEmpty())
                return -1;
            int popped = this->arr[this->top--];
            return popped;
        }

        int count() {
            return this->top;
        }

        int peek() {
            if(this->isEmpty())
                return -1;
            return this->arr[this->top];
        }

        // switch the value of particular position in the array
        void change(int pos, int val) {
            this->arr[pos] = val;
        }

        string toString() {
            stringstream s;
            for(int i=0; i<this->size; i++) {
                s <<  to_string(this->arr[i]) + " - ";
            }
            return s.str();
        }

        void display() {
            cout << this->size << " ! ";
            for(int i=0; i<this->size; i++) {
                cout << (this->arr[i]);
            }
        }
};