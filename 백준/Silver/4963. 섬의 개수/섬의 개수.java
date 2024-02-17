import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] island;
	static boolean[][] visited;
	static int count;
	static int[] dr = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int[] dc = { 1, -1, 0, 0, 1, -1, 1, -1 };

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) {
				break;
			}

			island = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					island[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			count = 0;
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {

					if (!visited[i][j] && island[i][j] == 1) {
						q.offer(new Node(i, j));
						visited[i][j]=true;
						while (!q.isEmpty()) {
							Node pos = q.poll();

							for (int k = 0; k < 8; k++) {
								int nr = pos.r + dr[k];
								int nc = pos.c + dc[k];
								
								if (nr >= 0 && nr < h && nc >= 0 && nc < w) {
									if (!visited[nr][nc] && island[nr][nc] == 1) {
										visited[nr][nc]=true;
										q.offer(new Node(nr, nc));
									}
								}
								
							}
						}
						count++;
					}

				}
			}

			sb.append(count).append("\n");

		}

		System.out.println(sb.toString());
	}

}
