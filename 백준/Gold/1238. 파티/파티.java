import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node>{
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int N, M, X;
	static List<Node>[] adjList, reverse_adjList;
	static int[] dist, reverse_dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N + 1];
		reverse_adjList = new ArrayList[N + 1];
		
		for (int i = 0; i < N + 1; i++) { // adjList init
			adjList[i] = new ArrayList<>();
			reverse_adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			adjList[A].add(new Node(B, W)); // directed graph add
			reverse_adjList[B].add(new Node(A, W)); // directed graph add
		}

		dist = new int[N + 1];
		Arrays.fill(dist, INF);
		reverse_dist = new int[N + 1];
		Arrays.fill(reverse_dist, INF);

		dijk(X, dist, adjList);
		dijk(X, reverse_dist, reverse_adjList);
		
		
		int ans = -1;
		
		for (int i = 1; i < N+1; i++) {
			ans = Math.max(ans, dist[i]+reverse_dist[i]);
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();

	} // end of main

	static void dijk(int start, int[] arr, List<Node>[] list) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		

		arr[start] = 0;
		pq.offer(new Node(start, 0));

		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visited[now.v]) {
				continue;
			}
			
			visited[now.v]=true;
			
			for (Node next: list[now.v]) {
				if(arr[next.v] > next.w + now.w) {
					arr[next.v] = next.w + now.w;
					pq.offer(new Node(next.v, arr[next.v]));
				}
			}
		}
		


	} // end of dijk

} // end of class
