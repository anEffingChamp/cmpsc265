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
/*
 * You are expectedto implement the removeMax()method, so that the item in the
 * array with the largest value can be returned, and it will also be removed
 * from the array.  Return -1 if the array is empty.If there are duplicate
 * maximum values, please remove all of them.
 */
public long removeMax()
{
    long highValue  = Long.MIN_VALUE;
    int[] highIndex = new int[nElems];
    int highCount   = 0;
    /*
     * We loop once to find the highest value in the array. We note its value,
     * and its position.
     */
    for (int loop = 0;
    loop < nElems;
    loop++
    ) {
        if (highValue < a[loop]) {
            highValue    = a[loop];
            highIndex    = new int[nElems - loop];
            highCount    = 0;
            highIndex[0] = loop;
        }
        if (highValue == a[loop]) {
            highCount++;
            highIndex[highCount] = loop;
        }
    }
    /*
     * We exit early if the array was never initialized with any values.
     */
    if (0      == highValue
    &&  nElems == highCount
    ) {
        return -1;
    }
    /*
     * Now we can overwrite it with the subsequent value, and move all other
     * values one index lower in the array. Then we decrement nElems since the
     * last value is no longer meaningful.
     */
    int nextValue = 1;
    for (int loop = highIndex[0];
    loop < nElems;
    loop++
    ) {
        if (highValue == a[loop + nextValue]) {
            nextValue++;
        }
        a[loop] = a[loop + nextValue];
    }
    nElems = nElems - highCount;
    return highValue;
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
