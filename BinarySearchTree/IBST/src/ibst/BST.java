package ibst;

public class BST {

    private Node root;

    public BST() {
        this.root = null;
    }

    public String root() {
        return String.format("Currently the root of this BST is %d", this.root.data);
    }
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    public boolean contains(int key) {
        if(this.root == null) {
            return false;
        }
        
        Node current = this.root;
        
        while(current != null) {
            if(current.data == key) return true;
            if(current.data > key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public void insert(int key) {
        if (this.root == null) {
            this.root = new Node(key);
            return;
        }

        Node parent, current;
        current = parent = this.root;

        while (current != null) {
            parent = current;
            if (current.data > key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (parent.data > key) {
            parent.left = new Node(key);
        } else {
            parent.right = new Node(key);
        }
    }

    public String inOrder() {
        String s = "";
        if (this.root == null) {
            return null;
        }
        Stack stack = new Stack();
        Node current = this.root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            s += String.format("Value: %d\n", current.data);

            current = current.right;

        }

        return s;
    }

    public boolean deleteSuccessor(int key) {
        if (this.root == null) {
            return false;
        }

        if (this.root.data == key) {
            Node node = inOrderSuccessor(this.root);
            node.left = this.root.left;
            node.right = this.root.right;
            this.root = node;
            return true;
        }

        Node current, parent;
        current = parent = this.root;

        while (current != null && current.data != key) {
            parent = current;
            if (current.data > key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current.data != key) {
            return false;
        }

        // Leaf Node
        if (current.left == null && current.right == null) {
            if (parent.data > current.data) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } // Has One Node Attached
        // if both node is null, that will be caught in conditional statement above
        else if (current.left == null || current.right == null) {
            if (current.left == null) {
                if (parent.data > current.data) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            } else {
                if (parent.data > current.data) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            }
        } // Node W/ Two Nodes Attached
        else {
            Node node = inOrderSuccessor(current, parent);
            node.left = current.left;
            node.right = current.right;
            if (parent.data > current.data) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }

        return true;
    }

    // For Root
    private Node inOrderSuccessor(Node node) {
        Node current, parent;
        current = parent = node;
        while (current.left != null) {
            parent = current;
            current = current.left;
        }
        parent.left = null;
        return current;
    }
    
    // Smallest From Right Hand Side
    private Node inOrderSuccessor(Node current, Node parent) {
        while (current.left != null) {
            parent = current;
            current = current.left;
        }
        parent.left = null;
        return current;
    }

    public boolean deletePredecessor(int key) {
        if (this.root == null) {
            return false;
        }

        if (this.root.data == key) {
            Node node = inOrderPredecessor(this.root);
            node.left = this.root.left;
            node.right = this.root.right;
            this.root = node;
            return true;
        }

        Node current, parent;
        current = parent = this.root;

        while (current != null && current.data != key) {
            parent = current;
            if (current.data > key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current.data != key) {
            return false;
        }

        // Leaf Node
        if (current.left == null && current.right == null) {
            if (parent.data > current.data) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } // Has One Node Attached
        else if (current.left == null || current.right == null) {
            if (current.left == null) {
                if (parent.data > current.data) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            } else {
                if (parent.data > current.data) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            }
        } // Node W/ Two Nodes Attached
        else {
            Node node = inOrderPredecessor(current, parent);
            node.left = current.left;
            node.right = current.right;
            if (parent.data > current.data) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }

        return true;
    }

    // For Root
    private Node inOrderPredecessor(Node node) {
        Node current, parent;
        current = parent = node;
        while (current.right != null) {
            parent = current;
            current = current.right;
        }
        parent.right = null;
        return current;
    }
    
    // Biggest From Left Hand Side
    private Node inOrderPredecessor(Node current, Node parent) {
        while (current.right != null) {
            parent = current;
            current = current.right;
        }
        parent.right = null;
        return current;
    }

}
