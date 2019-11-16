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
/**
 * hashes holds the integer values assigned to a given index in
 * Anagrams.hashArray. This means that I will not have to recalculate the hash
 * to verify an anagram when finding indices.
 */
private int[] hashes;
private String[] hashArray; // array holds hash table
private int arraySize;
public String dogs;

public Dogs(int size)       // constructor
{
    arraySize = size;
    this.hashArray = new String[arraySize];
    this.hashes    = new int[size];
}
/**
 * displayTable() now checks whether there are any chihuahua characters in a
 * String of this.dogs.
 */
public void displayTable()
{
    String input = this.dogs;
    int count    = 0;
    for (int loop = 0;
    loop < this.dogs.length();
    loop++
    ) {
        int hashProbe = Integer.parseInt(
            this.find(String.valueOf(input.charAt(loop)))
        );
        if (null != this.hashArray[hashProbe]) {
            count++;
        }
    }
    System.out.println("There are " + count + " chihuahuas in the pack.");
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
        int characterInteger = (int) input.charAt(loop);
        int hash             = characterInteger % this.arraySize;
        if (null == this.hashArray[hash]) {
            this.hashArray[hash] = input;
            return;
        }
        int hashProbe = Integer.parseInt(
            this.find(String.valueOf(input.charAt(loop)))
        );
        this.hashes[hashProbe]    = characterInteger;
        this.hashArray[hashProbe] = input;
    }
}
  // -------------------------------------------------------------

 public String delete(String key) // delete a DataItem
 {  // YOUR CODES
  return null; // For compilation. You need to change it.

 } // end delete()
  // -------------------------------------------------------------
/**
 * find() uses quadratic probing to find an appropriate index in the hash table
 * to insert a value.
 */
// TODO Why should this function return a String, rather than the numeric index
// for the appropriate hash? String should be the argument, not the return
// result.
public String find(String input) // find item with key
{
    int stringInteger = this.hashFunc(input);
    int hashInitial   = stringInteger % this.arraySize;
    System.out.println(input);
    System.out.println(stringInteger);
    System.out.println(hashInitial);
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
    }
    this.hashes[hashProbe] = stringInteger;
    return String.valueOf(hashProbe);
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
