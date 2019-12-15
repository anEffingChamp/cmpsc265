import java.util.*;

public class Graph
{
private final int MAX_VERTS = 20;
private final int INFINITY = 1000000;
private Vertex vertexList[]; // list of vertices
private int adjMat[][]; // adjacency matrix
private int nVerts; // current number of vertices

//private int currentVert;
//private int nTree; // number of verts in tree
// -------------------------------------------------------------

private static class Vertex {
    public char label; // label (e.g. 'A')
    public boolean isInTree;

    // -------------------------------------------------------------
    public Vertex(char lab) // constructor
    {
        label = lab;
        isInTree = false;
    }
    // -------------------------------------------------------------
} // end class Vertex

private static class Edge implements Comparable<Edge> {
    public int srcVert; // index of a vertex starting edge
    public int destVert; // index of a vertex ending edge
    public int distance; // distance from src to dest
    // -------------------------------------------------------------

    public Edge(int sv, int dv, int d) // constructor
    {
        srcVert = sv;
        destVert = dv;
        distance = d;
    }
    // -------------------------------------------------------------

    public int compareTo(Edge that){
        if (this.distance<that.distance) return -1;
        else if (this.distance==that.distance) return 0;
        else return 1;
    }
} // end class Edge
    ////////////////////////////////////////////////////////////////

public Graph() // constructor
{
    vertexList = new Vertex[MAX_VERTS];
    // adjacency matrix
    adjMat = new int[MAX_VERTS][MAX_VERTS];
    nVerts = 0;
    for (int j = 0; j < MAX_VERTS; j++) // set adjacency
        for (int k = 0; k < MAX_VERTS; k++) // matrix to 0
            adjMat[j][k] = INFINITY;
} // end constructor
    // -------------------------------------------------------------
public void addVertex(char lab) {
    vertexList[nVerts++] = new Vertex(lab);
}

// -------------------------------------------------------------
public void addEdge(int start, int end, int weight) {
    adjMat[start][end] = weight;
    adjMat[end][start] = weight;
}

// -------------------------------------------------------------
public void displayVertex(int v) {
    System.out.print(vertexList[v].label);
}
/**
 * Please finish the implementation of the method of kruskalMST() which will
 * find the minimum spanning tree on a connected undirected weighted graph.
 * The Kruskal's algorithm for finding minimum spanning tree is as follows:
 * - Initially, the MST contains all vertices but no edges.
 * - Sort the edges in a non-decreasing order.
 * - Go over (sorted list of) edges and add an edge to the MST.
 * Important: If the edge makes a cycle, ignore it.
 * - Continue until N-1 edges are added, when MST is formed.
 * How to detect whether adding an edge can make a cycle? We can use a
 * union_find data structure whose implementation has been provided to you. It
 * supports operations as makeSet(), find(), union().
 * - First, we can make N set (one for each vertex on the graph)
 * - Every time we want to add an edge ab to the spanning tree, we
 * first check whether find(a)==find(b), indicating whether they belong to the
 * same union. If true, it will make a cycle, and we cannot add edge ab.
 * Otherwise, the edge ab will be added to MST, and we union the two sub-unions
 * where a and b belongs to by union(a, b).
 */
public void kruskalMST()
{
    PriorityQueue<Edge> completeTree = this._getKruskalTree();
    /*
     * Once we have the queue, we can display the tree and see how much it
     * weighs.
     */
    while (0 != completeTree.size()) {
        Edge nextEdge = completeTree.remove();
        System.out.println(
            this.vertexList[nextEdge.srcVert].label + " --- "
            + this.vertexList[nextEdge.destVert].label
            + ": " + nextEdge.distance
        );
    }
}
/**
 * We will create a minimum priority queue of the edges so that we can find
 * positions for them. completeTree will actually contain all edges in the
 * tree, but we will only display those necessary for a minimum spanning
 * tree.
 */
private PriorityQueue<Edge> _getKruskalTree()
{
    PriorityQueue<Edge> completeTree = new PriorityQueue<Edge>();
    for (int loop = 0;
    loop < this.nVerts;
    loop++
    ) {
        for (int innerLoop = 0;
        innerLoop < this.adjMat[loop].length;
        innerLoop++
        ) {
            /*
             * Once we identify a weighted edge, we find its position in the
             * minimum priority queue.
             */
            int edgeDistance = this.adjMat[loop][innerLoop];
            if (INFINITY == edgeDistance) {
                continue;
            }
            completeTree.add(new Edge(loop, innerLoop, edgeDistance));
        }
    }
    /*
     * Once we have the queue, we can display the tree and see how much it
     * weighs.
     * Now we make a set of vertices for UnionFind{}. This will help us to find
     * cycles.
     */
    UnionFind union            = new UnionFind(this.nVerts);
    PriorityQueue<Edge> output = new PriorityQueue<Edge>();
    while (0 != completeTree.size()) {
        /*
         * We know that the completeTree will include each edge twice, so we can
         * skip the next item. It will be the same edge.
         */
        Edge nextEdge = completeTree.remove();
        if (union.find(nextEdge.srcVert) == union.find(nextEdge.destVert)) {
            continue;
        }
        union.union(nextEdge.srcVert, nextEdge.destVert);
        output.add(nextEdge);
    }
    return output;
}
/**
 * Problem 2: Finding single-source shortest paths using Bellman- Ford algorithm
 * (35)
 * Description:
 * Please finish the implementation of the method of bellman_ford(source) which
 * finds and returns the shortest paths as well as the weights of the shortest
 * paths from the source vertex to all other vertices on a connected undirected
 * weighted graph.
 * Bellman-Ford algorithm adopts dynamic programming, which uses a table
 * (one-dimensional array of size N) to save distance to each node, initialize
 * with infinity except for the source which is 0 distance from itself. It is an
 * iterative solution, and needs to iterate N-1 (N here is the number of
 * vertices in graph) times, in each iteration, it will look at all edges and
 * see if you need to update distance from source (update table). For edge u->v
 * do: D(v) = min[D(v), D(u) + w(u,v)].
 *
 */
public void bellman_ford(int input)
{
    int[] distance                  = new int[nVerts];
    int[] parent                    = new int[nVerts];
    String[] shortestPaths          = new String[nVerts];
    PriorityQueue<Edge> minimumTree = this._getKruskalTree();
    /*
     * We start with our source node, and map out the shortest distances to all
     * directly linked nodes in the graph.
     */
    for (int loop = 0;
    loop < this.nVerts;
    loop++
    ) {
        if (loop == input) {
            parent[loop]   = input;
            distance[loop] = 0;
        }
        /*
         * We initialize the distance for each node to the theoretical maximum,
         * so that we have a decent starting point for finding the minimum. Then
         * we find the nearest parent for that node.
         */
        parent[loop]   = INFINITY;
        distance[loop] = INFINITY;
        for (int innerLoop = 0;
        loop < this.nVerts;
        loop++
        ) {
            if (distance[innerLoop] > this.adjMat[loop][innerLoop]) {
                parent[innerLoop] = loop;
                distance[loop]    = this.adjMat[loop][innerLoop];
            }
        }
    }
    System.out.println("shortest path \t\t weight");
    for (int loop = 0;
    loop < this.nVerts;
    loop++
    ) {
        if (INFINITY != parent[loop]) {
            System.out.println(
                this.vertexList[input].label
                + " -> " + this.vertexList[loop].label
                + " \t\t\t " + distance[loop]
            );
        }
    }
}
/**
 * Given an input vertex, denoted by its integer value, we find the closest
 * parent.
 */
private int _shortestDistance(int input)
{
    return 1;
}
/**
 * Floyd_Warshall is an algorithm for finding all pairs shortest paths in a
 * weighted graph with positive or negative edge weights (but with no
 *
 *  negative cycles). Its basic idea is to one by one pick all vertices and
 *  updates all shortest paths that include the picked vertex as an intermediate
 *  vertex in the shortest path.
 */
public void floyd_warshall()
{
    int[][] distance = new int[nVerts][nVerts];
    // YOUR CODES
}
public static void main(String[] args) {
    // Problem 1
    Graph theGraph1 = new Graph();
    theGraph1.addVertex('a'); // 0 (start for mst)
    theGraph1.addVertex('b'); // 1
    theGraph1.addVertex('c'); // 2
    theGraph1.addVertex('d'); // 3
    theGraph1.addVertex('e'); // 4
    theGraph1.addVertex('f'); // 5

    theGraph1.addEdge(0, 1, 6); // ab 6
    theGraph1.addEdge(0, 4, 4); // ae 4
    theGraph1.addEdge(1, 2, 10); //bc 10
    theGraph1.addEdge(1, 4, 7); // be 7
    theGraph1.addEdge(1, 5, 7); // bf 7
    theGraph1.addEdge(2, 3, 6); // cd 6
    theGraph1.addEdge(2, 4, 8); // ce 8
    theGraph1.addEdge(2, 5, 5); // cf 6
    theGraph1.addEdge(3, 5, 7); // df 12
    theGraph1.addEdge(4, 5, 12); // ef 12

    System.out.println("Minimum spanning tree: ");
    theGraph1.kruskalMST(); // minimum spanning tree
    System.out.println();

    // Problem 2
    Graph theGraph2 = new Graph();
    theGraph2.addVertex('a'); // 0
    theGraph2.addVertex('b'); // 1
    theGraph2.addVertex('c'); // 2
    theGraph2.addVertex('d'); // 3
    theGraph2.addVertex('e'); // 4

    theGraph2.addEdge(0, 1, 2); // ab 2
    theGraph2.addEdge(0, 2, 3); // ac 3
    theGraph2.addEdge(1, 3, 1); // bd 1
    theGraph2.addEdge(2, 1, -2); //cb -2
    theGraph2.addEdge(2, 4, 1); // ce 1
    theGraph2.addEdge(4, 3, 4); // cd 6

    System.out.println("Single-source Shortest Paths ");
    theGraph2.bellman_ford(0); // minimum spanning tree
    System.out.println();

    Graph theGraph3 = new Graph();
    theGraph3.addVertex('1'); // 0 (start for mst)
    theGraph3.addVertex('2'); // 1
    theGraph3.addVertex('3'); // 2
    theGraph3.addVertex('4'); // 3

    theGraph3.addEdge(0, 1, 8); // '1-2' 8
    theGraph3.addEdge(0, 3, 1); // '1-4' 1
    theGraph3.addEdge(1, 2, 1); // '2-1' 1
    theGraph3.addEdge(2, 0, 4); // '3-1' 4
    theGraph3.addEdge(3, 1, 2); // '4-2' 2
    theGraph3.addEdge(3, 2, 9); // '4-3' 9

    System.out.println("All Pairs Shortest Paths ");
    theGraph3.floyd_warshall();
    System.out.println();
}
} // end class Graph
    ////////////////////////////////////////////////////////////////
