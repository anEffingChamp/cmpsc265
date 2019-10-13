import java.util.*;
/**
 * Description:Given a set of characters and a positive integer k, print all
 * possible strings of length k that can be formed from the given set.Please
 * implement it using recursion.
 */
public class StringConstruction
{
/**
 * getStrings() accepts an array of characters, and returns all of the possible
 * combinations of those characters. It does so by calling
 * StringConstruction.scrambleStrings().
 */
public static ArrayList<String> getStrings(
    char[] inputCharacters,
    int inputCount
)
{
    ArrayList<String> output =
        StringConstruction.scrambleStrings("", new String(inputCharacters));
    return output;
}
/**
 * scrambleStrings() loops through all permutations of the original string, and
 * assembles them into an array list. Then it returns them to getStrings() and
 * main() for printing.
 */
private static ArrayList<String> scrambleStrings(String prefix, String input)
{
    ArrayList<String> output = new ArrayList<String>();
    if (0 == input.length()) {
        /*
         * I learned how to initialize an anonymous ArrayList here.
         * https://howtodoinjava.com/java/collections/arraylist/merge-arraylists
         */
        return new ArrayList<String>(Arrays.asList(prefix));
    }
    for (int loop = 0;
    loop < input.length();
    loop++
    ) {
        String argument = input.substring(0, loop) + input.substring(loop + 1);
        output.addAll(
            StringConstruction.scrambleStrings(
                prefix + input.charAt(loop), argument
            )
        );
    }
    return output;
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
    System.out.println(
       StringConstruction.getStrings(characters, characterCount)
    );
}
}
