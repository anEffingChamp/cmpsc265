import java.util.*;
/**
 * Description
 * Given a string S, a duplicate removal consists of choosing two
 * adjacent and equal letters, and removing them.We can repeatedly make
 * duplicate removals on S until we no longer can.
 *
 * Please write a program that
 * can read in an arbitrary string entered by users, and remove all the adjacent
 * duplicate characters in the string.   The program will then output thefinal
 * resulting string onto screen.You may assume all input strings are in lower
 * case.
 *
 * Specification
 * Two methods are needed in this RemoveDuplicateclass.
 * -main() method
 * -remove()method.
 *
 * main() method:
 * 1)Please read in an arbitrary string from
 * keyboard.
 * 2)Invoke the remove()method to remove all adjacent duplicate
 * characters in the input string.
 * 3)Output the string returned by the remove()method.
 *
 * remove()method
 * -The method has one parameter, which is a string.
 * -The method will remove all adjacent duplicate characters in the given
 * string.
 * -The method will return the resulting string.
 */
class RemoveDuplicate
{
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
}
}
