import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int str = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr.get(str).add(end);
			arr.get(end).add(str);
		}

		for (int i = 1; i < N + 1; i++) {
			Collections.sort(arr.get(i));
		}

		BFS(R);

	} // end of main

	static void BFS(int r) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;
		int[] result = new int[N + 1];

		q.offer(r);
		visited[r] = true;
		result[r] = ++cnt;

		while (!q.isEmpty()) {
			int point = q.poll();

			for (int i = 0; i < arr.get(point).size(); i++) {
				int next = arr.get(point).get(i);
				if (!visited[next]) {
					visited[next] = true;
					result[next] = ++cnt;
					q.offer(next);

				}
			}
		}

		for (int i = 1; i < result.length; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb.toString());

	}

} // end of class
