import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V;
	static List<Integer>[] adjList;
	static boolean[] visitedD, visitedB;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N + 1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adjList[start].add(end);
			adjList[end].add(start);
		}

		for (int i = 1; i < adjList.length; i++) {
			Collections.sort(adjList[i]);
		}

		visitedD = new boolean[N + 1];
		visitedB = new boolean[N + 1];
		DFS(V);
		sb.append("\n");
		BFS(V);
		System.out.println(sb.toString());

	}// end of main

	static void DFS(int v) {
		visitedD[v] = true;
		sb.append(v).append(" ");
		for (int a : adjList[v]) {
			if (!visitedD[a]) {
				DFS(a);
			}
		}
	}

	static void BFS(int v) {
		sb.append(v).append(" ");
		visitedB[v]=true;
		queue.offer(v);

		while (!queue.isEmpty()) {
			int temp = queue.poll();
			for (int b : adjList[temp]) {
				if (!visitedB[b]) {
					sb.append(b).append(" ");
					visitedB[b] = true;
					queue.offer(b);
				}
			}
		}
	}

}// end of class