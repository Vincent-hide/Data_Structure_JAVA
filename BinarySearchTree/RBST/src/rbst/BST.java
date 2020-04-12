package rbst;

public class BST {

    private Node root;

    public BST() {
        this.root = null;
    }

    public String root() {
        return String.format("Currently root of this tree is %s", this.root.data);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(String key) {
        return contains(key, this.root);
    }

    public boolean contains(String key, Node node) {
        if (node == null) {
            return false;
        }

        if (node.data.compareTo(key) == 0) {
            return true;
        } else if (node.data.compareTo(key) > 0) {
            return this.contains(key, node.left);
        } else {
            return this.contains(key, node.right);
        }

    }

    public void insert(String key) {
        this.root = this.insert(key, this.root);
    }

    private Node insert(String key, Node node) {
        if (node == null) {
            node = new Node(key);
            return node;
        }

        if (node.data.compareTo(key) > 0) {
            node.left = this.insert(key, node.left);
        } else if (node.data.compareTo(key) < 0) {
            node.right = this.insert(key, node.right);
        }

        return node;
    }

    // delete functions ---------------------------------------------------
    
    public void deleteSuccessor(String key) {
        this.root = deleteSuccessor(key, this.root);
    }

    private Node deleteSuccessor(String key, Node node) {
        if (node == null) {
            return node;
        }

        if (node.data.compareTo(key) != 0) {
            if (node.data.compareTo(key) > 0) {
                node.left = this.deleteSuccessor(key, node.left);
            } else {
                node.right = this.deleteSuccessor(key, node.right);
            }
        } else {
            // now node is key. found the node to be deleted
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node successor = this.inOrderSuccessor(node);
            node.data = successor.data;
            node.right = deleteSuccessor(successor.data, node.right); // infinite loop will occur, if this line is not here
        }
        return node;
    }

    private Node inOrderSuccessor(Node node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void deletePredecessor(String key) {
        this.root = deletePredecessor(key, this.root);
    }

    private Node deletePredecessor(String key, Node node) {
        if (node == null) {
            return node;
        }

        if (node.data.compareTo(key) != 0) {
            if (node.data.compareTo(key) > 0) {
                node.left = this.deletePredecessor(key, node.left);
            } else {
                node.right = this.deletePredecessor(key, node.right);
            }
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node predecessor = this.inOrderPredecessor(node);
            node.data = predecessor.data;
            node.left = deletePredecessor(predecessor.data, node.left);
        }
        return node;
    }

    private Node inOrderPredecessor(Node node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // print functions ---------------------------------------------------
    public String inOrder() {
        return inOrder(this.root);
    }

    private String inOrder(Node node) {
        String s = "";
        if (node != null) {
            s += this.inOrder(node.left);
            s += String.format("Value is %s\n", node.data);
            s += this.inOrder(node.right);
        }
        return s;
    }

    public String preOrder() {
        return preOrder(this.root);
    }

    private String preOrder(Node node) {
        String s = "";
        if (node != null) {
            s += String.format("Value is %s\n", node.data);
            s += this.inOrder(node.left);
            s += this.inOrder(node.right);
        }
        return s;
    }

    public String postOrder() {
        return postOrder(this.root);
    }

    private String postOrder(Node node) {
        String s = "";
        if (node != null) {
            s += this.inOrder(node.left);
            s += this.inOrder(node.right);
            s += String.format("Value is %s\n", node.data);
        }
        return s;
    }

    public String levelOrder() {
        return levelOrder(this.root);
    }

    private String levelOrder(Node node) {
        String s = "";
        if (node == null) {
            return s;
        }
        circularQueue q = new circularQueue();
        q.enqueue(node);

        while (!q.isEmpty()) {
            Node temp = q.dequeue();
            s += String.format("Value is %s\n", temp.data);

            if (temp != null && temp.left != null) {
                q.enqueue(temp.left);
            }
            if (temp != null && temp.right != null) {
                q.enqueue(temp.right);
            }
        }
        return s;
    }

}
