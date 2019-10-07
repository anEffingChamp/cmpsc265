import java.util.Scanner;
/**
 * DescriptionDeque is an abstract data type defined by the following structure
 * and operations.  A dequeis structured as a collection of data items where
 * data items can be added and removed from either end, either front or
 * rear.Please write a Java class for Deque of Integers, using doubly linked
 * list, so that the following method can be
 * implemented:MethodsDescription
 * Deque()Constructor. A new deque will be
 * instantiated that is empty.
 * addFront(int)Add a new integerto the front of the
 * deque;Returns nothing
 * addRear(int)Add a new integer to the rear of the
 * deque;Returns nothing
 * removeFront()Remove and return the integer at the front
 * from the deque
 * removeRear()Remove and return the integer at the end from the
 * deque.
 * isEmpty()Tests to see whether the deque is emptyReturns a
 * boolean
 * display()Show all the integers currently in the deque from front to
 * rear
 * size()Returns the number of integers in the dequeReturns an integer.
 */
public class Deque
{
    private static class Link
    {
    public int iData;              // data item
    public Link next;              // next link in list
    public Link(int id) // constructor
    {
      iData = id;                 // initialize data
      next =  null;
    }
    public void displayLink()      // display ourself
    {
      System.out.print("{" + iData + "} ");
    }
    }  // end class Link
////////////////////////////////////////////////////////////////
    private static class LinkList
    {
    private Link first;            // ref to first link on list
    public LinkList()              // constructor
    {
      first = null;               // no links on list yet
    }
    public boolean isEmpty()       // true if list is empty
    {
      return (first==null);
    }
    /*
     * addFront(int)Add a new integerto the front of the
     * deque;Returns nothing
     */
    public void addFront(int id)
    {                           // make new link
      Link newLink = new Link(id);
      newLink.next = first;       // newLink --> old first
      first        = newLink;            // first --> newLink
    }
    public Link deleteFirst()      // delete first item
    {                           // (assumes list not empty)
      Link temp = first;          // save reference to link
      first = first.next;         // delete it: first-->old next
      return temp;                // return deleted link
    }
    public void displayList()
    {
      System.out.print("List (first-->last): ");
      Link current = first;       // start at beginning of list
      while(current != null)      // until end of list,
      {
        current.displayLink();   // print data
        current = current.next;  // move to next link
      }
      System.out.println("");
    }
    /**
     * group() groups the odd and even nodes of a linked list such that all odd
     * nodes are sorted first, and even numbered nodes come last. Their ranking
     * as odd or even is determined by their initial position in the unsorted
     * list.
     */
    public void group()
    {
        /*
         * We can exit early if the list is empty.
         */
        if (null == this.first) {
            System.out.println("The list is empty.");
            return;
        }
        Link oddLink       = this.first;
        Link evenLink      = this.first.next;
        Link evenLinkFirst = evenLink;
        /*
         * We loop through the list, creating a chain of odd and even nodes. We
         * basically create two chains of odd and even respectively, then join
         * the even nodes to the end of the odd chain when we finish.
         */
        while (null != oddLink.next.next) {
            oddLink.next   = oddLink.next.next;
            oddLink        = oddLink.next;
            if (null == oddLink.next) {
                break;
            }
            evenLink.next  = evenLink.next.next;
            evenLink       = evenLink.next;
        }
        /*
         * We assume that the last list item was odd if the last list item is
         * not even. If that case, we nullify the next field in evenLink,
         * because we plan to overwrite the next field in oddLink thereafter.
         */
        if (null != evenLink.next) {
            evenLink.next = null;
        }
        oddLink.next = evenLinkFirst;
    }
    }  // end class LinkList
public static void main(String[] args)
{
}
}
