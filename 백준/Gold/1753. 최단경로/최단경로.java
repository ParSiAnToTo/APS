import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int V, E, K;
	static List<Node>[] adjList;
	static int[] dist;

	static class Node implements Comparable<Node>{
		int ed, weights;

		public Node(int ed, int weights) {
			this.ed = ed;
			this.weights = weights;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return weights-o.weights;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		K = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[V + 1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[start].add(new Node(end, weight));
		}

		dist = new int[V + 1];
		Arrays.fill(dist, INF);

		dijkstra(K);
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] != INF) {
				System.out.println(dist[i]);
			} else {
				System.out.println("INF");
			}
		}
	}// end of main

	static void dijkstra(int v) {
		boolean[] visited = new boolean[V + 1];
		dist[v] = 0;

		for (int i = 0; i < V; i++) {
			int min = INF;
			int idx = -1;

			for (int j = 1; j < V + 1; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}

			if (idx == -1) {
				break;
			}

			visited[idx] = true;

			for (Node curr : adjList[idx]) {
				if (!visited[curr.ed] && dist[curr.ed] > dist[idx] + curr.weights) {
					dist[curr.ed] = dist[idx] + curr.weights;
				}
			}

		}

	}

}// end of class
