import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, stNum, edNum;
	static ArrayList<ArrayList<Node>> adjList;

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
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList<ArrayList<Node>>();
		boolean[] visited = new boolean[N + 1];

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
		stNum = Integer.parseInt(st.nextToken());
		edNum = Integer.parseInt(st.nextToken());

		int[] dist = new int[N + 1];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.weight, o2.weight));

		q.offer(new Node(stNum, 0));
		visited[stNum]=true;
		dist[stNum] = 0;
		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (dist[curr.ed] < curr.weight) {
				continue;
			}
			visited[curr.ed]=true;
			for (int i = 0; i < adjList.get(curr.ed).size(); i++) {
				Node nxt = adjList.get(curr.ed).get(i);
				if (!visited[nxt.ed] && (dist[nxt.ed] > curr.weight + nxt.weight) ) {
					dist[nxt.ed] = curr.weight + nxt.weight;
					q.offer(new Node(nxt.ed, dist[nxt.ed]));
				}
			}

		}

		System.out.println(dist[edNum]);

	}// end of main

}// end of class