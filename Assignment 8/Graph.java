/*
Jason Wilson
Thursday, April 16th 2020
CMPT435L 111 20S
*/


import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Graph {
	private Vertex vertexList[];
	private int adjMat[][]; //adjacency matrix
	private LinkedList<LinkedList<Integer>> adjlist; //adjacency list
	private int vertexcycleflag[]; //for detecting cycles
	private int nVerts;
	private Stack<Integer> theStack; //for DFS
	private Queue theQueue; //for BFS

	public static void main(String[] args) {
		// complete the main method to
		// a. create a graph for problem 5 in Assignment 8
		char[] elements = {'0', '1', '2', '3', '4', '5'};
		Graph graphList = new Graph(elements.length);

		for (char e : elements) {
			graphList.addVertex(e);
		}

		graphList.addEdge(0, 1);
		graphList.addEdge(0, 2);
		graphList.addEdge(1, 2);
		graphList.addEdge(1, 3);
		graphList.addEdge(2, 3);
		graphList.addEdge(3, 4);
		graphList.addEdge(4, 0);
		graphList.addEdge(4, 1);
		graphList.addEdge(4, 5);

		// print out the adjancency list
		for (int i = 0; i < elements.length; i++) {
			LinkedList currentList = graphList.adjlist.get(i);
			System.out.print("Vertex ");
			graphList.displayVertex(i);
			for (int j = 0; j < currentList.size(); j++) {
				System.out.print(" -> ");
				System.out.print(currentList.get(j));
			}
			System.out.print(".\n");
		}



		// b. test if the graph contains cycles for problem 6 in Assignment 8

		for (int i = 0; i < graphList.vertexList.length; i++) {
			if (graphList.detectcycle(i)) {
				System.out.println("There exists a cycle starting with vertex " + i + ".");
				break;
			}
		}


	}


	 public Graph(int n) {

		  vertexList = new Vertex[n];

		  vertexcycleflag = new int[n];//For detecting cycles, nodes are either -1, 0, or 1


		  for  (int i = 0; i < n; i++) {
			  vertexcycleflag[i] = -1; //Initially, all nodes are -1
		  }


		  //adj matrix
		  adjMat = new int[n][n];
		  nVerts = 0;
		  for (int i = 0; i < n; i++) {
		   for (int j = 0; j < n; j++) {
		    adjMat[i][j] = 0;
		   }
		  }

		  //adj list

		  adjlist = new LinkedList<LinkedList<Integer>>();
		  for (int i = 0; i < n; i++) {

				adjlist.add(new LinkedList<Integer>());
			}

		  theStack = new Stack<Integer>();
		  theQueue = new Queue();
		 }

	public void addVertex(char nodename) {// add vertex
		vertexList[nVerts++] = new Vertex(nodename);
	}

	public void addEdge(int start, int end) {// directed
		//adj matrix
		adjMat[start][end] = 1;

		//adjMat[end][start] = 1; for undirected graph
		//adj list

		if(!adjlist.get(start).contains(end))
			adjlist.get(start).add(end);

		/* if(!adjlist.get(end).contains(start))
			adjlist.get(end).add(start); // for undirected graph
		*/

	}

	public void displayVertex(int v) {// print vertex label
		System.out.print(vertexList[v].lable);
	}

	public int getAdjUnvisitedVertex(int v) {// get an unvisited connected vertex
		for (int i = 0; i < nVerts; i++) {
			if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
				return i;
			}
		}
		return -1;
	}


	public int getUnvisitedCycle(int vertex) {
		for (int i = 0; i < adjlist.get(vertex).size(); i++) {
			if (vertexList[adjlist.get(vertex).get(i)].cycleflag != 1) {
				return i;
			}
		}
		return -1;
	}



	public boolean detectcycle(int startingNode)
	{

		for (int i = 0; i < nVerts; i++) {
			vertexList[i].cycleflag = -1;// Reset the cycleflag
		}

		Stack<Integer> cycleStack = new Stack<Integer>();

		vertexList[startingNode].cycleflag = 0;
		cycleStack.push(startingNode);

		while (!cycleStack.isEmpty()) {
			int neighbor = getUnvisitedCycle(cycleStack.peek());

			// If all neighbors are visited / are no more neighbors to visit
			// pop from stack and set flag as visited.
			if (neighbor == -1) {
				int w = cycleStack.pop();
				vertexList[w].cycleflag = 1;
			}

			// Check for cycle, return true if found
			else if (vertexList[neighbor].cycleflag == 0) {
				return true;
			}
			// else move to the next unvisited neighbor
			else {
				vertexList[neighbor].cycleflag = 0;
				cycleStack.push(neighbor);
			}

		}

		return false;

	}


	public void dfs() {// DFS using stack

		for (int i = 0; i < nVerts; i++) {
			vertexList[i].wasVisited = false;// Reset the wasvisited matrix
		}
		//Pick the starting node randomly
		Random rand = new Random();
		int randNum = rand.nextInt(nVerts);

		//Visit the starting node
		vertexList[randNum].wasVisited = true;
		displayVertex(randNum);
		theStack.push(randNum);

		while (!theStack.isEmpty()) {
			int neighbor = getAdjUnvisitedVertex(theStack.peek());
			if (neighbor == -1) {
				theStack.pop();
			} else {
				vertexList[neighbor].wasVisited = true;
				displayVertex(neighbor);
				theStack.push(neighbor);
			}
		}


	}




	public void bfs() {// BFS using a queue

		for (int j = 0; j < nVerts; j++) {
				vertexList[j].wasVisited = false; // Reset the wasvisited matrix
		}
		//Pick the starting node randomly
		Random rand = new Random();
		int randNum = rand.nextInt(nVerts);

		//Visit the starting node
		vertexList[randNum].wasVisited = true;
		displayVertex(randNum);
		theQueue.insert(randNum);


		while (!theQueue.isEmpty()) {
			int currentv = theQueue.remove();
			int neighbor;
			while ((neighbor = getAdjUnvisitedVertex(currentv)) != -1) {
				vertexList[neighbor].wasVisited = true;
				displayVertex(neighbor);
				theQueue.insert(neighbor);
			}
		}


	}

}
