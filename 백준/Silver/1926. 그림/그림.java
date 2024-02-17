import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, count, area, areaMax;
	static boolean[][] visited;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] canvas = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 0) {
					visited[i][j] = true;
					canvas[i][j] = input;
				} else {
					canvas[i][j] = input;
				}

			} // input complete

		}

		count = 0;
		areaMax = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					count++;
					bfs(i, j);
				}
			}
		}
		
		System.out.println(count);
		System.out.println(areaMax);

	} // end of main

	static void bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(r, c));
		visited[r][c]=true;
		area = 0;
		while (!q.isEmpty()) {
			Pos point = q.poll();
			area++;

			for (int i = 0; i < 4; i++) {
				int nr = point.r + dr[i];
				int nc = point.c + dc[i];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
					if (!visited[nr][nc]) {
						visited[nr][nc]=true;
						q.offer(new Pos(nr, nc));
						
					}
				}
			}
		}
		
		areaMax = Math.max(area, areaMax);
	}

}// end of class