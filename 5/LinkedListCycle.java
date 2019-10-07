import java.util.Scanner;
/**
 * Description:Given a singly linked list, write a program to determine whether
 * it has a cycle.For example, the following linked list has a cycle.Hint:you
 * can introduce two pointers traversing the linked list from head with
 * different speeds(like two people running on a loop with different speed).  If
 * there is a cycle, the two pointers will finally meet with each other (the
 * person runs faster will catch up the one who runs slower).   Otherwise, there
 * would be no cycle.
 */
public class LinkedListCycle {
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
    // insert at start of list
    public void insertFirst(int id)
    {                           // make new link
      Link newLink = new Link(id);
      newLink.next = first;       // newLink --> old first
      first = newLink;            // first --> newLink
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
     * containCycle() verifies whether the linked list contains a cycle. It
     * returns true if so, false if not.
     */
    public boolean containCycle()
    {
        boolean output   = true;
        Link currentLink = this.first;
        Link slowLink    = this.first;
        int fastCount    = 0;
        int slowCount    = 0;
        /*
         * We start by looping through the whole list. We have two counters. One
         * increments on every node, and the other increments on every other
         * node.
         */
        while (null != currentLink.next) {
            fastCount++;
            if (0 == fastCount % 2) {
                slowCount++;
                slowLink = slowLink.next;
            }
            currentLink = currentLink.next;
            /*
             * We know that we have a loop if the currentLink ever equals the
             * slowLink. There should never be any opportunity for overlap in a
             * straight list.
             */
            if (currentLink == slowLink) {
                return output;
            }
        }
        /*
         * We confirm that there is no loop by verifying that the slower counter
         * is roughly half the value of the faster counter. Otherwise we assume
         * that the list contains a loop, but it was not caught in our previous
         * condition.
         */
        if (1 >= fastCount % slowCount) {
            output = false;
        }
        return output;
    }
    }  // end class LinkList
////////////////////////////////////////////////////////////////
public static void main(String[] args)
{
    Link first = new Link(3);
    Link second = new Link(2);
    Link third = new Link(0);
    Link fourth = new Link(-4);

    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = second;

    LinkList theList = new LinkList();    // create the linked list
    theList.first = first;

    System.out.println("Does the linked list contain a cyle?: " + theList.containCycle());
}  // end main()
}  // end class LinkedListCycle
