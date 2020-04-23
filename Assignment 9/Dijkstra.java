/*
Jason Wilson
Thursday, April 23rd 2020
CMPT435L 111 20S
*/

public class Dijkstra {




	// Dijkstra's algorithm to find shortest path from s to all other nodes


	public static int[] dijkstra(WeightedGraph G, int s) {

		int[] dist = new int[G.size()]; // estimated shortest known distance from "s"

		int[] pred = new int[G.size()]; // preceding node in path

		boolean[] visited = new boolean[G.size()]; // all false initially

		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE; // set to infinity initially
		}

		dist[s] = 0;

		for (int i = 0; i < dist.length; i++) {

			int next = minVertex(dist, visited);
			// Select the next vertex to add to the tree
			// Vertex "next": not in the tree and has min dist[] value

			visited[next] = true;

			// The shortest path to vertext next is dist[next] and via pred[next].

			int[] n = G.neighbors(next);
			// Find the neighbors of vertex "next"


			// Coutner j
			int j = 0;
			// while there are neighbors of "next" in array n
			while(true) {
				if(j < n.length) {

					// v is the neighbor n[j] to check for the lightest weight for all neighbors
					int v = n[j];

					// check against the current shortest path, if this weight is less
					// then set it dist and pred accordingly
					if (dist[v] > dist[next] + G.getWeight(next, v)) {
						dist[v] = dist[next] + G.getWeight(next, v);
						pred[v] = next;
					}

					// Incriment the counter
					j++;

					// break once limit is reached
				} else {
					break;
				}
			}

		}
		return pred; // (ignore pred[s]==0!)
	}

	private static int minVertex(int[] dist, boolean[] v) {
		int x = Integer.MAX_VALUE;
		int y = -1; // graph not connected, or no unvisited vertices
		for (int i = 0; i < dist.length; i++) {
			if (!v[i] && dist[i] < x) {
				// unvisited -- not in the tree yet, and smaller dist[]
				y = i;
				x = dist[i];
			}
		}
		return y;
	}

	public static void printPath(WeightedGraph G, int[] pred, int s, int e) {
		java.util.ArrayList path = new java.util.ArrayList();
		int x = e;
		while (x != s) {
			path.add(0, G.getLabel(x));
			x = pred[x];
		}
		path.add(0, G.getLabel(s));
		System.out.println(path);
	}

}
