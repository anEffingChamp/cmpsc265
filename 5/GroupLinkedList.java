import java.util.Scanner;
/**
 * Description:Given a singly linked list, group all odd nodes (not the value of
 * node, but the node number) together followed by all the even
 * nodes.Example:Input:  1->2->3->4->5->nullOutput: 1->3->5->2->4->null
 * You shoulddo it in-place, namely, you will NOTcreate another linked listsor
 * arrays, and then add the nodes back to form the new linked list
 */
public class GroupLinkedList
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
    public void group(){
      // YOUR CODES
    }
    }  // end class LinkList
////////////////////////////////////////////////////////////////
public static void main(String[] args)
{
    LinkList theList = new LinkList();  // make new list

    theList.insertFirst(5);      // insert five items
    theList.insertFirst(4);
    theList.insertFirst(3);
    theList.insertFirst(2);
    theList.insertFirst(1);

    theList.displayList();              // display list

    theList.group();

    theList.displayList();
}  // end main()
}  // end class GroupLinkedList
