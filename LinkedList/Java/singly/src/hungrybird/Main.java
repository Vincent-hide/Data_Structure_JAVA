package hungrybird;

public class Main {

  public static void main(String[] args) {
    List linkedList = new List();

    linkedList.addFront(10);
    linkedList.addFront(11);
    linkedList.addFront(12);
    linkedList.addFront(13);

    linkedList.print2();

    System.out.println("----------------------------");

    List reversed = linkedList.flip();
    reversed.print2();
  }
}
