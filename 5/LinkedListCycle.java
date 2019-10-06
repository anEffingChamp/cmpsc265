import java.util.Scanner;

public class LinkedListCycle {
  private static class Link
  {
    public int iData;              // data item
    public Link next;              // next link in list
    
//-------------------------------------------------------------
    public Link(int id) // constructor
    {
      iData = id;                 // initialize data     
      next =  null;
    }                      
    
//-------------------------------------------------------------
    
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
    
    public boolean containCycle(){
      // YOUR CODES
      return true;  // For compilation.  You need to change it
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