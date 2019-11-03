//package Chap08.tree;
//

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree
{
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
/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 * two given nodes in the BST.According to the definition of LCA on Wikipedia:
 *
 * The lowest common ancestor is defined between two nodes p and q as the
 * lowest node in T that has both p and q as descendants (a node can be a
 * descendant of itself)
 *
 * @param two nodes
 * @return the data of the node which is the lowest common ancestor of node p and q;
 * @return -1 if either p or q does not exist in the tree
 */
public int getLCA(Node p, Node q)
{
    return this._getLowestCommonAncestor(this.root, p, q);
}
private int _getLowestCommonAncestor(
    Node input,
    Node firstTarget,
    Node secondTarget
) {
    /*
     * If the values in both target nodes are both lessor or greater than our
     * current data, they probably have a common ancestor in the same subtree.
     * We can disregard the other subtree entirely.
     */
    if (input.data > firstTarget.data
    &&  input.data > secondTarget.data
    ) {
        return this._getLowestCommonAncestor(input.left, firstTarget, secondTarget);
    }
    if (input.data < firstTarget.data
    &&  input.data < secondTarget.data
    ) {
        return this._getLowestCommonAncestor(input.right, firstTarget, secondTarget);
    }
    /*
     * If we have already found one of the values, we simply need to verify that
     * the other exists in the tree.
     */
    if ((input.data == firstTarget.data
        &&  false   != this._findNode(input, secondTarget)
        )
    || (input.data  == secondTarget.data
        &&  false   != this._findNode(input, firstTarget)
        )
    ) {
        return input.data;
    }
    /*
     * The same is true if one value is greater, and the other is lessor than
     * the input.data. In that case we just need to find the target nodes to
     * verify that they are in the tree.
     */
    if (false != this._findNode(input, firstTarget)
    &&  false != this._findNode(input, secondTarget)
    ) {
        return input.data;
    }
    return -1;
}
/**
 * _findNode() verifies that a single node exists in a given tree.
 */
private boolean _findNode(Node input, Node target)
{
    Node nextNode = null;
    if (null == input) {
        return false;
    }
    if (input.data == target.data) {
        return true;
    }
    if (input.data > target.data) {
        nextNode = input.left;
    }
    if (input.data < target.data) {
        nextNode = input.right;
    }
    return this._findNode(nextNode, target);
}
public static void main(String[] args)
{
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
    int[] arguments = {2, 8, 0, 3, 2, 10, 1, 3};
    for (int loop = 0;
    loop < arguments.length;
    loop += 2
    ) {
        int output = tree3.getLCA(
            new Node(arguments[loop]), new Node(arguments[loop + 1])
        );
        if (-1 == output) {
            System.out.println("One or both nodes is missing from the tree.");
            continue;
        }
        System.out.println(
            "The lowest ancestor for " + arguments[loop] + " and "
            + arguments[loop + 1] + " is: " + output
        );
    }
}
}
//-------------------------------------------------------------
