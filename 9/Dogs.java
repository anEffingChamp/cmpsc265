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

 // -------------------------------------------------------------
 public Dogs(int size)       // constructor
   {
  arraySize = size;
  hashArray = new String[arraySize];
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

 // -------------------------------------------------------------
 public int hashFunc(String key) {
  // YOUR CODES
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
        stringInteger +=
            (int) input.charAt(loop) * Math.pow(26, input.length() - loop - 1);
    }
    int hash = stringInteger % this.arraySize;
    if (null == this.hashArray[hash]) {
        this.hashArray[hash] = input;
        return;
    }
    int loop      = 1;
    int hashProbe = hash + (int) Math.pow(loop, 2);
    while (null != this.hashArray[hashProbe % this.arraySize]) {
        loop++;
        hashProbe = hash + (int) Math.pow(loop, 2);
    }
    this.hashArray[hashProbe % this.arraySize] = input;
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
    int aKey, size, n, keysPerCell;

    //get the size of the HashTable
    Scanner console = new Scanner(System.in);
    System.out.print("Enter size of hash table: ");
    size = console.nextInt();

          //make the table
    Dogs table = new Dogs(size);
    table.insert("apple");
    table.insert("book");
    table.insert("car");
    table.insert("dog");
    table.insert("egg");
    table.insert("fish");
    table.insert("giraff");
    table.insert("horse");
    table.insert("ice");
    table.insert("jungle");

    // display the table
    table.displayTable();
}
}
