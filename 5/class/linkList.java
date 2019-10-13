// linkList.java
// demonstrates linked list
// to run this program: C>java LinkListApp
package Chap05.linkList;

////////////////////////////////////////////////////////////////
class Link
   {
   public int iData;              // data item
   public double dData;           // data item
   public Link next;              // next link in list
   
// -------------------------------------------------------------
   public Link(int id, double dd) // constructor
      {
      iData = id;                 // initialize data
      dData = dd;       
      next =  null;
      }                      
  
// -------------------------------------------------------------
   
   public void displayLink()      // display ourself
      {
      System.out.print("{" + iData + ", " + dData + "} ");
      }
   }  // end class Link
////////////////////////////////////////////////////////////////

class LinkList
   {
   private Link first;            // ref to first link on list

// -------------------------------------------------------------
   public LinkList()              // constructor
      {
      first = null;               // no links on list yet
      }

// -------------------------------------------------------------
   public boolean isEmpty()       // true if list is empty
      {
      return (first==null);
      }
// -------------------------------------------------------------
                                  // insert at start of list
   public void insertFirst(int id, double dd)
      {                           // make new link
      Link newLink = new Link(id, dd);
      newLink.next = first;       // newLink --> old first
      first = newLink;            // first --> newLink
      }
// -------------------------------------------------------------
   public Link deleteFirst()      // delete first item
      {                           // (assumes list not empty)
      Link temp = first;          // save reference to link
      first = first.next;         // delete it: first-->old next
      return temp;                // return deleted link
      }
// -------------------------------------------------------------
   public void insertLast(int i, double d) { // insert a new node at the end.
	  if (isEmpty()) {
		  insertFirst(i, d);  // if the linked list is empty, this is equivalent to inserting at the front.
		  return;
	  }
	  Link newNode = new Link(i, d);
	  Link current = first;       // start at beginning of list
	  while(current.next!= null)      // until end of list,
	  {
		  current = current.next;  // move to next link
	  }
	  current.next = newNode;
   }
  
//--------------------------------------------------------------
   
   public Link deleteLast()      // delete the last item
   {  
	   if (isEmpty()) return null;	   
	   Link temp = first;          // save reference to link
	   Link current = first;
	   Link previous = first;
	   while (current.next!=null){
		   previous = current;
		   current = current.next;
	   }
	   previous.next = current.next;
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
// -------------------------------------------------------------
   
   
//---------------------------------------------------------------
   
   public Link find(int key)      // find link with given key
   {                           // (assumes non-empty list)
   Link current = first;              // start at 'first'
   while(current.iData != key)        // while no match,
      {
      if(current.next == null)        // if end of list,
         return null;                 // didn't find it
      else                            // not end of list,
         current = current.next;      // go to next link
      }
   return current;                    // found it
   }
   
//-------------------------------------------------------------
   public Link delete(int key)    // delete link with given key
   {                           // (assumes non-empty list)
	   Link current = first;              // search for link
	   Link previous = first;
	   while(current.iData != key)
	   {
		   if(current.next == null)
			   return null;                 // didn't find it
		   else
		   {
			   previous = current;          // go to next link
			   current = current.next;
		   }
	   }
	   // found it
	   if(current == first)               // if first link,
		   first = first.next;             //    change first
	   else                               // otherwise,
		   previous.next = current.next;   //    bypass it
	   return current;
   }
   
 //----------------------------------------------------------------------------------
   
   public void reverse1(){  // reverse this linked list
	   Link newFirst = null;
	   Link current = first;
	   while (current!=null){
		   Link newNode = new Link(current.iData, current.dData);
		   newNode.next = newFirst;
		   newFirst = newNode;
		   current = current.next;
	   }
	   this.first = newFirst;
   }
   
   public LinkList reverse2(){   // reverse this linked list and return the new linked list
	   LinkList newFirst = new LinkList();
	   Link current = first;
	   while (current!=null){
		   newFirst.insertFirst(current.iData, current.dData);
		   current = current.next;
	   }
	   return newFirst;
   }
   
   public void reverse3(){   // reverse this linked list
	   LinkList newList = new LinkList();
	   Link current = first;
	   while (current!=null){
		   newList.insertFirst(current.iData, current.dData);
		   current = current.next;
	   }
	   this.first = newList.first;
   }
  }  // end class LinkList
////////////////////////////////////////////////////////////////

class LinkListApp
   {
   public static void main(String[] args)
      {
      LinkList theList = new LinkList();  // make new list

      theList.insertFirst(22, 2.99);      // insert four items
      theList.insertFirst(44, 4.99);
      theList.insertFirst(66, 6.99);
      theList.insertFirst(88, 8.99);
      theList.insertLast(99, 9.99);
      
      theList.displayList();              // display list
      
      theList.deleteFirst();
      theList.deleteFirst();
      theList.deleteLast();
      
      theList.displayList();              // display list
      
      // reverse the linked list
      theList.reverse1();
      theList.displayList();
      
      }  // end main()
   }  // end class LinkListApp
////////////////////////////////////////////////////////////////
