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
        this.reverseLinks(this.first);
    }
    /**
     * reverseLinks() reverses the order of links in a linked list. It accepts a
     * starting link as an input. Then it will move to the penultimate link for
     * currentLink. From there it will append the final link, currentLink.next,
     * to input.next, and set currentLink.next to null such that currentLink
     * becomes the final link.
     *
     * It will end when the input link is already the penultimate link. In that
     * case, we can assume that the list is sorted.
     */
    private void reverseLinks(Link input)
    {
        Link currentLink = input;
        /*
         * We may have already reached the second to last link. In that case, we
         * end the recursion, because we have fully sorted the list.
         */
        if (null == input.next.next) {
            return;
        }
        while (null != currentLink.next.next) {
            currentLink = currentLink.next;
        }
        currentLink.next.next = input.next;
        input.next            = currentLink.next;
        currentLink.next      = null;
        if (null != input.next.next) {
            this.reverseLinks(input.next);
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

    theList.reverse();
    theList.displayList();
    }  // end main()
}  // end class RemoveLinkedList
