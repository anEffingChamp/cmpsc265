import java.util.Scanner;
/**
 * Description:Please use a recursive approach to reverse a given linked
 * list.Example:Given a linked list: 1->2->3->4->5After reversing the linked
 * list, we have:5->4->3->2->1
 */
public class ReverseLinkedList {
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
     * reverse() reorders the linked list such that it will then run back to
     * front. The last item will become the first, following subsequent links
     * until the first link becomes the last.
     */
    public void reverse()
    {
        /*
         * We can exit early if the list is empty. There is no reason to go any
         * further.
         */
        if (null == this.first) {
            System.out.println("The list is empty.");
            return;
        }
        /*
         * We can also just show the list if it has a single member. It is
         * already sorted, so there is no reason to continue.
         */
        if (null == this.first.next) {
            this.displayList();
            return;
        }
        Link firstLink   = this.first;
        Link currentLink = this.first;
        while (null != currentLink.next.next) {
            currentLink = currentLink.next;
        }
        currentLink.next.next = this.first;
        this.first            = currentLink.next;
        currentLink.next      = null;
        /*
        int linkIndex  = 0;
        int linkTotal  = 2;
        while (null != firstLink.next) {
            linkTotal = this.reverseLinks(linkIndex, linkTotal);
            linkIndex++;
        }
        */
    }
    /**
     *
     */
    private int reverseLinks(int input, int linkTotal)
    {
        Link currentLink = this.first;
        int linkIndex    = 0;
        int output       = linkTotal;
        Link targetLink  = null;
            System.out.println(currentLink.iData);
        while (null != currentLink.next.next) {
            /*
             * We need to discover the total number of links in the linked list.
             * This will help us to keep our position as we resort the list. We
             * initialize the value at 2, so we should only trigger this
             * condition on the first run.
             */
            if (2 == linkTotal) {
                output++;
            }
            if (linkIndex == input) {
                targetLink = currentLink;
            }
            currentLink = currentLink.next;
            linkIndex++;
        }
        /*
         * Now we can move the last link on the list to the position after the
         * target link. The target link is already sorted, so we use it as our
         * starting position.
         */
        if (0 == input) {
            System.out.println(currentLink.iData);
            currentLink.next = this.first;
            this.first       = currentLink;
            return output;
        }
        targetLink.next  = currentLink.next.next;
        currentLink.next = null;
        return output;
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

    theList.reverse();
    theList.displayList();
    }  // end main()
}  // end class RemoveLinkedList
