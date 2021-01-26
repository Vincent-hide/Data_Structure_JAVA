#include <iostream>
#include <string>
#include "Stack.cpp"

using namespace std;

int main() {
    Stack stack(5);

    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    cout << stack.count() << "\n";

    cout << stack.toString();

    return 0;
}