import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Random;
import java.util.*;
/**
 * Write a program to decipher messages encoded using a prefix code, given the
 * encoding tree. Such codes are widely used in applications that compress data,
 * including JPEG for images, MP3 for music, and DivX for video.Prefix codes.  A
 * prefix code is most easily represented by a binary tree in which the external
 * nodes are labeled with single characters that are combined to form the
 * message. The encoding for a character is determined by following the path
 * down from the root of the tree to the external node that holds that
 * character: a 0 bit identifies a left branch in the path, and a 1 bit
 * identifies a right branch. In the following tree, black circles are internal
 * nodes and gray squares are external nodes. The code for b is 111, because the
 * external node holding b is reached from the root by taking 3 consecutive
 * right branches. The other codes are given in the table below.
 *
 * Note that each character can be encoded with a different number of bits. In
 * the example above, the character 'a' is encoded with a single bit, while the
 * character 'd' is encoded with 4 bits. This is a fundamental property of
 * prefix codes. In order for this encoding scheme to reduce the number of bits
 * in a message, we use short encodings for frequently used characters, and long
 * encodings for infrequent ones. A second fundamental property of prefix codes
 * is that messages can be formed by simply stringing together the code bits
 * from left to right. For example, the
 * bitstring0111110010110101001111100100encodes the message "abracadabra!". The
 * first 0 must encode 'a', then the next three 1's must encode 'b', then 110
 * must encode r, and so on as follows:|0|111|110|0|1011|0|1010|0|111|110|0|100a
 * b   r  a  c   a  d   a  b   r  a  !The codes can be run together because no
 * encoding is a prefix of another one. This property defines a prefix code, and
 * it allows us to represent the character encodings with a binary tree, as
 * shown above.
 *
 * Algorithm: To decode a given bit string:Start at the root of the tree.Repeat
 * until you reach an external leaf node.
 * - Read one message bit.
 * - Take the left
 * branch in the tree if the bit is 0; take the right branch if itis 1.Print the
 * character in that external node.This whole process is repeated, starting over
 * at the root, until all of the bits in the compressed message are exhausted.
 * Your main task is to parse the binary tree and implement this
 * procedure.Representing the binary tree.  To decode a bit string, you need the
 * binary tree that stores the character encodings. We use the preorder
 * traversal of the binary tree to represent the tree itself. Internal nodes are
 * labeled with the special character '*'. (For convenience, we
 * artificially restrict ourselves to messages that do not contain this special
 * character.) The preorder traversal of the above tree is
 *
 * * a * * ! * d c * r b Input format.  The input will consist of the preorder
 * traversal of the binary tree, followed immediately on a new line by the
 * compressed message. For the example above, the input file is
 * abra.pre:*a**!*dc*rb 0111110010110101001111100100
 */
public class PrefixTree
{
/*
 * Part 1: Building the treeDesign a class PrefixTree to represent prefix
 * trees.
 * A PrefixTree should store a character (either an input symbol or the special
 * character '*') and references to two subtrees. The beginning of your class
 * might look like:public class PrefixTree {private char character;private
 * PrefixTree left;private PrefixTree right;}
 */
private char character;
private PrefixTree leftChild;
private PrefixTree rightChild;
private Queue<Character> queue;
/**
 * Design the constructor so that it reads in the preorder traversal of a tree
 * from standard input, and reconstructs it.
 */
public PrefixTree()
{
    /*
     * We assume that this is an interior node until told otherwise. The root
     * node is an interior node by necessity.
     */
    this.character    = '*';
    Scanner userInput = new Scanner(System.in);
    System.out.println("Please enter the preorder traversal of a binary tree.");
    /*
     * Lets start by building a queue for depth first traversal of the
     * PrefixTree{}. It feels so right, how could it be wrong?
     *
     * We do so by reading the first string that the user has written, and
     * checking each character of the input. We assign it to a PrefixTree.queue
     * property for later access, and run off to the races.
     */
    this.queue             = new LinkedList<Character>();
    String inputString     = userInput.next();
    char[] inputCharachers = inputString.toCharArray();
    for (int loop = 0;
    loop < inputCharachers.length;
    loop++
    ) {
        System.out.println(inputCharachers[loop]);
        this.queue.add(inputCharachers[loop]);
    }
    /*
     * The assignment suggests
     * that the user should write * for the root node. We require that
     * internally, but disregard the first characher to better align with the
     * assignment.
     */
    this.queue.remove();
}
/**
 * PrefixTree() also accepts a character as input so that we can assign
 * attributes right away.
 */
private PrefixTree(char input)
{
    this.character = input;
}
public static void main(String[] args) throws IOException
{
    PrefixTree treeRoot = new PrefixTree();
}
}
