#include <iostream>
#include <cstdlib>
#include <sstream>
#include <string>

#include "BST.h"

using namespace std;

BST::BST() {
	this->root = nullptr;
}

BST::node* BST::CreateLeaf(int key) {
	node* n = new node;
	n->key = key;
	n->left = nullptr;
	n->right = nullptr;

	return n;
}

bool BST::AddLeaf(int key) {
	return this->AddLeafPrivate(key, root);
}

bool BST::AddLeafPrivate(int key, BST::node* ptr) {
	if (this->root == nullptr) {
		this->root = this->CreateLeaf(key);
		return true;
	}

	if (key < ptr->key) {
		if (ptr->left != nullptr) {
			this->AddLeafPrivate(key, ptr->left);
		}
		else {
			ptr->left = this->CreateLeaf(key);
			return true;
		}
	}
	else if(key > ptr->key) {
		if (ptr->right != nullptr) {
			this->AddLeafPrivate(key, ptr->right);
		}
		else {
			ptr->right = this->CreateLeaf(key);
			return true;
		}
	}
	else {
		return false;
	}
}

string BST::PrintInOrder() {
	return PrintInOrderPrivate(this->root);
}

string BST::PrintInOrderPrivate(node* ptr) {
	stringstream s;
	if (this->root != nullptr) {
		if (ptr->left != nullptr) {
			this->PrintInOrderPrivate(ptr->left);
		}
		s << to_string(ptr->key) + " - ";
		if (ptr->right != nullptr) {
			this->PrintInOrderPrivate(ptr->right);
		}
	}
	return s.str();
}

void BST::displayNodes() {
	this->displayNodes(this->root);
}

void BST::displayNodes(node* ptr) {
	if (ptr->left != nullptr) {
		this->displayNodes(ptr->left);
	}
	cout << ptr->key << " - ";
	if (ptr->right != nullptr) {
		this->displayNodes(ptr->right);
	}
	
}