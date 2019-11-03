//package Chap08.tree;

import java.util.*;
import java.io.*;
/**
 * Description:Write a data type TwoDTree thatrepresents a 2d-Tree.  A 2d-Tree
 * is a generalization of a BST to two-dimensional keys. The idea is to build a
 * BST with points in the nodes, using the x-and y-coordinates of the points as
 * keys in strictly alternating sequence, starting with the
 * x-coordinates.
 *
 * Search and insert.  The algorithms for search and insert are
 * similar to those for BSTs, but at the root we use the x-coordinate (if the
 * point to be inserted has a smaller x-coordinate than the point at the root,
 * go left; otherwise go right); then at the next level, we use the y-
 * coordinate (if the point to be inserted has a smaller y-coordinate than the
 * point in the node, go left; otherwise go right); then at the next level the
 * x-coordinate, and so forth.
 */
public class TwoDTree
{
private Node root; // root of the KdTree

private static class Point2D {
    double x;
    double y;

    public Point2D(double x, double y){
        this.x = x;
        this.y = y;
    }
}

// 2d-tree (generalization of a BST in 2d) representation.
private static class Node {
    private Point2D p;   // the point
    private Node left;     // the left/bottom subtree
    private Node right;     // the right/top subtree

    // Construct a node given the point
    Node(Point2D p) {
        this.p = p;
    }
}

public TwoDTree(){
    root = null;
}
/**
 * insert() adds nodes to a binary search tree according to two dimensional
 * logic. The idea is to build a BST with points in the nodes, using the x-and
 * y-coordinates of the points as keys in strictly alternating sequence,
 * starting with the x-coordinates.
 */
public void insert(Point2D input)
{
    Node nextNode = new Node(input);
    /*
     * We can set the root node if we have none. That is the first order of
     * business.
     */
    if (null == this.root) {
        this.root = nextNode;
    }
    this._insertNode(this.root, nextNode, 0);
}
/**
 * _insertNode() adds a node according to two dimensional, binary search tree
 * logic. It differs from insert(), because it accepts a Node as an argument,
 * and can call its self recursively.
 */
private void _insertNode(Node currentNode, Node input, int currentLevel)
{
    Node nextNode = null;
    /*
     * We insert according to the X coordinate on odd numbered levels. We decide
     * on the next motion through the binary tree here, although we execute it
     * later in the method.
     */
    if (1 == currentLevel % 2) {
        if (currentNode.p.x > input.p.x) {
            nextNode = currentNode.left;
        }
        if (currentNode.p.x <= input.p.x) {
            nextNode = currentNode.right;
        }
    }
    /*
     * We insert by the Y coordinate on even numbered levels.
     */
    if (0 == currentLevel % 2) {
        if (currentNode.p.y > input.p.y) {
            nextNode = currentNode.left;
        }
        if (currentNode.p.y <= input.p.y) {
            nextNode = currentNode.right;
        }
    }
    /*
     * Is the nextNode null? In that case we can safely insert the input node,
     * and end this iteration. Otherwise we continue to descend through the
     * tree.
     */
    if (null == nextNode) {
        nextNode = input;
        return;
    }
    this._insertNode(nextNode, input, currentLevel++);
}
public boolean search(Point2D p){
    // YOUR CODES
    return false; // for compilation. you need to change it.
}

public void display(){
    // YOUR CODES
}

public static void main(String[] args) throws Exception {
    // 1. YOUR CODES to Read file and build the tree by insertion
    // 2. Display the TwoDTree in Level-Order
    // 3. Search for some arbitrary points.
}
}
