import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, ans;
	static int[][] board;
	static boolean[] visited;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		visited = new boolean[26];
		board = new int[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = line.charAt(j) - 'A';
			}
		}

		ans = 0;
		dfs(0, 0, 1);
		System.out.println(ans);
	}// end of main

	static void dfs(int r, int c, int count) {

		visited[board[r][c]] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if (!visited[board[nr][nc]]) {
					dfs(nr, nc, count + 1);
					visited[board[nr][nc]] = false;
				}
			}
		}
		ans = Math.max(ans, count);
		return;
	}

}// end of class
