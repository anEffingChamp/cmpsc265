import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Random;
import java.util.*;

public class BinaryTree
{
private Node root;
/**
 * symmetryQueue is the stack we use to verify symmetry in the tree within
 * isSymmetric(). It is an object property to share its data between methods in
 * the BinaryTree{}.
 */
private Queue<Node> symmetryQueue;
private ArrayList<ArrayList<Integer>> leafPaths;
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
{
    this.root          = null;
    this.symmetryQueue = new LinkedList<Node>();
    this.leafPaths     = new ArrayList<ArrayList<Integer>>();
}            // no nodes in tree yet
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
/**
 * getNodes() recursively counts the total number of nodes in a binary tree. It
 * does so by calling an internal method to follow the tree to each leaf node,
 * and returns the current count of the tree.
 */
public int getNodes()
{
    Node currentNode = this.root;
    if (null == currentNode) {
        return 0;
    }
    int nodeCount    = 1;
    if (null != currentNode.leftChild) {
        nodeCount += this.countChildren(currentNode.leftChild);
    }
    if (null != currentNode.rightChild) {
        nodeCount += this.countChildren(currentNode.rightChild);
    }
    return nodeCount;
}
/**
 * countChildren() accepts a given Node as an argument, and counts how many
 * children that node has.
 */
private int countChildren(Node input)
{
    int nodeCount    = 1;
    if (null != input.leftChild) {
        nodeCount += this.countChildren(input.leftChild);
    }
    if (null != input.rightChild) {
        nodeCount += this.countChildren(input.rightChild);
    }
    return nodeCount;
}
/**
 * isSymmetric() verifies whether a binary tree is is a mirror of itself (i.e.,,
 * symmetric around its center).
 */
public boolean isSymmetric()
{
    boolean output = false;
    Node currentNode = this.root;
    /*
     * We can exit right away if the root node only has one child. There is no
     * way to build symmetry after that point.
     */
    if ((null == currentNode.leftChild) != (null == currentNode.rightChild)) {
        return false;
    }
    /*
     * On the other hand, the tree is symmetrical if it has only a root node. A
     * single node will be symmetrical.
     */
    if (null == currentNode.leftChild
    &&  null == currentNode.rightChild
    ) {
        return true;
    }
    /*
     * We need breadth first traversal of the binary tree to verify its
     * symmetry. Now is time to break out the stack.
     */
    this.symmetryQueue.add(this.root);
    int rowCount = 1;
    while (false == this.symmetryQueue.isEmpty()) {
        rowCount = this.checkSymmetry(rowCount);
        if (-1 == rowCount) {
            return false;
        }
    }
    return true;
}
/**
 * checkSymmetry() accepts a node as an argument, and loads its child nodes into
 * symmetryQueue. It returns an integer count of how many nodes are on a level
 * so that we know what to expect in the next iteration.
 */
private int checkSymmetry(int inputCount)
{
    /*
     * We can not have symmetry with an odd number of nodes on the level. Lets
     * get out of here.
     */
    if (1 == inputCount % 2) {
        return -1;
    }
    Node currentNode     = null;
    int output           = 0;
    int nodeArrayCounter = 0;
    Node[] nodeArray     = new Node[inputCount * 2];
    for (int loop = 0;
    loop < inputCount;
    loop += 2
    ) {
        currentNode = this.symmetryQueue.remove();
        if (null != currentNode.leftChild) {
            nodeArray[loop] = currentNode.leftChild;
            this.symmetryQueue.add(currentNode.leftChild);
            output++;
        }
        if (null != currentNode.rightChild) {
            nodeArray[loop + 1] = currentNode.rightChild;
            this.symmetryQueue.add(currentNode.rightChild);
            output++;
        }
    }
    for (int loop = 0;
    loop <= inputCount / 2;
    loop++
    ) {
        if ((null == nodeArray[loop])
            != (null == nodeArray[inputCount - loop])
        ) {
            return -1;
        }
    }
    return output;
}
/**
 * getPaths() displays a list of all available paths from root node to leaf
 * node.
 */
public ArrayList<ArrayList<Integer>> getPaths()
{
    ArrayList<Integer> argument = new ArrayList<Integer>();
    argument.add(this.root.iData);
    if (null != this.root.leftChild) {
        /*
         * ArrayList<> sits in memory, and is not truly a local variable. We
         * need to clone the list at each step to avoid acting on the globally
         * available list.
         */
        this.findLeaf(this.root.leftChild, argument.clone());
    }
    if (null != this.root.rightChild) {
        this.findLeaf(this.root.rightChild, argument.clone());
    }
    return this.leafPaths;
}
/**
 * findLeaf() navigates the binary tree to find leaf nodes. It creates a clone
 * of its argument ArrayList<> on each step, and adds that ArrayList<> to
 * this.leafPaths when it finds a leaf node.
 */
private void findLeaf(Node inputNode, Object input) {
    @SuppressWarnings("unchecked")
    ArrayList<Integer> argument = (ArrayList) input;
    argument.add(inputNode.iData);
    /*
     * We have found a leaf node when we have no more children to follow. We can
     * add the mapped path to our list.
     */
    if (null == inputNode.leftChild
    &&  null == inputNode.rightChild
    ) {
        this.leafPaths.add(argument);
    }
    if (null != inputNode.rightChild) {
        this.findLeaf(inputNode.rightChild, argument.clone());
    }
    if (null != inputNode.leftChild) {
        this.findLeaf(inputNode.leftChild, argument.clone());
    }
    return;
}
public static void main(String[] args) throws IOException
{
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
 * Please call the methods of getNode(), and return the total number of nodes in
 * this binary tree
 */
System.out.println("The tree has " + theTree.getNodes() + " nodes.");

/* Problem 2:
 * Call isSymmetric() to judge this binary tree is symmetric of itself around the center.
 */
String symmetryBoolean = "";
if (false == theTree.isSymmetric()) {
    symmetryBoolean = "not ";
}
System.out.println("The tree is " + symmetryBoolean + "symmetric.");

/*
 * Problem 3:
 * Call the getPaths() method, and display all the root-to-leaf paths on the binary tree
 */
for (ArrayList<Integer> element: theTree.getPaths()) {
    for (int loop = 0;
    loop < element.size();
    loop++
    ) {
        String outputSuffix = "->";
        if (loop == element.size() - 1) {
            outputSuffix = "";
        }
        System.out.print(element.get(loop) + outputSuffix);
    }
    System.out.println("");
}
}
}
