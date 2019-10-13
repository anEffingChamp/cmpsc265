import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * Description:
 * Instead of dividing into half at each step, you are now supposed to divide
 * recursively the initial array into thirds, sort each third, and then combine
 * using a 3-way merge. Please implement a MergeSort3Way class so that arrays
 * can besorted by using Merge Sort 3-Way.Please read the numbers from the
 * attached largeW.txtfile into an array, apply the 3-way sorting, and output
 * the sorted results into a file largeWResults.txt
 */
public class largeW
{
static private ArrayList<Integer> list;
/**
 * largeW() as an object constructor simply builds the object. It assigns the
 * array list to an object property, then immediately calls largeW.mergeSort()
 * to sort the list.
 */
public static void largeW(ArrayList<Integer> input)
{
    largeW.list = largeW.mergeSort(input, 0, input.size());
    return;
}
public static void main(String[] args)
{
    try {
        /*
         * We read the file according to the instructions at Java67.
         * https://www.java67.com/2012/11/how-to-read-file-in-java-using-scanner-example.html
         */
        Scanner fileInput = new Scanner(new File("largeW.txt"));
        ArrayList<Integer> fileIntegers = new ArrayList<Integer>();
        while (true == fileInput.hasNext()) {
            fileIntegers.add(Integer.valueOf(fileInput.next()));
        }
        for (Integer element: fileIntegers) {
        }
    } catch(FileNotFoundException exception) {
        System.out.println("The file was not found.");
        return;
    }
}
/**
 * mergeSort() sorts largeW.list with the three way merge technique as described
 * on https://en.wikipedia.org/wiki/Merge_sort#Algorithm.
 */
public static ArrayList<Integer> mergeSort(
    ArrayList<Integer> input,
    int inputStart,
    int inputEnd
)
{
    ArrayList<Integer> output = input;
    if (1 >= inputStart - inputEnd) {
        return input;
    }
    /*
     * This is where we distinguish a three way from two way merge. We calculate
     * the midPoint as one third of the range, and can easily multiply it by 2
     * for the second third.
     */
    int midPoint = (inputStart + inputEnd) / 3;
    return largeW.mergeResults(
        largeW.mergeSort(input, inputStart, midPoint),
        largeW.mergeSort(input, midPoint + 1, midPoint * 2),
        largeW.mergeSort(input, (midPoint * 2) + 1, inputEnd)
    );
}
private static ArrayList<Integer> mergeResults(
    ArrayList<Integer> inputFirst,
    ArrayList<Integer> inputSecond,
    ArrayList<Integer> inputThird
)
{
    ArrayList<Integer> output = new ArrayList<Integer>();
    return output;
}
}
