import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, arrSum, maxLen;
	static boolean[][] visited;
	static int[][] paper;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		} // input complete

		maxLen = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, paper[i][j]);
				visited[i][j] = false;
				tetro(i, j);
			}
		}

		System.out.println(maxLen);

	} // end of main

	static void dfs(int r, int c, int length, int sum) {
		if (length == 4) {
			maxLen = Math.max(maxLen, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
				if (!visited[nr][nc]) {
					visited[nr][nc] = true;
					dfs(nr, nc, length + 1, sum + paper[nr][nc]);
					visited[nr][nc] = false;
				}
			}
		}

	} // end of dfs

	static void tetro(int r, int c) {
		if ((r == 0 && c == 0) || (r == n - 1 && c == 0) || (r == n - 1 && c == m - 1) || (r == 0 && c == m - 1)) {
			return;
		} else if (r > 0 && r < n - 1 && c > 0 && c < m - 1) {
			int sum1 = paper[r][c] + paper[r][c + 1] + paper[r][c - 1] + paper[r + 1][c];
			int sum2 = paper[r][c] + paper[r][c + 1] + paper[r][c - 1] + paper[r - 1][c];
			int sum3 = paper[r][c] + paper[r][c + 1] + paper[r + 1][c] + paper[r - 1][c];
			int sum4 = paper[r][c] + paper[r][c - 1] + paper[r + 1][c] + paper[r - 1][c];
			arrSum = Math.max(Math.max(sum1, sum2), Math.max(sum3, sum4));
		} else if (r == 0) {
			arrSum = paper[r][c] + paper[r][c + 1] + paper[r][c - 1] + paper[r + 1][c];
		} else if (r == n - 1) {
			arrSum = paper[r][c] + paper[r][c + 1] + paper[r][c - 1] + paper[r - 1][c];
		} else if (c == 0) {
			arrSum = paper[r][c] + paper[r][c + 1] + paper[r + 1][c] + paper[r - 1][c];
		} else if (c == m - 1) {
			arrSum = paper[r][c] + paper[r][c - 1] + paper[r + 1][c] + paper[r - 1][c];
		}

		maxLen = Math.max(maxLen, arrSum);

	} // end if tetro

}// end of class