import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] field;
	static int maxHeight, ans, N;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		field = new int[N][N];
		maxHeight = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, field[i][j]);
			}
		}

		ans = 0;
		int swarm = 0;

		for (int i = 0; i <= maxHeight; i++) {
			visited = new boolean[N][N];
			swarm=0;
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if (!visited[j][j2] && field[j][j2] > i) {
						dfs(j, j2,i);
						swarm++;
					}
				}
			}
			ans = Math.max(ans, swarm);

		}

		System.out.println(ans);

	}// end of main

	static void dfs(int r, int c, int flood) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (!visited[nr][nc] && field[nr][nc]>flood) {
					dfs(nr, nc, flood);
				}
			}
		}

	}

}// end of class