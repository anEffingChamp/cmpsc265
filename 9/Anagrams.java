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
private String[] hashArray; // array holds hash table
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
public Anagrams()       // constructor
{
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
public int hashFunc(String key)
{
  return  -1; // For compilation. You need to change it.
}
/**
 * insert() adds a value to the HashTable{} with quadratic problem to resolve
 * any collisions.
 */
public void insert(String input) // insert a DataItem
// (assumes table not full)
{
    /*
     * We convert the string to an integer first.
     */
    int stringInteger = 0;
    for (int loop = 0;
    loop < input.length();
    loop++
    ) {
        stringInteger += (int) input.charAt(loop);
    }
    int hash = stringInteger % this.arraySize;
    if (null == this.hashArray[hash]) {
        this.hashArray[hash] = input;
        return;
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
    Anagrams anagramTable = new Anagrams();
    System.out.print("Please enter a series of strings separated by a space: ");
    while (true == userConsole.hasNext()) {
        anagramTable.insert(userConsole.next());
    }
}
}
