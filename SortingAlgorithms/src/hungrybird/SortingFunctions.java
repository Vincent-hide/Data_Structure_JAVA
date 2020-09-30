package hungrybird;

public class SortingFunctions {
  public static void selectionSort(int[] arr, int len) {
    for(int i=0; i<len-1; i++) {
      for(int k=i+1; k>0; k--) {
        if(arr[k-1] > arr[k]) {
          int temp = arr[k-1];
          arr[k-1] = arr[k];
          arr[k] = temp;
        }
      }
    }
  }

  public static void insertionSort(int[] arr, int len) {
    for(int i=1; i<len; i++) {
      int k = i;
      int curr = arr[i];

      while(k-1 >= 0 && curr < arr[k-1])
        arr[k] = arr[k-- -1];

      arr[k] = curr;
    }
  }

}
