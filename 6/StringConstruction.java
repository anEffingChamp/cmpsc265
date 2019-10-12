import java.util.*;
/**
 * Description:Given a set of characters and a positive integer k, print all
 * possible strings of length k that can be formed from the given set.Please
 * implement it using recursion.
 */
public class StringConstruction
{
public static ArrayList<String> getStrings(char[] chars, int k)
{
    // YOUR CODES
    return null;  // For compilation. You need to change this.
}
public static void main(String[] args)
{
    /*
     * We ask the user how long the set of characters should be. Then we ask
     * them to provide the characters in that set.
     */
    Scanner userInput  = new Scanner(System.in);
    System.out.print("How many characters would you like to scramble? ");
    int characterCount = userInput.nextInt();
    char[] characters  = new char[characterCount];
    System.out.println(
        "Please enter a string at least " + characterCount
        + " characters long: "
    );
    /*
     * Now we can build the set from the provided string, and pass it to
     * getStrings(), where the real scrambling begins.
     */
    String userString = userInput.next();
    for (int loop = 0;
    loop < characterCount;
    loop++
    ) {
        characters[loop] = userString.charAt(loop);
    }
    // YOUR CODES TO CALL THE getString() methods and
    // display the results.
}
}
