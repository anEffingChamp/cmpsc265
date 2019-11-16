import java.io.*;
import java.util.*;
/**
 * You're given strings J representing the types of dogsthat are chihuahua, and
 * S representing the dogsyou have.  Each character in S is a type of dogyou
 * have.  You want to know how many of the dogsyou have are also Chihuahua.You
 * may assume that the letters in J are guaranteed distinct, and all characters
 * in J and S are letters. Letters are case sensitive, so "a" is considered a
 * different type of stone from "A".For example:Input:  J = "aA", S =
 * "aAAbbbb"
 * Output: 3Input:  J = "z",  S =  "ZZ"
 * Output: 0Please write a Java
 * program to implement this. Make sure you are using HashTable (also this
 * would be best choice).
 */
public class Dogs
{
private String[] hashArray; // array holds hash table
private int arraySize;
public String dogs;

public Dogs(int size)       // constructor
{
    arraySize = size;
    hashArray = new String[arraySize];
}
/**
 * displayTable() now checks whether there are any chihuahua characters in a
 * String of this.dogs.
 */
public void displayTable()
{
    for (String element: this.hashArray) {
        System.out.println(element);
    }
}
/*
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
 * insert() adds a value to the HashTable{} with quadratic problem to resolve
 * any collisions.
 */
public void insert(String input) // insert a DataItem
{
    /*
     * We convert the string to an integer first.
     */
    for (int loop = 0;
    loop < input.length();
    loop++
    ) {
        int hash = (int) input.charAt(loop) % this.arraySize;
        if (null == this.hashArray[hash]) {
            this.hashArray[hash] = input;
            return;
        }
        int whileLoop      = 1;
        int hashProbe = hash + (int) Math.pow(whileLoop, 2);
        while (null != this.hashArray[hashProbe % this.arraySize]) {
            whileLoop++;
            hashProbe = hash + (int) Math.pow(whileLoop, 2);
        }
        this.hashArray[hashProbe % this.arraySize] = input;
    }
}
  // -------------------------------------------------------------

 public String delete(String key) // delete a DataItem
 {  // YOUR CODES
  return null; // For compilation. You need to change it.

 } // end delete()
  // -------------------------------------------------------------
/**
 * find() accepts a String input, and verifies whether it is in the
 * this.hashArray or not. If not, it returns empty string.
 */
public String find(String key) // find item with key
{
    return null; // For compilation. You need to change it.
}
public static void main(String[] args) throws IOException
{
    //get the size of the HashTable
    Scanner console = new Scanner(System.in);
    System.out.println("Which characters represent chihuahuas? ");
    String userInput = console.next();
    Dogs table       = new Dogs(userInput.length());
    table.insert(userInput);
    System.out.println("Which characters do we have? ");
    table.dogs       = console.next();

    // display the table
    table.displayTable();
}
}
