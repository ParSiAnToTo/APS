import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, X, Y, Z;
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
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList<ArrayList<Node>>();

		for (int i = 0; i < N + 1; i++) {
			adjList.add(new ArrayList<Node>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList.get(a).add(new Node(b, w));


		}
		st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		Z = Integer.parseInt(st.nextToken());

		long distXYZ = 0;
		boolean yChecker = false;
		distXYZ += dijk(X, Y, yChecker);
		distXYZ += dijk(Y, Z, yChecker);

		yChecker = true;
		long distXZ =dijk(X, Z, yChecker);


		if (distXYZ >= Integer.MAX_VALUE) {
			distXYZ=-1;			
		}
		if(distXZ >= Integer.MAX_VALUE) {
			distXZ = -1;
		} 

		System.out.println(distXYZ + " "+ distXZ);

	}// end of main

	static int dijk(int st, int ed, boolean chk) {
		pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		visited = new boolean[N + 1];
		dist = new int[N + 1];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		if(chk) {
			visited[Y]=true;
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