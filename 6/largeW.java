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
    } catch(FileNotFoundException exception) {
        System.out.println("The file was not found.");
        return;
    }
}
}
