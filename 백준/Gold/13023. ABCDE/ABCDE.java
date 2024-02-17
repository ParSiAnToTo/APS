import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static boolean esc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		esc = false;
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i, 1);

			if (esc) {
				break;
			}

		}

		if (esc) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}// end of main

	static void dfs(int start, int len) {
		if (len == 5) {
			esc = true;
			return;
		}

		for (int v : list.get(start)) {
			if (!visited[v]) {
				visited[v] = true;
				dfs(v, len + 1);
				visited[v] = false;
			}
		}

	}

}// end of class