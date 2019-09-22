import java.util.*;

class OddEvenSort {
  public static void sort(int[] arr){
    // YOUR CODES
  }
  
  public static void main(String[] args){
    int[] arr0 = {};
    System.out.println("The original array is:");
    System.out.println(Arrays.toString(arr0));
    System.out.println("After sorting, the array is:");
    sort(arr0);
    System.out.println(Arrays.toString(arr0) + "\n");
    
    int[] arr1 = {-1, 0, 100, 20, 0, 0, -2, 10, 12};
    System.out.println("The original array is:");
    System.out.println(Arrays.toString(arr1));
    System.out.println("After sorting, the array is:");
    sort(arr1);
    System.out.println(Arrays.toString(arr1) + "\n");
    
    int[] arr2 = {20, 18, 16, 14, 12, 10, 8, 6, 4, 2, 0};
    System.out.println("The original array is:");
    System.out.println(Arrays.toString(arr2));
    System.out.println("After sorting, the array is:");
    sort(arr2);
    System.out.println(Arrays.toString(arr2) + "\n");
    
    int[] arr3 = {3, 4, 0, 5, 9, 20, 15, 14, 17, 24, 56, 0, 0, 1};
    System.out.println("The original array is:");
    System.out.println(Arrays.toString(arr3));
    System.out.println("After sorting, the array is:");
    sort(arr3);
    System.out.println(Arrays.toString(arr3) + "\n");
  }
}