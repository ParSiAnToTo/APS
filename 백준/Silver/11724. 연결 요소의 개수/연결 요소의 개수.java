import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (!list[i].isEmpty() && !visited[i]) {
				bfs(i);
				count++;
			} else if (list[i].isEmpty()) {
				count++;
			}
		}

		System.out.println(count);

	}// end of main

	static void bfs(int st) {
		visited[st] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(st);

		while (!q.isEmpty()) {
			int num = q.poll();
			int lsize = list[num].size();
			for (int i = 0; i < lsize; i++) {
				int ed = list[num].get(i);
				if (!visited[ed]) {
					visited[ed] = true;
					q.offer(ed);
				}

			}
		}
	}

}// end of class