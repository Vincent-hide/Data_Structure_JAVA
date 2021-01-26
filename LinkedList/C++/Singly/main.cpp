#include <cstdlib>
#include <iostream>
#include "Linked.cpp"

using namespace std;

int main(int argc, char** argv) {

    Linked list1;
    list1.shift(5);
    list1.shift(10);
    list1.shift(15);
    list1.push(0);
    
    list1.remove2(15);
    cout << list1.printList();
    
    cout << "---------------------------------------------------------------\n";
    
    Linked* list = new Linked();
    list->push(12);
    delete list;
    
    Linked list2;
    list2.shift(2);
    Linked list3;
    list3.shift(3);
    
    list2.print();
    list3.print();
    
    Linked* list4 = list2 + &list3;
    
    cout << list4->printList();

    return 0;
}

