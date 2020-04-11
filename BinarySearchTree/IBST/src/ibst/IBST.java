package ibst;

public class IBST {

    public static void main(String[] args) {
        BST bst = new BST();
        
        bst.insert(50);
        bst.insert(10);
        bst.insert(20);
        bst.insert(60);
        bst.insert(70);
        bst.insert(55);
        bst.insert(65);
        
        System.out.println(bst.deletePredecessor(60));
                
        System.out.println(bst.inOrder());
        System.out.println(bst.root());
    }

}
