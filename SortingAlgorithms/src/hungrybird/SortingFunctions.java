package hungrybird;

import java.util.Random;

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

  public static void mergeSort(int[] arr, int len) {
    split(arr, 0, len-1);
  }

  private static void split(int[] arr, int start, int end) {
    if(start < end) {
      int mid = (start + end) / 2;

      split(arr, start, mid);
      split(arr,mid+1, end);
      mergeSort(arr, start, mid, end);
    }
  }

  private static void mergeSort(int[] arr, int start, int mid, int end) {
    int leftSize = mid - start + 1;
    int rightSize = end - mid;

    int[] leftArr = new int[leftSize];
    int[] rightArr = new int[rightSize];

    for(int i=0; i<leftSize; i++) {
      leftArr[i] = arr[i+start];
    }

    for(int i=0; i<rightSize; i++) {
      rightArr[i] = arr[i+mid+1];
    }

    int leftIndex = 0;
    int rightIndex = 0;
    int newIndex = start;

    while(leftIndex < leftSize && rightIndex < rightSize) {
      if(leftArr[leftIndex] < rightArr[rightIndex]) {
        arr[newIndex++] = leftArr[leftIndex++];
      } else {
        arr[newIndex++] = rightArr[rightIndex++];
      }
    }

    while(leftIndex < leftSize) {
      arr[newIndex++] = leftArr[leftIndex++];
    }

    while(rightIndex < rightSize) {
      arr[newIndex++] = rightArr[rightIndex++];
    }
  }
  
  public static void quickSort(int[] arr, int len) {
    quickSort(arr, 0, len-1);
  }

  private static void quickSort(int[] arr, int start, int end) {
    if(start >= end) return;

    int randomIndex = generateRandomNum(end, start);
    int pivot = arr[randomIndex];
    int index = partition(arr, start, end, pivot);

    quickSort(arr, start, index-1);
    quickSort(arr, index, end);

  }

  public static int partition(int[] arr, int start, int end, int pivot) {
    while(start <= end) {
      while(arr[start] < pivot) {
        start++;
      }

      while(arr[end] > pivot) {
        end--;
      }

      if(start <= end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
      }
    }
    return start;
  }

  public static int generateRandomNum(int max, int min) {
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
  }
}
