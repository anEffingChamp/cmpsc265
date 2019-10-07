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
    private Link first;            // ref to first link on list
    /*
     * Deque()Constructor. A new deque will be
     * instantiated that is empty.
     */
    public Deque()              // constructor
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
    /*
     * removeFront()Remove and return the integer at the front
     * from the deque
     */
    public Link removeFront()      // delete first item
    {                           // (assumes list not empty)
        Link temp = first;          // save reference to link
        first     = first.next;         // delete it: first-->old next
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
public static void main(String[] args)
{
}
}
