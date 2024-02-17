import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int[][] pipeLine;

	static void dfs(int r, int c, int dir) {
		if (r == N && c == N) {
			ans++;
			return;
		}
		switch (dir) {
		case 0:
			if (c + 1 <= N && pipeLine[r][c + 1] == 0) {
				dfs(r, c + 1, 0);
			}

			break;
		case 1:
			if (r + 1 <= N && pipeLine[r + 1][c] == 0) {
				dfs(r + 1, c, 1);
			}

			break;
		case 2:
			if (c + 1 <= N && pipeLine[r][c + 1] == 0) {
				dfs(r, c + 1, 0);
			}
			if (r + 1 <= N && pipeLine[r + 1][c] == 0) {
				dfs(r + 1, c, 1);
			}

			break;

		default:
			break;
		}

		if (r + 1 <= N && c + 1 <= N && pipeLine[r + 1][c] == 0 && pipeLine[r][c + 1] == 0
				&& pipeLine[r + 1][c + 1] == 0) {
			dfs(r + 1, c + 1, 2);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());

		pipeLine = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N + 1; j++) {
				pipeLine[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		dfs(1, 2, 0);
		System.out.println(ans);

	}// end of main

}// end of class