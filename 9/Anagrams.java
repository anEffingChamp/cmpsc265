import java.io.*;
import java.util.*;
/**
 * Given an array of strings, group anagrams together.Example:Input: ["eat",
 * "tea", "tan", "ate", "nat",
 * "bat"],Output:[["ate","eat","tea"],["nat","tan"],["bat"]]Anagram is a word,
 * phrase, or name formed by rearranging the letters of another, suchas cinema,
 * formed from iceman (both contain the letter as 'c', 'i', 'n', 'e', 'm', 'a',
 * but in different order). Therefore, cinema and iceman are anagram of each
 * other.Please write a Java program using to implement this. Make sure you are
 * using HashTable (actually that would also be the best choice).
 */
public class Anagrams {
/**
 * this.hashArray is a two dimensional array to hold strings.
 */
private String[][] hashArray;
/**
 * hashes holds the integer values assigned to a given index in
 * Anagrams.hashArray. This means that I will not have to recalculate the hash
 * to verify an anagram when finding indices.
 */
private int[] hashes;
private int arraySize;
/**
 * Anagrams.list is a two dimensional linked list of strings. We have no
 * initial idea of how many distinct strings the user will add, so we need the
 * room to expand along the X axis.
 *
 * Once we determine that two strings are anagrams, we can them add them along
 * the Y axis.
 */
private LinkedList<LinkedList<String>> list;
public Anagrams(int input)       // constructor
{
    /*
     * We assign the total number of members initially. In this assignment we
     * already know based on how many strings the user submitted. This is
     * important, because we use this size to calculate the hash for each
     * string.
     */
    this.arraySize = input;
    this.hashArray = new String[input][input];
    this.hashes    = new int[input];
}

 // -------------------------------------------------------------
 public void displayTable() {
  System.out.print("Table: ");
  for (int j = 0; j < arraySize; j++) {
   if (hashArray[j] != null)
    System.out.print(hashArray[j] + " ");
   else
    System.out.print("** ");
  }
  System.out.println("");
 }
/**
 * hashFunc() turns a string into a hashed integer for comparison with other
 * strings to evaluate whether they are anagrams.
 */
public int hashFunc(String input)
{
    int stringInteger = 0;
    for (int loop = 0;
    loop < input.length();
    loop++
    ) {
        stringInteger += (int) input.charAt(loop);
    }
    return stringInteger;
}
/**
 * insert() adds a value to the Anagrams{} with quadratic problem to resolve
 * any collisions.
 */
public void insert(String input) // insert a DataItem
{
    /*
     * We convert the string to an integer first.
     */
    int stringInteger = this.hashFunc(input);
    int hashInitial   = stringInteger % this.arraySize;
    /**
     * Lets find an appropriate position using quadratic increments.
     */
    int loop      = -1;
    int hashProbe = hashInitial;
    while (0          != this.hashes[hashProbe]
    &&  stringInteger != this.hashes[hashProbe]
    ) {
        loop++;
        hashProbe = hashInitial + (int) Math.pow(loop, 2);
        /*
         * We have found a matching stringInteger, so we can add it to this
         * position in the hash table. We already know that index 0 is occupied,
         * so we can start at 1 to find an open position.
         */
        if (stringInteger == this.hashes[hashProbe]) {
            for (int stringLoop = 1;
            stringLoop < this.arraySize;
            stringLoop++
            ) {
                if (null == this.hashArray[hashProbe][stringLoop]) {
                    this.hashArray[hashProbe][stringLoop] = input;
                    return;
                }
            }
        }
        /*
         * We can insert the first string in a series if we have found a blank
         * initial index in the hash table.
         */
        if (0 == this.hashes[hashProbe]) {
            this.hashes[hashProbe]       = stringInteger;
            this.hashArray[hashProbe][0] = input;
            return;
        }
    }
}
  // -------------------------------------------------------------

 public String delete(String key) // delete a DataItem
 {  // YOUR CODES
  return null; // For compilation. You need to change it.

 } // end delete()
  // -------------------------------------------------------------

 public String find(String key) // find item with key
 {  // YOUR CODES
  return null; // For compilation. You need to change it.
 }

 // -------------------------------------------------------------
 // end class HashTable

public static void main(String[] args) throws IOException
{
    Scanner userConsole   = new Scanner(System.in);
    System.out.print("Please enter a series of strings separated by a space: ");
    String[] userInput    = userConsole.next().split(" ");
    Anagrams anagramTable = new Anagrams(userInput.length);
    for (String element: userInput) {
        anagramTable.insert(element);
    }
    anagramTable.displayTable();
}
}
