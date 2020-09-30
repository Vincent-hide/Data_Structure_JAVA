package hungrybird;

public class SearchFunctions {
  public static int LinearSearch(int[] arr, int len, int target) {
    for(int i=0; i<len; i++) {
      if(arr[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public static int iterativeBinarySearch(int[] arr, int len, int target) {
    int start = 0;
    int end = len-1;

    while(start <= end) {
      int mid = (start + end) / 2;
      System.out.println(start + " " + end + " " + mid);

      if(arr[mid] == target) return mid;
      else if (target < arr[mid]) end = mid - 1;
      else start = mid + 1;
    }
    return -1;
  }

  public static int recursiveBinarySearch(int[] arr, int len, int target) {
    int start = 0;
    int end = len-1;

    return recursiveBinarySearch(arr, start, end, target, len);
  }

  private static int recursiveBinarySearch(int arr[], int start, int end, int target, int len) {
    int mid = (start + end) / 2;
    if(mid < 0 || mid == len) return -1;

    else if(target == arr[mid]) return mid;
    else if(target < arr[mid]) return recursiveBinarySearch(arr, start, mid - 1, target, len);
    else return recursiveBinarySearch(arr, mid + 1, end, target, len);

  }
}
