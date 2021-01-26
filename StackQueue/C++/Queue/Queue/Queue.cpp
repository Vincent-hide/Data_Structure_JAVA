#include <iostream>

class Queue {
	private:
		int front;
		int rear;
		int size;
		int* arr;

	public:
		Queue(int size) {
			this->front = -1;
			this->rear = -1;
			this->size = size;
			this->arr = new int[size];
			
			for (int i = 0; i < size; i++) {
				this->arr[i] = 0;
			}
		}

		bool isEmpty() {
			return this->front == -1 && this->rear == -1;
		}

		bool isFull() {
			return this->rear == this->size - 1;
		}

		bool enqueue(int value) {
			if (this->isFull())
				return false;
			
			if (this->isEmpty()) {
				this->rear = this->front = 0;
				this->arr[this->rear] = value;
			}
			else {
				this->rear++;
				this->arr[this->rear] = value;
			}
			return true;
		}

		int dequeue() {
			if (this->isEmpty()) {
				return 0;
			}

			if (this->front == this->rear) {
				int x = this->arr[this->front];
				this->rear = this->front = -1;
				this->arr[this->front] = 0;
				return x;
			}
			else {
				int x = this->arr[this->front];
				this->arr[this->front] = 0;
				this->front++;
				return x;
			}
		}

		int count() {
			return (this->rear == -1 && this->front == -1) ? 0 : this->rear - this->front + 1;
		}
};