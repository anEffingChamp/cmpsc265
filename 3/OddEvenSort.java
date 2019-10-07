import java.util.*;
/**
 * Another simple sorting algorithmis the odd-even sort. The idea is to
 * repeatedly make two passes through the array. On the first pass you look at
 * all the pairs of items, a[j] and a[j+1], where j is odd (j = 1, 3, 5, ...).
 * If their key values are out of order, you swap them. On the second pass you
 * do the same for all the even values,comparing all a[j] and a[j+1] pairs (j =
 * 2, 4, 6, ...), and do swap if they are out of order.  You do these two passes
 * repeatedly until the array is sorted.  Please modify the provided
 * OddEvenSort.java file to implement this.Feel free to add other methods if you
 * need.
 */
class OddEvenSort
{
/**
 * sort() sorts an array of integers with the odd even sorting method.
 */
public static void sort(int[] arr)
{
    arr = loopArray(arr, 0, arr.length - 2);
    arr = loopArray(arr, 1, arr.length - 1);
    for (int loop  = 0;
    loop          <= arr.length - 2;
    loop          += 2
    ) {
        if (arr[loop] > arr[loop + 1]) {
            OddEvenSort.sort(arr);
        }
    }
}
public static int[] loopArray(int[] array, int loopStart, int loopEnd)
{
    int[] output = array;
    for (int loop  = loopStart;
    loop          <= loopEnd;
    loop          += 2
    ) {
        if (loop == output.length - 1) {
            break;
        }
        if (output[loop] > output[loop + 1]) {
            int valueTemporary = output[loop];
            output[loop]       = output[loop + 1];
            output[loop + 1]   = valueTemporary;
        }
    }
    return output;
}
public static void main(String[] args)
{
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