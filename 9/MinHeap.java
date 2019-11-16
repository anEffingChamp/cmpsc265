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
    /*
     * We can not insert a node if the array is full.
     */
    if (this.currentSize == this.maxSize) {
        return false;
    }
    /*
     * Otherwise we insert the node at the end of the heap, and find its proper
     * position after the fact.
     */
    this.heapArray[currentSize] = new Node(key);
    this.trickleUp(this.currentSize++);
    return true;
}
// -------------------------------------------------------------
/*
 * trickleUp() finds the appropriate position for a target node. It does so by
 * comparison with each of its parent nodes until we either find a good spot, or
 * reach the root.
 */
public void trickleUp(int input)
{
    /*
     * In a heap the index of the parent node will consistently be half that of
     * a given input node. So lets start with that.
     */
    int parent      = (input - 1) / 2;
    int target      = input;
    Node targetNode = this.heapArray[target];
    while (target > 0
    &&  this.heapArray[parent].getKey() > this.heapArray[target].getKey()
    ) {
        this.heapArray[parent] = this.heapArray[target];
        target = parent;
        parent = (target - 1) / 2;
    }
    this.heapArray[target] = targetNode;
}
// -------------------------------------------------------------
// delete item with max key. Return the reference to the deleted node.
/**
 * remove() checks the leaf nodes of the tree for a maximum value. All interior
 * nodes have children, so they can not logically be the maximum.
 * https://stackoverflow.com/questions/22703549/finding-max-element-in-a-min-heap
 */
public Node remove()
{                           // (assumes non-empty list)
    int removalIndex = this.currentSize / 2;
    Node output      = this.heapArray[removalIndex];
    for (int loop = removalIndex + 1;
    loop < this.currentSize;
    loop++
    ) {
        /*
         * We identify the highest value in the loop through the leaf nodes.
         */
        if (this.heapArray[loop].iData > output.iData) {
            removalIndex = loop;
            output       = this.heapArray[loop];
        }
    }
    /*
     * Once we have the removalIndex, we have a few things to do. We need
     * to reinsert all subsequent nodes to maintain the heap. Only then
     * can we nullify that Node, and return it for further processing.
     */
    this.heapArray[removalIndex] = null;
    for (int loop = removalIndex;
    loop < this.currentSize;
    loop++
    ) {
        this.heapArray[loop] = this.heapArray[removalIndex + 1];
        this.trickleUp(removalIndex + 1);
    }
    this.currentSize--;
    return output;
}
/**
 * trickleDown() finds a new position for a Node if we need to replace it.
 */
public void trickleDown(int index)
{

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
