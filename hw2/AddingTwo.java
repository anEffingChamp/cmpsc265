import java.util.Scanner;
/*
 * Please write aJavaprogram to first read in an array of integerswith elements
 * obtained from keyboard.  Make sure all the inputs are in ascending order, so
 * that the created array is an ordered array. Given any target number, find in
 * the array two elements that can add up to the target number. Return and
 * display the indexof the two elements onto screen.Return {-1, -1} if no such
 * two elements can be found in the array.
 */
public class AddingTwo
{
private long[] a;                 // ref to array a
private int nElems;               // number of data items
public AddingTwo(int max)
{          // constructor
    a      = new long[max];             // create array
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
/*
 * The method has two parameters: an array of integers, and an int for the
 * target number.
 * -The method will return an array of two numbers, indicating the
 * two indexes of the numbers that can add up to the target number.
 * -Return {-1, -1} if no such two elements exist.
 * -If there ismore than one solution, return any one should be good.
 */
public int[] add(long input)
{
    int[] output = new int[2];
    output[0]    = -1;
    output[1]    = -1;
    for (int loop = 0;
    loop < this.nElems;
    loop++
    ) {
        for (int innerLoop = loop + 1;
        innerLoop < this.nElems;
        innerLoop++
        ) {
            if (this.a[loop] + this.a[innerLoop] == input) {
                output[0] = loop;
                output[1] = innerLoop;
            }
        }
    }
    return output;
}
/*
 * 1)Please read in an array of integers of arbitrary lengths and elements from
 * keyboard.Make sure the inputs are in ascending order.
 * 2)Ask and get the input of an arbitrary target number.
 * 3)Invoke the addingTwo() method, and get the returned indexes.
 * 4)Display the index on screen.
 */
public static void main(String[] args)
{
    Scanner userInput = new Scanner(System.in);
    System.out.print("How many elements in the array?: ");
    int arraySize     = userInput.nextInt();
    AddingTwo addingTwo  = new AddingTwo(arraySize);
    for (int loop = 0;
    loop < arraySize;
    loop++
    ) {
        System.out.print("Please enter one element's value: ");
        addingTwo.insert(userInput.nextLong());
    }
    System.out.print("Please enter a target value: ");
    int[] result = addingTwo.add(userInput.nextLong());
    System.out.print("index: " + result[0] + " " + result[1]);
}
}
