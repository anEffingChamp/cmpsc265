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
private prefixNode root;
private Queue<Character> queue;
private ArrayList<ArrayList<Integer>> leafPaths;
private ArrayList<Character> leafCharacters;
private Scanner userInput;
    private static class prefixNode
    {
    public char character;
    public prefixNode leftChild;         // this prefixNode's left child
    public prefixNode rightChild;        // this prefixNode's right child
    /**
     * prefixNode() also accepts a character as input so that we can assign
     * attributes right away.
     */
    public prefixNode(char input)
    {
        this.character = input;
    }
    }
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
    this.root           = new prefixNode('*');
    this.leafPaths      = new ArrayList<ArrayList<Integer>>();
    this.leafCharacters = new ArrayList<Character>();
    this.userInput      = new Scanner(System.in);
    this.queue          = new LinkedList<Character>();
    System.out.println("Please enter the preorder traversal of a binary tree.");
    /*
     * Lets start by building a queue for depth first traversal of the
     * PrefixTree{}. It feels so right, how could it be wrong?
     *
     * We do so by reading the first string that the user has written, and
     * checking each character of the input. We assign it to a PrefixTree.queue
     * property for later access, and run off to the races.
     */
    this.queueString(userInput.next());
    /*
     * The assignment suggests
     * that the user should write * for the root node. We require that
     * internally, but disregard the first characher to better align with the
     * assignment.
     */
    if (null != this.queue.peek()) {
        this.queue.remove();
    }
    while (null != this.queue.peek()) {
        this.addCharacter(this.root);
    }
}
/**
 * addCharacter() adds a character to the PrefixTree{}. It accepts a
 * prefixNode{} as input, and navigates this.queue until it finds a character to
 * indicate a leaf node.
 */
private void addCharacter(prefixNode input)
{
    /*
     * We can exit early if we have emptied the queue.
     */
    if (true == this.queue.isEmpty()) {
        return;
    }
    /*
     * Otherwise lets find a home for this new subtree.
     */
    char nextCharacter  = this.queue.poll();
    prefixNode nextNode = new prefixNode(nextCharacter);
    switch (nextCharacter) {
    case '*':
        if (null == input.leftChild) {
            input.leftChild = nextNode;
        }
        if ('*' == input.leftChild.character) {
            this.addCharacter(input.leftChild);
            return;
        }
        if (null == input.rightChild) {
            input.rightChild = nextNode;
        }
        if ('*' == input.rightChild.character) {
            this.addCharacter(input.rightChild);
        }
        return;
    /*
     * Any other character is our base case. We write is as a leaf node, and
     * start over.
     */
    default:
        if (null == input.leftChild) {
            input.leftChild = nextNode;
            return;
        }
        input.rightChild = nextNode;
        /*
         * There may be some cases where a user has not planned the PrefixTree{}
         * when writing their input, and attempts to overwrite existing leaf
         * nodes. In those cases, we ignore the character.
         */
    }
}
/**
 * Part 2: Tree traversal.  Include and implement a method preorder that
 * traverses the binary tree in preorder, and prints a list of characters in the
 * tree, the length (number of bits) of their encoding, and the encoding.
 */
public void preorder()
{
    this.preorder(this.root, new ArrayList<Integer>());
    int count = 0;
    for (ArrayList<Integer> element: this.leafPaths) {
        System.out.print(this.leafCharacters.get(count) + ": ");
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
        System.out.println("\nlength: " + element.size());
        System.out.println("");
        count++;
    }
}
private void preorder(prefixNode inputNode, Object inputList)
{
    @SuppressWarnings("unchecked")
    ArrayList<Integer> leftArgument = (ArrayList) inputList;
    @SuppressWarnings("unchecked")
    ArrayList<Integer> rightArgument = (ArrayList) inputList;
    /*
     * We have found a leaf node when we have no more children to follow. We can
     * add the mapped path to our list.
     */
    if (null == inputNode.leftChild
    &&  null == inputNode.rightChild
    ) {
        this.leafPaths.add(leftArgument);
        this.leafCharacters.add(inputNode.character);
        return;
    }
    if (null != inputNode.leftChild) {
        leftArgument.add(0);
        this.preorder(inputNode.leftChild, leftArgument.clone());
    }
    if (null != inputNode.rightChild) {
        /*
         * The initial value for an empty list is 0, which works fine for the
         * leftChild, but not os well for rightChild. Lets clear the list, and
         * start over for the root node.
         */
        if (inputNode == this.root) {
            rightArgument.clear();
        }
        rightArgument.add(1);
        this.preorder(inputNode.rightChild, rightArgument.clone());
    }
}
/**
 * Now, write a method uncompress()that reads the compressed message from
 * standard input, and writes the uncompressed message to standard output. It
 * should also display the number of bits read in, the number of characters in
 * the original message, and the compression factor.For example, the original
 * message above contains 12 characters thatwould normally requires 96 bits of
 * storage (8 bits per character). The compressed message uses only 28 bits, or
 * 29% of the space required without compression. The compression factor depends
 * on the frequency of characters in the message, but ratiosaround 50% are
 * common for English text. Note that for large messages the amount of space
 * needed to store the description of the tree is negligible compared to storing
 * the message itself, so we have ignored this quantity in the calculation.
 * Also, for simplicity, the compressed message is a sequence of the characters
 * '0' and '1'. In an actual application, these bits would be packed eight to
 * the byte, thus using 1/8th the space
 */
public void uncompress()
{
    System.out.println("Please input a binary encoded string to decompress.");
    String userString = userInput.next();
    this.queueString(userString);
    int bitCount = 0;
    while (null != this.queue.peek()) {
        bitCount += this.uncompress(this.root);
    }
    System.out.println("number of bits: " + bitCount);
    System.out.println("number of characters: " + userString.length());
    System.out.println(
        "compression ratio: " + (bitCount / userString.length()) * 100 + "%"
    );
}
private int uncompress(prefixNode input)
{
    if ('*' != input.character) {
        return 1;
    }
    char queueCharacter = this.queue.poll();
    int bitCount        = 1;
    switch (queueCharacter) {
    case '1':
        bitCount += this.uncompress(input.rightChild);
        break;
    default:
    case '0':
        bitCount += this.uncompress(input.leftChild);
    }
    return bitCount;
}
/**
 * queueString() accepts a string, and adds it to this.queue for parsing.
 * Depending upon the calling method, the string may be characters to encode, or
 * decode.
 */
private void queueString(String inputString)
{
    char[] inputCharachers = inputString.toCharArray();
    for (int loop = 0;
    loop < inputCharachers.length;
    loop++
    ) {
        this.queue.add(inputCharachers[loop]);
    }
}
public static void main(String[] args) throws IOException
{
    PrefixTree treeRoot = new PrefixTree();
    treeRoot.preorder();
    treeRoot.uncompress();
}
}
