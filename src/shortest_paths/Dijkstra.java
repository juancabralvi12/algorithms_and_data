package shortest_paths;

import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Dijkstra {
	static class Edge {
		int weigth; 
		int destination;
		int source;
		public Edge(int source, int destination, int weigth){
			this.weigth = weigth;
			this.source = source;
			this.destination = destination;
		}
	}

	static class Graph {

		LinkedList<Edge> adjList[];	
		int V;

		public Graph(int V){
			this.V = V;
			adjList = new LinkedList[V];
		}

		public void addEdge(Edge edge){
			int source = edge.source;
			if (adjList[source] == null) {
				adjList[source] = new LinkedList<>();
			}
			adjList[source].add(edge);
		}

		public int findMinimum(int []Q, boolean[] visited){
			int minValue = Integer.MAX_VALUE;
			int index = -1;

			for(int i=0; i<Q.length; i++){
				if (Q[i] < minValue && !visited[i]){
					minValue = Q[i];
					index = i;
				}
			}
			if (index != -1){
				visited[index] = true;
			}
			return index;
		}

		public int dijkstra(int source, int destination){

			int []Q = new int[V];
			boolean []visited = new boolean[V];

			int INFINITY = Integer.MAX_VALUE;

			for (int i=0; i<V; i++){
				Q[i] = INFINITY;
				visited[i] = false;
			}

			Q[source] = 0;
			int u;

			while ((u = findMinimum(Q, visited)) != -1){
				Iterator<Edge> it = adjList[u].iterator();
				Edge e;

				while(it.hasNext()){
					e = it.next();
					int newWeigth = Q[u] + e.weigth; 

					if (newWeigth < Q[e.destination]){
						Q[e.destination] = newWeigth;
					}
				}

			}
			return Q[destination];

			
		}
	}

		public static void main(String []args){	

			int size = 5;
			Graph graph = new Graph(size);

			graph.addEdge(new Edge(0,1,10));
			graph.addEdge(new Edge(0,2,3));
			graph.addEdge(new Edge(1,2,4));
			graph.addEdge(new Edge(1,3,2));
			graph.addEdge(new Edge(2,4,2));
			graph.addEdge(new Edge(2,3,8));
			graph.addEdge(new Edge(2,1,1));
			graph.addEdge(new Edge(3,4,7));
			graph.addEdge(new Edge(4,3,9));

			System.out.println(graph.dijkstra(0,1));
			System.out.println(graph.dijkstra(0,2));
			System.out.println(graph.dijkstra(0,3));
			System.out.println(graph.dijkstra(0,4));
		}
	}
