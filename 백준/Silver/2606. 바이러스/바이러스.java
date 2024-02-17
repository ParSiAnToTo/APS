import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] adj;
	static int cnt;

	static boolean[] visited;
	static Queue<Integer> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		adj = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		queue = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a][b] = 1;
			adj[b][a] = 1;

		}
		cnt = 0;
		BFS(1);
		System.out.println(cnt);
	}

    static void BFS(int v) {
		queue.offer(v);
		visited[v] = true;

		while (!queue.isEmpty()) {
			int t = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && adj[t][i] == 1) {
					queue.offer(i);
					visited[i] = true;
					cnt++;
				}
			}
		}

	}

}