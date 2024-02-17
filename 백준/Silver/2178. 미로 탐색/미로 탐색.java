import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;

	static class point {
		int r;
		int c;
		int length;

		public point(int r, int c, int length) {
			this.r = r;
			this.c = c;
			this.length = length;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] maze = new int[N][M];
		for (int i = 0; i < N; i++) {
			String iLine = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = iLine.charAt(j) - '0';
			}
		} // maze input

		ans = Integer.MAX_VALUE;
		bfs(0, 0, maze);
		System.out.println(ans);

	}// end of main

	static void bfs(int r, int c, int[][] arr) {
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };

		Queue<point> q = new LinkedList<>();
		arr[0][0] = 0;
		q.offer(new point(0, 0, 1));

		while (!q.isEmpty()) {
			point np = q.poll();

			if (np.r == N - 1 && np.c == M - 1) {
				ans = Math.min(ans, np.length);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = np.r + dr[i];
				int nc = np.c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (arr[nr][nc] == 1) {
						arr[nr][nc] = 0;
						q.offer(new point(nr, nc, np.length + 1));
					}
				}

			}

		}
		
		return;

	}

}// end of class