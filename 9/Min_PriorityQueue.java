public class Min_PriorityQueue {
 // array in sorted order, from max at 0 to min at size-1
 private int maxSize;
 private MinHeap theHeap;
 private int nItems;
 // -------------------------------------------------------------

 public Min_PriorityQueue(int size) // constructor
 {  // YOUR CODES
 }

 // -------------------------------------------------------------
 public void insert(int item) // insert item
 { 
  //YOUR CODES
 } // end insert()

 public int remove() // remove minimum item
 { // YOUR CODES
  return -1;  // for compilation. you need to change it.
 }

 // -------------------------------------------------------------
 public int peek() // peek at minimum item
 { // YOUR CODES
  return -1;  // for compilation. You need to change it.
 }

 // -------------------------------------------------------------
 public boolean isEmpty() // true if queue is empty
 {
  // YOUR CODES
  return false; // for compilation. you need to change it.
 }

 // -------------------------------------------------------------
 public boolean isFull() // true if queue is full
 {
  // YOUR CODES
  return false;  // for compilation. You need to change it.
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