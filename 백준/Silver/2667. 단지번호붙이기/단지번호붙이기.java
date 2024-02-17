import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, apartNum;
	static int[][] map;
	static int[] houseCnt;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		houseCnt = new int[N * N + 1];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		apartNum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					apartNum++;
					dfs(i, j);
				}
			}
		}

		System.out.println(apartNum);
		Arrays.sort(houseCnt);
		for (int i = 0; i < houseCnt.length; i++) {
			if (houseCnt[i] != 0) {
				System.out.println(houseCnt[i]);
			}
		}

	}

	static void dfs(int r, int c) {
		visited[r][c] = true;
		houseCnt[apartNum]++;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (!visited[nr][nc] && map[nr][nc] == 1) {
					dfs(nr, nc);
				}
			}
		}

	}

}