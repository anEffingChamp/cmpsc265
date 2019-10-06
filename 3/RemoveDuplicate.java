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
private static String loopArray(String input, int loopStart, int loopEnd)
{
    String output = "";
    for (int loop  = loopStart;
    loop          <= loopEnd;
    loop          += 2
    ) {
        if (loop == input.length() - 1) {
            break;
        }
        if (input.charAt(loop) != input.charAt(loop + 1)) {
            output += input.charAt(loop);
            output += input.charAt(loop + 1);
        }
    }
    return output;
}
public static void main(String[] args)
{
    Scanner userInput = new Scanner(System.in);
    System.out.print("Please enter a string: ");
    String output = RemoveDuplicate.remove(userInput.next());
    System.out.println(
        "After removing all adjacent characters, the string is " + output
    );
}
public static String remove(String input)
{
    String output = input;
    output        = RemoveDuplicate.loopArray(output, 0, output.length() - 2);
    output        = RemoveDuplicate.loopArray(output, 1, output.length() - 1);
    for (int loop = 0;
    loop < output.length() - 1;
    loop++
    ) {
        if (output.charAt(loop) == output.charAt(loop + 1)) {
            output = RemoveDuplicate.remove(output);
        }
    }
    return output;
}
}
