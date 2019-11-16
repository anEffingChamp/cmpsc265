public class Min_PriorityQueue
{
// array in sorted order, from max at 0 to min at size-1
private int maxSize;
private MinHeap theHeap;
private int nItems;
    /**
     * The attached Min_PrioriyQueue.java file contains the definition of the
     * Min_PriorityQueue class.Please finish the implementation of the method of
     * insert(),trickleUp(),delete()and trickleDown()in the MinHeap class, so
     * that a
     * Min_Heap can be constructed and maintained.Make sure a Min_Heap is a
     * complete
     * binary tree data structure that satisfies the heap ordering property, so
     * that
     * each node's key will be less than (or equal to) the key of its two
     * children,
     * and therefore, the root nodecontains the minimum key.Each time when
     * deleting
     * a node from the MinHeap,  we always delete the root node that contains
     * the minimum key. This shows that MinHeap can provide a good
     * implementation of the
     * Minimum Priority Queue. Please finish the implementationof the
     * Min_PriorityQueue class as required.
     */
    public class MinHeap {
    protected Node[] heapArray;
    protected int maxSize;           // size of array
    protected int currentSize;       // number of nodes in array

    public class Node {
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
         * Otherwise we insert the node at the end of the heap, and find its
         * proper
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
    /**
     * remove() removes the root node. Then it finds the last node in the binary
     * tree, positions it at the root node, and lets it sink down to a new
     * position to maintain the heap.
     */
    public int remove()
    {
        Node output       = this.heapArray[0];
        this.heapArray[0] = this.heapArray[--this.currentSize];
        this.trickleDown(0);
        return output.getKey();
    }
    /**
     * trickleDown() finds a new position for a Node if we need to replace it.
     */
    public void trickleDown(int input)
    {
        int leftChild   = (input * 2) + 1;
        int targetIndex = input;
        Node inputNode  = this.heapArray[input];
        if (input < this.currentSize / 2) {
            /*
             * Which child is smaller? That is the one we need.
             */
            targetIndex = leftChild + 1;
            if (this.heapArray[leftChild].getKey()
                < this.heapArray[leftChild + 1].getKey()
            ) {
                targetIndex = leftChild;
            }
        }
        if (inputNode.getKey() > this.heapArray[targetIndex].getKey()) {
            this.heapArray[input]       = this.heapArray[targetIndex];
            this.heapArray[targetIndex] = inputNode;
            this.trickleDown(targetIndex);
        }
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
    }
public Min_PriorityQueue(int size) // constructor
{
    this.theHeap = new MinHeap(size);
}
/**
 * insert() adds a node to the this.theHeap.
 */
public void insert(int input) // insert item
{
    this.theHeap.insert(input);
}
/**
 * remove() removes the root node from this.theHeap, and returns its value for
 * further processing.
 */
public int remove() // remove minimum item
{
    return this.theHeap.remove();
}
/**
 * peek() lets us see what the minimum value of the heap currently is.
 */
public int peek() // peek at minimum item
{
    return this.theHeap.heapArray[0].getKey();
}
/**
 * isEmpty() returns true if the root node of this.theHeap is null. Otherwise it
 * returns false.
 */
public boolean isEmpty() // true if queue is empty
{
    return this.theHeap.isEmpty();
}
/**
 * isFull() verifies whether this.theHeap can whole any more members.
 */
public boolean isFull() // true if queue is full
{
    boolean output = false;
    if (this.theHeap.currentSize == this.theHeap.maxSize) {
        output = true;
    }
    return output;
}

 public static void main(String[] args) {
  Min_PriorityQueue thePQ = new Min_PriorityQueue(5);

  thePQ.insert(30);
  thePQ.insert(50);
  thePQ.insert(10);
  thePQ.insert(40);
  thePQ.insert(20);

  while (!thePQ.isEmpty()) {
   long item = thePQ.remove();
   System.out.print(item + " "); // 10, 20, 30, 40, 50
  }
  System.out.println("");
 } // end main()
}
