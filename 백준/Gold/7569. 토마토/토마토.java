import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, H, sec;
	static int[][][] tomatoBox;
	static int[] dr = { 0, 0, -1, 1, 0, 0 };
	static int[] dc = { -1, 1, 0, 0, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };

	static class point {
		int h;
		int r;
		int c;

		public point(int h, int r, int c) {
			// TODO Auto-generated constructor stub
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomatoBox = new int[H][N][M];
		boolean chk = false;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j2 = 0; j2 < M; j2++) {
					tomatoBox[i][j][j2] = Integer.parseInt(st.nextToken());
				}
			}
		}

		bfs();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if (tomatoBox[i][j][j2] == 0) {
						chk = true;
					}
				}
			}
		}
		if (chk) {
			System.out.println(-1);
		} else {
			System.out.println(sec - 1);
		}

	}// end of main

	static void bfs() {
		Queue<point> q = new LinkedList<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if (tomatoBox[i][j][j2] == 1) {
						q.offer(new point(i, j, j2));
					}
				}
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				point dot = q.poll();

				for (int j = 0; j < 6; j++) {
					int nh = dot.h + dh[j];
					int nr = dot.r + dr[j];
					int nc = dot.c + dc[j];
					if (nh >= 0 && nh < H && nr >= 0 && nr < N && nc >= 0 && nc < M) {
						if (tomatoBox[nh][nr][nc] == 0) {
							q.offer(new point(nh, nr, nc));
							tomatoBox[nh][nr][nc]=1;
						}
					}
				} // delta for

			} // queue for

			sec++;

		} // while

	}// bfs

}// end of class