#pragma once

class BST {

public: 
	struct node {
		int key;
		node* left;
		node* right;
	};
	node* root;

	private:
		/*struct node {
			int key;
			node* left;
			node* right;
		};*/

		/*node* root;*/

		bool AddLeafPrivate(int key, node* ptr);
		std::string PrintInOrderPrivate(node* node);
		void displayNodes(node* node);

	public:
		BST();
		node* CreateLeaf(int key);
		bool AddLeaf(int key);
		std::string PrintInOrder();
		void displayNodes();
};