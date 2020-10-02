package hungrybird;

public class Main {

  public static void print(int[] arr) {
    for (int i : arr) {
      System.out.printf("Item: %d\n", i);
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[5];

    arr[0] = 84;
    arr[1] = 11;
    arr[2] = 5;
    arr[3] = 77;
    arr[4] = 65;

    SortingFunctions.quickSort(arr, 5);
    print(arr);
  }
}
