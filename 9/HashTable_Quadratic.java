import java.io.*;
import java.util.*;
/**
 * Description:Please finish definition of the HashTable_Quadratic class, so
 * that a hash table for strings can be built, and using quadratic probingrather
 * than linear-probing to solve collision.To compute for the hash value of a
 * given string, for example, CLRS, you can use the following approach:1)First,
 * We need to first convert the string to be an integer. One way to do this is
 * to use the ASCII value of every character.
 * - ASCII values: C=67, L=76, R=82,
 * S=83.
 * - There are 128 basic ASCII values.
 *   - So, CLRS =67*1283+76 *1282+ 82*1281+
 * 83*1280= 141,764,947.
 * 2)Secondly, transform the integer into an index in the array representing
 * the hash table.  Suppose the size of the hash table is M,
 * - The hash value of 141,764,947 would be:
 * - 141,764,947 % MMake sure you areusing Quadratic probing
 * to solve collision
 */
public class HashTable_Quadratic {
 private String[] hashArray; // array holds hash table
 private int arraySize;

 // -------------------------------------------------------------
 public HashTable_Quadratic(int size)       // constructor
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
            (int) input.charAt(loop) * Math.pow(26, input.length() - loop);
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
    HashTable_Quadratic table = new HashTable_Quadratic(size);
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
