package Chap08.tree;

import java.util.*;
import java.io.*;

public class TwoDTree {
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
    
    public void insert(Point2D p){
    	// YOUR CODES
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
