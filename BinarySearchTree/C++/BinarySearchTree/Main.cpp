#include <iostream>
#include <stdio.h>
#include "BST.h";

using namespace std;

int main()
{
	BST tree;

	tree.AddLeaf(10);
	tree.AddLeaf(4);
	tree.AddLeaf(55);
	tree.AddLeaf(45);
	tree.AddLeaf(7);
	tree.AddLeaf(78);
	tree.AddLeaf(77);
	tree.AddLeaf(54);
	tree.AddLeaf(14);

	tree.displayNodes();
	//printf("%s", tree.PrintInOrder());
}
//https://youtu.be/z0FDBGbf42Q