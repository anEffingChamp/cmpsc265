class HighArray {
private long[] a;                 // ref to array a
private int nElems;               // number of data items

//-----------------------------------------------------------
public HighArray(int max)  {       // constructor
  a = new long[max];                 // create the array
  nElems = 0;                        // no items yet
}
//-----------------------------------------------------------

public boolean find(long searchKey) { // find specified value
  int j;
  for(j=0; j<nElems; j++)            // for each element,
    if(a[j] == searchKey)           // found item?
    break;                       // exit loop before end
  if(j == nElems)                    // gone to end?
     return false;                   // yes, can't find it
  else
    return true;                    // no, found it
}  // end find()
//-----------------------------------------------------------

public void insert(long value) {    // put element into array
  a[nElems] = value;             // insert it
  nElems++;                      // increment size
}
//-----------------------------------------------------------

public boolean delete(long value) {
  int j;
  for (j=0; j<nElems; j++)        // look for it
    if (value == a[j]) break;
  if (j==nElems)                  // can't find it
    return false;
  else  {                        // found it
    for(int k=j; k<nElems; k++) // move higher ones down
      a[k] = a[k+1];
    nElems--;                   // decrement size
    return true;
  }
}  // end delete()
//-----------------------------------------------------------

public void display() {             // displays array contents
 for (int j=0; j<nElems; j++)       // for each element,
   System.out.print(a[j] + " ");  // display it
 System.out.println("");
}
//-----------------------------------------------------------

public int removeMax() {
 // YOUR CODES
 return -1;  // this is to get the program successfully compiled. You need to change it.
}

public static void main(String[] args) {
 int maxSize = 100;            // array size
 HighArray arr;                // reference to array
 arr = new HighArray(maxSize); // create the array

 arr.insert(77);               // insert 10 items
 arr.insert(99);
 arr.insert(44);
 arr.insert(55);
 arr.insert(22);
 arr.insert(88);
 arr.insert(11);
 arr.insert(00);
 arr.insert(99);
 arr.insert(66);
 arr.insert(33);

 System.out.println("The original array is:");
 arr.display();

 System.out.println("The maximum value is " + arr.removeMax());
 System.out.println("The array after removing the maximum value is:");
 arr.display();

 System.out.println("The maximum value is " + arr.removeMax());
 System.out.println("The array after removing the maximum value is:");
 arr.display();

 System.out.println("The maximum value is " + arr.removeMax());
 System.out.println("The array after removing the maximum value is:");
 arr.display();

}  // end main()
}  // end class HighArray
