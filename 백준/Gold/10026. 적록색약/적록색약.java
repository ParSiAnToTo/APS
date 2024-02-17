import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static char[][] art;
	static boolean[][] visited;
	static int count;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		art = new char[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				art[i][j] = line.charAt(j);
			}
		}
		count = 0;
		visited = new boolean[N][N];
		// normal-bfs-R
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && art[i][j] == 'R') {
					bfsR(i, j);
				}
			}
		}

		// normal-bfs-G
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && art[i][j] == 'G') {
					bfsG(i, j);
				}
			}
		}
		// normal-bfs-B
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && art[i][j] == 'B') {
					bfsB(i, j);
				}
			}
		}

		sb.append(count).append(" "); //first answer append
		
		count = 0; //count parameter init
		visited = new boolean[N][N]; // visited init
		
		// Color Blindness-bfs-RG
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && (art[i][j] == 'R' || art[i][j] == 'G')) {
					bfsRG(i, j);
				}
			}
		}
		
		// Color Blindness-bfs-B
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && art[i][j] == 'B') {
					bfsB(i, j);
				}
			}
		}
		
		sb.append(count);
		System.out.println(sb.toString());

	}// end of main

	static void bfsR(int r, int c) {
		Queue<Node> rq = new LinkedList<>();
		rq.offer(new Node(r, c));
		visited[r][c] = true;

		while (!rq.isEmpty()) {
			Node pos = rq.poll();

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + dr[i];
				int nc = pos.c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (!visited[nr][nc] && art[nr][nc] == 'R') {
						visited[nr][nc] = true;
						rq.offer(new Node(nr, nc));
					}
				} // Queue offer Check

			} // 4-way search
		} // bfsR end

		count++;
	}// end of bfsR

	static void bfsG(int r, int c) {
		Queue<Node> gq = new LinkedList<>();
		gq.offer(new Node(r, c));
		visited[r][c] = true;

		while (!gq.isEmpty()) {
			Node pos = gq.poll();

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + dr[i];
				int nc = pos.c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (!visited[nr][nc] && art[nr][nc] == 'G') {
						visited[nr][nc] = true;
						gq.offer(new Node(nr, nc));
					}
				} // Queue offer Check

			} // 4-way search
		} // bfsG end

		count++;
	}// end of bfsG

	static void bfsB(int r, int c) {
		Queue<Node> bq = new LinkedList<>();
		bq.offer(new Node(r, c));
		visited[r][c] = true;

		while (!bq.isEmpty()) {
			Node pos = bq.poll();

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + dr[i];
				int nc = pos.c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (!visited[nr][nc] && art[nr][nc] == 'B') {
						visited[nr][nc] = true;
						bq.offer(new Node(nr, nc));
					}
				} // Queue offer Check

			} // 4-way search
		} // bfsB end

		count++;
	}// end of bfsB

	static void bfsRG(int r, int c) {
		Queue<Node> rgq = new LinkedList<>();
		rgq.offer(new Node(r, c));
		visited[r][c] = true;

		while (!rgq.isEmpty()) {
			Node pos = rgq.poll();

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + dr[i];
				int nc = pos.c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (!visited[nr][nc] && (art[nr][nc] == 'R' || art[nr][nc] == 'G')) {
						visited[nr][nc] = true;
						rgq.offer(new Node(nr, nc));
					}
				} // Queue offer Check

			} // 4-way search
		} // bfsRG end

		count++;
	}// end of bfsRG

}// end of class