import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Random;
import java.util.*;

public class BinaryTree {
////////////////////////////////////////////////////////////////
  private Node root;
  
  private static class Node {
    public int iData;              // data item (key)
    public Node leftChild;         // this node's left child
    public Node rightChild;        // this node's right child
    
    public void displayNode()      // display ourself
    {
      System.out.print(iData + " ");
    }
  }  // end class Node

//-------------------------------------------------------------
  public BinaryTree()         // constructor of the Binary Tree
  { root = null; }            // no nodes in tree yet
//-------------------------------------------------------------
  
  public void insert(int id) {
    Node newNode = new Node();    // make new node
    newNode.iData = id;           // insert data

    if(root==null)                // no node in root
      root = newNode;
    else                          // root occupied
    {
      Random rnd = new Random();
      Node current = root;
      Node parent = root;
      int rand = 0;
      while (current!=null){
        parent = current;
        rand = rnd.nextInt(2);
        if (rand==0) current = current.leftChild;
        else current = current.rightChild;
      }
      if (rand==0) parent.leftChild = newNode;
      else parent.rightChild = newNode;
    }
  }  // end insert()

//-------------------------------------------------------------

  /* Level-order traversal of the Tree
   */
  public void displayTree() {
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);
    while (!q.isEmpty()){
      Node current = q.poll();
      current.displayNode();
      if (current.leftChild!=null) {
        System.out.print(current.iData + " " + "Left: " + current.leftChild.iData + "\t");
        q.add(current.leftChild);
      }
      else {
        System.out.print(current.iData + " " + "Left:NULL" + "\t");
      }
      if (current.rightChild!=null) {
        System.out.print(current.iData + " " + "Right: " + current.rightChild.iData + "\n");
        q.add(current.rightChild);
      }
      else {
        System.out.println(current.iData + " " + "Right:NULL");
      }
    }
    System.out.println();
  }  

  public void displayTree2() {
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);
    while (!q.isEmpty()){
      Node current = q.poll();
      current.displayNode();
      if (current.leftChild!=null) {
        q.add(current.leftChild);
      }
      if (current.rightChild!=null) {
        q.add(current.rightChild);
      }
    }
  }  
  /* @param none
   * @return the total number of nodes in this Binary Tree
   */
  public int getNodes(){
    // YOUR CODES
    return -1;  // FOR COMPILATION, YOU NEED TO CHANGE IT 
  }
  
  /*@param  another binary tree
   * @return return true or false
   * indicating whether this binary tree is symmetric of itself.
   */
  public boolean isSymmetric(){
    // YOUR CODES
    return false;  // FOR COMPILATION, YOU NEED TO CHANGE IT  
  }
  
  /*
   * @param none
   * @return return all the root-to-leaf paths in this Binary Tree
   */
  public ArrayList<ArrayList<Integer>> getPaths(){
    // YOUR CODES
    return null; // FOR COMPILAION, YOU NEED TO CHANGE IT.
  }
  
  public static void main(String[] args) throws IOException {
    // Sample Codes, Create a binary tree and display all the nodes in level-order
    BinaryTree theTree = new BinaryTree();
    theTree.insert(50);    
    theTree.insert(25);    
    theTree.insert(75);
    theTree.insert(12);    
    theTree.insert(37);    
    theTree.insert(43); 
    theTree.insert(30);    
    theTree.insert(33);
    theTree.insert(87);
    theTree.insert(93);    
    theTree.insert(97);
    
    theTree.displayTree();
    
    /* Problem 1:
     * Please call the methods of getNode(), and return the total number of nodes in this binary tree
     * YOUR CODES
     */
    
    /* Problem 2:
     * Call isSymmetric() to judge this binary tree is symmetric of itself around the center.
     * YOUR CODES
     */
    
    
    /*
     * Problem 3:
     * Call the getPaths() method, and display all the root-to-leaf paths on the binary tree
     * YOUR CODES
     */
  }
}