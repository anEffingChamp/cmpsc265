import java.util.Scanner;
/**
 * Description:Given a singly linked list, remove the n-th node from the end of
 * the list.Example:Given a linked list: 1->2->3->4->5, and n=2After removing
 * the second node from the end, the linked list would become:1->2->3->5
 */
public class RemoveLinkedList
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

    //-------------------------------------------------------------
    public LinkList()              // constructor
    {
      first = null;               // no links on list yet
    }

    // -------------------------------------------------------------
    public boolean isEmpty()       // true if list is empty
    {
      return (first==null);
    }
    //-------------------------------------------------------------
    // insert at start of list
    public void insertFirst(int id)
    {                           // make new link
      Link newLink = new Link(id);
      newLink.next = first;       // newLink --> old first
      first = newLink;            // first --> newLink
    }
    //-------------------------------------------------------------
    public Link deleteFirst()      // delete first item
    {                           // (assumes list not empty)
      Link temp = first;          // save reference to link
      first = first.next;         // delete it: first-->old next
      return temp;                // return deleted link
    }
    //-------------------------------------------------------------
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
    //-------------------------------------------------------------
    /**
     * removeN() finds the nth node in a linked list, and removes it from the
     * list. It then updates all subsequent links in the list to maintain
     * continuity.
     */
    public void removeN(int input)
    {
        /*
         * We can exit early if the list is empty.
         */
        if (null == this.first) {
            System.out.println("The list is empty.");
            return;
        }
        Link currentLink = this.first;
        Link linkTarget  = null;
        int linkCount    = 0;
        /*
         * If not,
         * We loop through the list to count how many elements it has, and mark
         * the nth + 1 element from the end.
         */
        while (null != currentLink.next) {
            linkCount++;
            if (input < linkCount) {
                linkTarget = linkTarget.next;
            }
            if (input == linkCount) {
                linkTarget = this.first;
            }
            currentLink = currentLink.next;
        }
        /*
         * Then we can point the linkTarget to skip the node we want to delete.
         * We just need to be conscious of when we want to delete the last node,
         * the first node, or when the input is greater than the total nodes.
         */
        if (input == linkCount + 1) {
            this.first = this.first.next;
            return;
        }
        if (input > linkCount
        &&  null == linkTarget
        ) {
            int outputCount = linkCount + 1;
            System.out.println(
                "There are only " + outputCount + " elements in the list."
            );
            return;
        }
        if (1 == input) {
            linkTarget.next = null;
        }
        if (1 < input) {
            linkTarget.next = linkTarget.next.next;
        }
    }
    }  // end class LinkList
////////////////////////////////////////////////////////////////
public static void main(String[] args)
{
    LinkList theList = new LinkList();  // make new list

    theList.insertFirst(1);      // insert five items
    theList.insertFirst(2);
    theList.insertFirst(3);
    theList.insertFirst(4);
    theList.insertFirst(5);

    theList.displayList();              // display list

    Scanner input = new Scanner(System.in);
    System.out.print("Please enter a number N, so that the Nth node from the end will be deleted: ");
    int pos = input.nextInt();
    input.close();

    theList.removeN(pos);
    theList.displayList();
}  // end main()
}  // end class RemoveLinkedList
