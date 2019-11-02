package Chap08.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
private Node root;

private static class Node {
    public int data;              // data item (key)
    public Node left;         // this node's left child
    public Node right;        // this node's right child

    public Node(int data){
        this.data = data;
    }

    public void displayNode()      // display ourself
    {
        System.out.print(data + " ");
    }
}  // end class Node

//-------------------------------------------------------------
public BinarySearchTree()         // constructor of the Binary Tree
{ root = null; }            // no nodes in tree yet

public void insert(int id) {
    Node newNode = new Node(id);    // make new node
    if(root==null)                // no node in root
        root = newNode;
    else {
        Node current = root;
        Node parent = root;
        while (current!=null){
            parent = current;
            if (id<current.data){
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (id<parent.data) parent.left = newNode;
        else parent.right = newNode;
    }
}  // end insert()
/*
 * Please finish the isBST()method in the BinarySearchTree class that will
 * determine whether the tree is a binary search tree or not.Please remember a
 * valid Binary Search Tree is defined as follows:
 * - The left subtree of a node contains only nodes with key less than the
 *   node's
 * key.
 * - The right subtree of a node contains only nodes with key greater than or
 * equal to the node's key
 * - Both the left and right substrees must also be a
 * binary search tree.
 *
 * @param none
 * @return true or false indicating whether the tree is a binary search tree
 */
public boolean isBST()
{
    return this.isBinarySearchTree(this.root);
}
/**
 * isBinarySearchTree() accepts a node as input, and checks whether its left
 * node is less than, and right node is greater than its own value. Then it
 * recursively calls its self to fully navigate the tree.
 */
private boolean isBinarySearchTree(Node input)
{
    boolean leftTree  = false;
    boolean rightTree = false;
    /*
     * A leaf node is a valid subtree of a BST, so we can safely return true.
     */
    if (null == input.left
    &&  null == input.right
    ) {
        return true;
    }
    /*
     * Otherwise we need to evaluate all subtrees below this node. Lets check
     * their values.
     */
    if (null == input.left) {
        leftTree = true;
    }
    if (null == input.right) {
        rightTree = true;
    }
    if (null       != input.left
    &&  input.data >= input.left.data
    ) {
        leftTree = this.isBinarySearchTree(input.left);
    }
    if (null       != input.right
    &&  input.data <= input.right.data
    ) {
        rightTree = this.isBinarySearchTree(input.right);
    }
    if (true == leftTree
    &&  true == rightTree
    ) {
        return true;
    }
    return false;
}
/*
 * @param two nodes
 * @return the data of the node which is the lowest common ancestor of node p and q;
 * @return -1 if either p or q does not exist in the tree
 */
public int getLCA(Node p, Node q){
    return -1; // for compilation.
}

public static void main(String[] args){
    Node root1 = new Node(2);
    Node left1 = new Node(1);
    Node right1 = new Node(3);
    root1.left = left1;
    root1.right = right1;
    BinarySearchTree tree1 = new BinarySearchTree();
    tree1.root = root1;
    System.out.println("Is the first tree a valid BST?: " + tree1.isBST());

    Node root2 = new Node(5);
    Node left2_1 = new Node(1);
    Node right2_1 = new Node(4);
    Node left2_2 = new Node(3);
    Node right2_2 = new Node(6);
    root2.left = left2_1;
    root2.right = right2_1;
    right2_1.left = left2_2;
    right2_2.right = right2_2;
    BinarySearchTree tree2 = new BinarySearchTree();
    tree2.root = root2;
    System.out.println("Is the second tree a valid BST?: " + tree2.isBST());

    BinarySearchTree tree3 = new BinarySearchTree();
    int[] nodes = {6, 8, 2, 4, 0, 9, 7, 5, 3};
    for (int n: nodes){
        tree3.insert(n);
    }
    // YOUR CODES to get the LCA for the following two nodes' set:
    // node 2 and node 8
    // node 0 and node 3
    // node 2 and node 10
    // node 1 and node 3
}
}
//-------------------------------------------------------------
