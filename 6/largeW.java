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
    largeW.list = largeW.mergeSort(input);
    for (Integer element: largeW.list) {
        System.out.println(element);
    }
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
        largeW.largeW(fileIntegers);
    } catch(FileNotFoundException exception) {
        System.out.println("The file was not found.");
        return;
    }
}
/**
 * mergeSort() sorts largeW.list with the three way merge technique as described
 * on https://en.wikipedia.org/wiki/Merge_sort#Algorithm.
 */
public static ArrayList<Integer> mergeSort(ArrayList<Integer> input)
{
    /*
     * We start by compiling the subdivion of the input list that we have
     * specified with the start and end arguments.
     */
    switch (input.size()) {
    /*
     * We can just return the list if has only one item. A single item is
     * already sorted.
     */
    case 0:
    case 1:
        return input;
    /*
     * If there are two, we can check them. They may already be sorted. If not,
     * we append the larger item to the end of the list, and remove it from the
     * front.
     */
    case 2:
        if (input.get(1) < input.get(0)) {
            input.add(input.get(0));
            input.remove(0);
        }
        return input;
    default:
    }
    /*
     * This is where we distinguish a three way from two way merge. We calculate
     * the midPoint as one third of the range, and can easily multiply it by 2
     * for the second third.
     */
    int midPoint = input.size() / 3;
    return largeW.mergeResults(
        largeW.mergeSort(new ArrayList<Integer>(input.subList(0, midPoint - 1))),
        largeW.mergeSort(
            new ArrayList<Integer>(input.subList(midPoint, midPoint * 2))
        ),
        largeW.mergeSort(
            new ArrayList<Integer>(
                input.subList((midPoint * 2) + 1, input.size())
            )
        )
    );
}
/**
 * mergeResults() accepts three ArrayList as arguments, and merges them into a
 * single sorted array. mergeResults() is the complement to mergeSort().
 */
private static ArrayList<Integer> mergeResults(
    ArrayList<Integer> inputFirst,
    ArrayList<Integer> inputSecond,
    ArrayList<Integer> inputThird
)
{
    ArrayList<Integer> output = new ArrayList<Integer>();
    while (false == inputFirst.isEmpty()
    ||  false    == inputSecond.isEmpty()
    || false     == inputThird.isEmpty()
    ) {
        int targetValue = Integer.MIN_VALUE,
        targetList      = 0;
        if (false == inputFirst.isEmpty()) {
            targetValue = inputFirst.get(0);
            targetList  = 1;
        }
        if (false       == inputSecond.isEmpty()
        &&  (targetValue   == Integer.MIN_VALUE
            || targetValue >= inputSecond.get(0)
        )) {
            targetValue = inputSecond.get(0);
            targetList  = 2;
        }
        if (false       == inputThird.isEmpty()
        &&  (targetValue     == Integer.MIN_VALUE
            ||  targetValue >= inputThird.get(0)
        )) {
            targetValue = inputThird.get(0);
            targetList  = 3;
        }
        output.add(targetValue);
        switch (targetList) {
        case 3:
            inputThird.remove(0);
            continue;
        case 2:
            inputSecond.remove(0);
            continue;
        case 1:
        default:
            if (true == inputFirst.isEmpty()) {
                return output;
            }
            inputFirst.remove(0);
        }
    }
    return output;
}
}
