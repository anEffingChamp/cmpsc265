public class OrdArray {
private long[] a;                 // ref to array a
private int nElems;               // number of data items

//-----------------------------------------------------------
public OrdArray(int max) {          // constructor
 a = new long[max];             // create array
 nElems = 0;
}
//-----------------------------------------------------------

public int size() {
 return nElems;
}
//-----------------------------------------------------------

public int find(long searchKey) {
 int lowerBound = 0;
 int upperBound = nElems-1;
 int curIn;

 while(true) {
   curIn = (lowerBound + upperBound ) / 2;
   if (a[curIn]==searchKey)
     return curIn;              // found it
   else if (lowerBound > upperBound)
     return nElems;             // can't find it
   else {                         // divide range
     if (a[curIn] < searchKey)
       lowerBound = curIn + 1; // it's in upper half
     else
       upperBound = curIn - 1; // it's in lower half
   }  // end else divide range
 }  // end while
}  // end find()

//-----------------------------------------------------------
public void insert(long value) {   // put element into array
  int j;
  for (j=0; j<nElems; j++)        // find where it goes
    if (a[j] > value)            // (linear search)
    break;
  for (int k=nElems; k>j; k--)    // move bigger ones up
     a[k] = a[k-1];
  a[j] = value;                  // insert it
  nElems++;                      // increment size
}  // end insert()

//-----------------------------------------------------------
public boolean delete(long value) {
  int j = find(value);
  if (j==nElems)                  // can't find it
     return false;
  else                           // found it
     {
     for(int k=j; k<nElems; k++) // move bigger ones down
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
 * Implement the merge()method to the OrdArray class so that you can merge two
 * ordered arrays into an ordered destination array and return that array
 */
public void merge(OrdArray arr)
{
    long[] input     = arr.a;
    int outputLength = nElems + arr.size();
    long[] output    = new long[outputLength];
    int[] inputIndex = new int[2];
    for (int loop = 0;
    loop < outputLength;
    loop++
    ) {
        if (inputIndex[0] + inputIndex[1] < outputLength) {
            if (inputIndex[0] < nElems
            &&  a[inputIndex[0]] < input[inputIndex[1]]
            ) {
                output[loop] = a[inputIndex[0]];
                if (inputIndex[0] < nElems) {
                    inputIndex[0]++;
                }
            } else if (inputIndex[1] < arr.size()) {
                output[loop] = input[inputIndex[1]];
                if (inputIndex[1] < arr.size()) {
                    inputIndex[1]++;
                }
            }
        }
    }
    for (int loop = 0;
    loop < outputLength;
    loop++
    ) {
        System.out.print(output[loop] + " ");  // display it
    }
    System.out.println("");
    return;
}
/*
 * Write code in the main()method to create two ordered arrays with arbitrary
 * values, invoke the merge()method, and display the contents of the resulting
 * destination array.
 */
public static void main(String[] args)
{
    int count          = 10;
    OrdArray firstOrd  = new OrdArray(count);
    OrdArray secondOrd = new OrdArray(count);
    for (int loop = 0;
    loop < count;
    loop++
    ) {
        firstOrd.insert(loop);
        secondOrd.insert(loop * 2);
    }
    System.out.println("The first ordered array is:");
    firstOrd.display();
    System.out.println("The second ordered array is:");
    secondOrd.display();
    System.out.println("The merged ordered array is:");
    firstOrd.merge(secondOrd);
}
}  // end class OrdArray
