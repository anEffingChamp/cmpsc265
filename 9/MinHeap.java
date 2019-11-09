/**
 * The attached Min_PrioriyQueue.java file contains the definition of the
 * Min_PriorityQueue class.Please finish the implementation of the method of
 * insert(),trickleUp(),delete()and trickleDown()in the MinHeap class, so that a
 * Min_Heap can be constructed and maintained.Make sure a Min_Heap is a complete
 * binary tree data structure that satisfies the heap ordering property, so that
 * each node's key will be less than (or equal to) the key of its two children,
 * and therefore, the root nodecontains the minimum key.Each time when deleting
 * a node from the MinHeap,  we always delete the root node that contains the
 * minimum key. This shows that MinHeap can provide a good implementation of the
 * Minimum Priority Queue. Please finish the implementationof the
 * Min_PriorityQueue class as required.
 */
public class MinHeap {
private Node[] heapArray;
private int maxSize;           // size of array
private int currentSize;       // number of nodes in array

public static class Node {
    private int iData;             // data item (key)

    public Node(int key)           // constructor
    { iData = key; }

    public int getKey()
    { return iData; }

    public void setKey(int id)
    { iData = id; }
}
// -------------------------------------------------------------

public MinHeap(int mx)            // constructor
{
    maxSize     = mx;
    currentSize = 0;
    heapArray   = new Node[maxSize];  // create array
}

// -------------------------------------------------------------
public boolean isEmpty()
{ return currentSize==0; }

/**
 * insert() adds a node to MinHeap{} such that all of its ancestor nodes are
 * less than its value. It is a boolean, although we never use the return value
 * in this exercise.
 */
public boolean insert(int key)
{
    Node newNode = new Node(key);
    /*
     * We can insert the root node if the heap is currently empty. No other
     * comparisons are necessary.
     */
    if (null == this.heapArray[0]) {
        this.heapArray[0] = newNode;
        return false;
    }
    if (key >= this.heapArray[0].iData) {
        if (null == this.heapArray[1]) {
            this.heapArray[1] = newNode;
        }
        this.heapArray[2] = newNode;
    }
    /*
     * On the other hand, we need to replace the root node if the value is less
     * than it, and find a new position for what what previously the root node.
     */
    return false;
}
// -------------------------------------------------------------
public void trickleUp(int index) {
    // YOUR CODES
}

// -------------------------------------------------------------
public Node remove()           // delete item with max key. Return the reference to the deleted node.
    {                           // (assumes non-empty list)
    // YOUR CODES
    return null;  // for compilation. you need to change it.

}
// -------------------------------------------------------------
public void trickleDown(int index) {
    // YOUR CODES
}

// -------------------------------------------------------------
public void displayHeap()
{
    System.out.print("heapArray: ");    // array format
    for(int m=0; m<currentSize; m++)
     if(heapArray[m] != null)
        System.out.print( heapArray[m].getKey() + " ");
     else
        System.out.print( "-- ");
    System.out.println();
                                      // heap format
    int nBlanks = 32;
    int itemsPerRow = 1;
    int column = 0;
    int j = 0;                          // current item
    String dots = "...............................";
    System.out.println(dots+dots);      // dotted top line

    while(currentSize > 0)              // for each heap item
    {
    if(column == 0)                  // first item in row?
      for(int k=0; k<nBlanks; k++)  // preceding blanks
      System.out.print(' ');
                                      // display item
    System.out.print(heapArray[j].getKey());

    if(++j == currentSize)           // done?
        break;

    if(++column==itemsPerRow)        // end of row?
    {
      nBlanks /= 2;                 // half the blanks
      itemsPerRow *= 2;             // twice the items
      column = 0;                   // start over on
      System.out.println();         //    new row
    }
    else                             // next item on row
      for(int k=0; k<nBlanks*2-2; k++)
      System.out.print(' ');     // interim blanks
    }  // end for
    System.out.println("\n"+dots+dots); // dotted bottom line
}  // end displayHeap()

public static void main(String[] args) throws Exception {
    MinHeap theHeap = new MinHeap(31);  // make a Heap; max size 31

    theHeap.insert(70);           // insert 10 items
    theHeap.insert(40);
    theHeap.insert(50);
    theHeap.insert(20);
    theHeap.insert(60);
    theHeap.insert(100);
    theHeap.insert(80);
    theHeap.insert(30);
    theHeap.insert(10);
    theHeap.insert(90);

    while (!theHeap.isEmpty()) {
        Node node = theHeap.remove();
        System.out.println(node.getKey());
    }
}  // end main()
}
