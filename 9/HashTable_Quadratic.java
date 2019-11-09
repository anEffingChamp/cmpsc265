import java.io.*;
import java.util.*;

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

 // -------------------------------------------------------------
 public void insert(String item) // insert a DataItem
 // (assumes table not full)
 {  // YOUR CODES
  
 } // end insert()
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
 
   public static void main(String[] args) throws IOException {
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