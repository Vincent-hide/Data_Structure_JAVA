#include <iostream>

class CircularQueue {
	private:
		int front;
		int rear;
		int size;
		int* arr;
		int itemCount;

	public:
		CircularQueue(int size) {
			this->front = -1;
			this->rear = -1;
			this->size = size;
			this->arr = new int[size];
			this->itemCount = 0;

			for (int i = 0; i < size; i++) {
				this->arr[i] = 0;
			}
		}

		bool isEmpty() {
			return this->front == -1 && this->rear == -1;
		}

		bool isFull() {
			return (this->rear + 1) % this->size == this->front;
		}

		bool enqueue(int value) {
			if (this->isFull())
				return false;

			if (this->isEmpty()) {
				this->rear = this->front = 0;
				this->arr[this->rear] = value;
			}
			else {
				this->rear = (this->rear + 1) % this->size;
				this->arr[this->rear] = value;
			}
			this->itemCount++;
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
				this->itemCount--;
				return x;
			}
			else {
				int x = this->arr[this->front];
				this->arr[this->front] = 0;
				this->front++;
				this->itemCount--;
				return x;
			}
		}

		int count() {
			return this->itemCount;
		}

		void print() {
			for (int i = 0; i < this->size; i++) {
				std::cout << this->arr[i] << " ";
			}
		}
};