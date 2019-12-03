import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Graph {
public static class Vertex {
    public char label; // label (e.g. 'A')
    public boolean wasVisited;
    // -------------------------------------------------------------
    public Vertex(char lab) // constructor
    {
        label = lab;
        wasVisited = false;
    }
    // -------------------------------------------------------------
} // end class Vertex

private final int MAX_VERTS = 20;
private Vertex vertexList[]; // list of vertices
private int adjMat[][]; // adjacency matrix
private int nVerts; // current number of vertices
private Queue<Integer> theQueue;
private Stack<Integer> theStack;

// ------------------------------------------------------------
public Graph() // constructor
{
    vertexList = new Vertex[MAX_VERTS];
    // adjacency matrix
    adjMat = new int[MAX_VERTS][MAX_VERTS];
    nVerts = 0;
    for (int j = 0; j < MAX_VERTS; j++) // set adjacency
        for (int k = 0; k < MAX_VERTS; k++) // matrix to 0
            adjMat[j][k] = 0;
    theQueue = new LinkedList<Integer>();
    theStack = new Stack<Integer>();
} // end constructor

public void addVertex(char lab) {
    vertexList[nVerts++] = new Vertex(lab);
}

// -------------------------------------------------------------
public void addEdge(int start, int end) {
    adjMat[start][end] = 1;
    adjMat[end][start] = 1;
}

// -------------------------------------------------------------
public void displayVertex(int v) {
    System.out.print(vertexList[v].label);
}

// -------------------------------------------------------------
public void bfs() // breadth-first search
{ // begin at vertex 0
    vertexList[0].wasVisited = true; // mark it
    displayVertex(0); // display it
    theQueue.add(0); // insert at tail
    int v2;

    while (!theQueue.isEmpty()) // until queue empty,
    {
        int v1 = theQueue.remove(); // remove vertex at head
        // until it has no unvisited neighbors
        while ((v2 = getAdjUnvisitedVertex(v1)) != -1) { // get one,
            vertexList[v2].wasVisited = true; // mark it
            displayVertex(v2); // display it
            theQueue.add(v2); // insert it
        } // end while
    } // end while(queue not empty)

    // queue is empty, so we're done
    for (int j = 0; j < nVerts; j++) // reset flags
        vertexList[j].wasVisited = false;
} // end bfs()
    // -------------------------------------------------------------
    // returns an unvisited vertex adj to v

/*
 * Iterative DFS
 */
public void dfs() // depth-first search implemented using iteration
{ // begin at vertex 0
    vertexList[0].wasVisited = true; // mark it
    displayVertex(0); // display it
    theStack.push(0); // push it

    while (!theStack.isEmpty()) // until stack empty,
    {
        // get an unvisited vertex adjacent to stack top
        int v = getAdjUnvisitedVertex(theStack.peek());
        if (v == -1) // if no such vertex,
            theStack.pop();
        else // if it exists,
        {
            vertexList[v].wasVisited = true; // mark it
            displayVertex(v); // display it
            theStack.push(v); // push it
        }
    } // end while

    // stack is empty, so we're done
    for (int j = 0; j < nVerts; j++) // reset flags
        vertexList[j].wasVisited = false;
} // end dfs

/*
 * Recursive DFS
 */
public void dfsRecursive(){
    for (int j = 0; j < nVerts; j++) // reset flags
        vertexList[j].wasVisited = false;
    dfsRecursive(0);
}

public void dfsRecursive(int id){
    vertexList[id].wasVisited=true;
    for (int neighbor = 0; neighbor < nVerts; neighbor++) {
        if (adjMat[id][neighbor]==1 && vertexList[neighbor].wasVisited==false){
            dfsRecursive(neighbor);
        }
    }
}

public int getAdjUnvisitedVertex(int v) {
    for (int j = 0; j < nVerts; j++)
        if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
            return j;
    return -1;
} // end getAdjUnvisitedVertex()
/*
 * The
 * attached GraphProcess.java file contains the definition for the Vertex Class
 * as well as for the Graph class. Please finish the implementation of the
 * method of detectConnectedComponent() which will findout all the connected
 * componentsin an undirected graph.
 * It is known that a connected component in a graph is a sub-graph of the
 * original graph in which there is at least one path between every two vertices
 * (nodes).For example, the figure on the left contains only one connected
 * component, which is the graph itself. However, the figure on the right
 * contains two connected components:  Nodes set {a, b, c, d, e} forms one
 * connected component, and the Nodes set {d, f} forms another one.
 */
public ArrayList<ArrayList<Integer>> detectConnectedComponent()
{
    /*
     * Lets start by resetting the flags for all included vertices. That ensures
     * a fresh start when traversing the graph. We can also initialize our
     * output variable, and prepare to assign things.
     */
    this._resetGraph();
    ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
    int vertexCount                      = 0;
    /*
     * We can start with the first vertex on the list, and see how large a
     * component we can build from that. If we miss any vertices, we can loop
     * through this.vertexList to get the next one.
     */
    for (int loop = 0;
    loop < this.nVerts;
    loop++
    ) {
        if (false == this.vertexList[loop].wasVisited) {
            output.add(this.detectConnectedComponent(loop));
        }
    }
    return output;
}
private ArrayList<Integer> detectConnectedComponent(int input)
{
    ArrayList<Integer> output         = new ArrayList<Integer>();
    output.add(input);
    this.vertexList[input].wasVisited = true;
    while (-1 != this.getAdjUnvisitedVertex(input)) {
        int targetVertex = this.getAdjUnvisitedVertex(input);
        output.add(targetVertex);
        this.vertexList[targetVertex].wasVisited = true;
    }
    return output;
}
/**
 * Please finish definition of the findPath()method within the GraphProcess
 * class, so that given two vertices, itcan detect whether there exists a path
 * them, and therefore they are connected.
 * For example, on the following figure, vertex aand bare connected, but vertex
 * a and f are not
 * You can apply the idea of either DFS or BFS to implement this.  If two
 * vertices are connected, staring DFS or BFS on either onenode can reach the
 * other.
 */
// TODO Am I supposed to divide the graph into components? The example in the
// problem description says yes, but the text of the problem says no. In this
// case, the answer will always be true, because all nodes in a single graph are
// connected.
public boolean findPath(int start, int end)
{
    this._resetGraph();
    return this._findPath(start, end);
}
private boolean _findPath(int start, int end)
{
    this.vertexList[start].wasVisited = true;
    while (-1 != this.getAdjUnvisitedVertex(start)) {
        if (end  == this.getAdjUnvisitedVertex(start)
        ||  true == this._findPath(this.getAdjUnvisitedVertex(start), end)
        ) {
            return true;
        }
    }
    return false;
}
/**
 * _resetGraph() sets each vertex as if it had not been visited. This is
 * necessary whenever we want to traverse the graph again in the same program
 * run.
 */
private void _resetGraph()
{
    for (int j = 0; j < nVerts; j++) {
        this.vertexList[j].wasVisited = false;
    }
}
/**
 * Please finish the implementation of method hasCycle()which can detect whether
 * exists any cycle in an undirected graph.You can use a recursive DFS to
 * implement this.  The basic algorithm is as:Start DFS, return true if you see
 * a visited node thatis not your parent (calling node). If the search is
 * doneand it dose not return true, return false.For example, the left graph
 * contains a cycle, but the right one does not.
 */
public boolean hasCycle()
{
    for (int loop = 0;
    loop < this.nVerts;
    loop++
    ) {
        this._resetGraph();
        this.vertexList[loop].wasVisited     = true;
        int nextNode                         = this.getAdjUnvisitedVertex(loop);
        this.vertexList[nextNode].wasVisited = true;
        if (-1   != this.getAdjUnvisitedVertex(loop)
        &&  true == this._findPath(nextNode, this.getAdjUnvisitedVertex(loop))
        ) {
            return true;
        }
    }
    return false;
}
/**
 * printConnectedComponents() lets a graph print the connected components as
 * parsed by Graph::detectConnectedComponent().
 */
public void printConnectedComponents()
{
    ArrayList<ArrayList<Integer>> vertexComponents =
        this.detectConnectedComponent();
    System.out.println("");
    System.out.println(
        "There are " + vertexComponents.size()
        + " connected components in this graph. They are:"
    );
    for (int loop = 0;
    loop < vertexComponents.size();
    loop++
    ) {
        System.out.print("Connected component " + loop + ": [");
        ArrayList<Integer> component = vertexComponents.get(loop);
        for (int loopComponent = 0;
        loopComponent < component.size();
        loopComponent++
        ) {
            String componentSeparator = ", ";
            if (0 == loopComponent) {
                componentSeparator = "";
            }
            System.out.print(componentSeparator + component.get(loopComponent));
        }
        System.out.println("]");
    }
}

public static void main(String[] args) {
    Graph theGraph1 = new Graph();
    theGraph1.addVertex('a'); // 0
    theGraph1.addVertex('b'); // 1
    theGraph1.addVertex('c'); // 2
    theGraph1.addVertex('d'); // 3
    theGraph1.addVertex('e'); // 4
    theGraph1.addVertex('f'); // 5

    theGraph1.addEdge(0, 1); // ab
    theGraph1.addEdge(0, 2); // ac
    theGraph1.addEdge(0, 4); // ae
    theGraph1.addEdge(1, 3); // bd
    theGraph1.addEdge(2, 3); // cd
    theGraph1.addEdge(3, 5); // df
    theGraph1.addEdge(4, 5); // ef

    Graph theGraph2 = new Graph();
    theGraph2.addVertex('a'); // 0
    theGraph2.addVertex('b'); // 1
    theGraph2.addVertex('c'); // 2
    theGraph2.addVertex('d'); // 3
    theGraph2.addVertex('e'); // 4
    theGraph2.addVertex('f'); // 5

    theGraph2.addEdge(0, 1); // ab
    theGraph2.addEdge(0, 2); // ac
    theGraph2.addEdge(0, 4); // ae
    theGraph2.addEdge(3, 5); // df

    Graph theGraph3 = new Graph();
    theGraph3.addVertex('a'); // 0
    theGraph3.addVertex('b'); // 1
    theGraph3.addVertex('c'); // 2
    theGraph3.addVertex('d'); // 3
    theGraph3.addVertex('e'); // 4
    theGraph3.addVertex('f'); // 5

    theGraph3.addEdge(0, 1); // ab
    theGraph3.addEdge(0, 2); // ac
    theGraph3.addEdge(0, 4); // ae
    theGraph3.addEdge(1, 3); // bd
    theGraph3.addEdge(3, 5); // df

    /*
     * Your codes on detecting connected components
     * on Graph theGraph1 and theGraph2
     */
    theGraph1.printConnectedComponents();
    theGraph2.printConnectedComponents();
    /*
     * Your codes on finding a path on Graph theGraph1
     */
    Scanner userInput = new Scanner(System.in);
    System.out.println("Please enter vertex 1: ");
    String vertex1    = userInput.next();
    System.out.println("Please enter vertex 2: ");
    String vertex2    = userInput.next();
    String connection = "not";
    /*
     * a corresponds to 0 in this object, so we need to subtract 97 from the
     * ASCII value of the character.
     */
    if (true == theGraph1.findPath(
        vertex1.charAt(0) - 97, vertex2.charAt(0) - 97
    )) {
        connection = "";
    }
    System.out.println(
        "There is " + connection + " a connection between these vertices."
    );
    /*
     * Your codes on finding cycle on Graph
     * theGraph1 and theGraph3
     */
    connection = " not ";
    if (true == theGraph1.hasCycle()) {
        connection = " ";
    }
    System.out.println("theGraph1 does" + connection + "have cycles.");
    connection = " not ";
    if (true == theGraph3.hasCycle()) {
        connection = "";
    }
    System.out.println("theGraph3 does" + connection + "have cycles.");
} // end main()
}
