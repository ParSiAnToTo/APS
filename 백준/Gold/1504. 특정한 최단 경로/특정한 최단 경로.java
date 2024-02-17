import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, E, V1, V2;
	static ArrayList<ArrayList<Node>> adjList;
	static PriorityQueue<Node> pq;
	static int[] dist;
	static boolean[] visited;

	static class Node {
		int ed;
		int weight;

		public Node(int ed, int weight) {

			this.ed = ed;
			this.weight = weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adjList = new ArrayList<ArrayList<Node>>();

		for (int i = 0; i < N + 1; i++) {
			adjList.add(new ArrayList<Node>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList.get(a).add(new Node(b, w));
			adjList.get(b).add(new Node(a, w));

		}
		st = new StringTokenizer(br.readLine(), " ");
		V1 = Integer.parseInt(st.nextToken());
		V2 = Integer.parseInt(st.nextToken());

		long v1Tov2 = 0;
		v1Tov2 += dijk(1, V1);
		v1Tov2 += dijk(V1, V2);
		v1Tov2 += dijk(V2, N);

		long v2Tov1 = 0;
		v2Tov1 += dijk(1, V2);
		v2Tov1 += dijk(V2, V1);
		v2Tov1 += dijk(V1, N);

		long ans = 0;
		if (v1Tov2 >= Integer.MAX_VALUE && v2Tov1 >= Integer.MAX_VALUE) {
			ans = -1;
		} else {
			ans = Math.min(v1Tov2, v2Tov1);
		}

		System.out.println(ans);

	}// end of main

	static int dijk(int st, int ed) {
		pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		visited = new boolean[N + 1];
		dist = new int[N + 1];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dist[st] = 0;
		pq.offer(new Node(st, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (visited[curr.ed]) {
				continue;
			}
			visited[curr.ed] = true;

			for (int i = 0; i < adjList.get(curr.ed).size(); i++) {
				Node nxt = adjList.get(curr.ed).get(i);
				if (!visited[nxt.ed] && dist[nxt.ed] > nxt.weight + curr.weight) {
					dist[nxt.ed] = nxt.weight + curr.weight;
					pq.offer(new Node(nxt.ed, dist[nxt.ed]));
				}

			}

		}

		return dist[ed];
	}

}// end of class