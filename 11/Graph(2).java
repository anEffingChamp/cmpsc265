import java.util.*;

public class Graph {
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
	
	public void kruskalMST(){
		double weight=0;   // weight of MST
		/* Maintain edges in the MST in a queue
		 * 
		 */
		Queue<Edge> mst = new LinkedList<Edge>();  // edges in MST
		
		// YOUR CODES
		
	}
	
	public void bellman_ford(int source){
		int[] distance = new int[nVerts];
		int[] parent = new int[nVerts];
		String[] shortestPaths = new String[nVerts];
		
		// YOUR CODES
	}
	
	public void floyd_warshall(){
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