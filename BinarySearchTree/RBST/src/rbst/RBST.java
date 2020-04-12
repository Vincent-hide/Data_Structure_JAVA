package rbst;

public class RBST {

    public static void main(String[] args) {
        BST bst = new BST();

        bst.insert("P");
        bst.insert("F");
        bst.insert("S");
        bst.insert("B");
        bst.insert("H");
        bst.insert("G");
        bst.insert("R");
        bst.insert("Y");
        bst.insert("T");
        bst.insert("W");
        bst.insert("Z");

        System.out.println(bst.root());
        System.out.println(bst.inOrder());

        System.out.printf("This binary tree %s %s\n", bst.contains("A") ? "contains" : "does not contain", "A");
        System.out.printf("This binary tree %s %s\n", bst.contains("F") ? "contains" : "does not contain", "F");
        System.out.printf("This binary tree %s %s\n\n", bst.contains("S") ? "contains" : "does not contain", "S");

        bst.deleteSuccessor("S");

        System.out.println(bst.inOrder());
        System.out.printf("This binary tree %s %s\n\n", bst.contains("S") ? "contains" : "does not contain", "S");
        System.out.println(bst.levelOrder());

    }

}
