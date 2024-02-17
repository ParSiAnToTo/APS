import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R, cnt;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		result = new int[N + 1];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}

		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adjList[A].add(B);
			adjList[B].add(A);
		}

		for (int i = 0; i < adjList.length; i++) {
			Collections.sort(adjList[i]);
		}


		DFS(R, visited, adjList);

		for (int i = 1; i < result.length; i++) {
			sb.append(result[i]).append("\n");
		}
		
		System.out.println(sb.toString());

	}// end of main

	public static void DFS(int r, boolean[] visit, List<Integer>[] List) {
		visit[r] = true;
		result[r] = ++cnt;
		for (int a : List[r]) {
			if (!visit[a]) {
				DFS(a, visit, List);

			}
		}
	}
}// end of class