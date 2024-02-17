import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	// 청소기의 전진방향 북 동 남 서
	// 회전은 반시계방향이므로 북 ->서 ->남 ->동이다
	
	static int N, M, d, ans;
	static int[][] clean;
	static boolean[][] cleanChk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int startR = Integer.parseInt(st.nextToken()); // 시작 행
		int startC = Integer.parseInt(st.nextToken()); // 시작 열
		d = Integer.parseInt(st.nextToken()); // 시작 방향

		clean = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				clean[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cleanChk = new boolean[N][M];

		ans = 0;
		active(startR, startC, d);

	}// end of main

	static void active(int r, int c, int dir) {
		if (!cleanChk[r][c]) {
			cleanChk[r][c] = true;
			ans++;
		} // 시작 칸은 반드시 비어있다. 청소 체크
		boolean deltaChk = true;
		for (int i = 0; i < 4; i++) { // delta 탐색
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (!cleanChk[nr][nc] && clean[nr][nc] == 0) { // 청소 안된 빈 칸이 존재
				deltaChk = false;
			}
		}

		if (deltaChk) { // 4칸 중 청소되지 않은 빈 칸이 존재하지 않는 경우
			if (clean[r - dr[dir]][c - dc[dir]] == 0) { // 바라보는 방향으로 후진 가능 시
				active(r - dr[dir], c - dc[dir], dir); // 후진하고 메서드 재실행
			} else {
				System.out.println(ans);
				System.exit(0);
			}
		}

		if (!deltaChk) { // 4칸 중 청소되지 않은 빈 칸 존재 시
			for (int i =0; i <4; i++) {
				dir = (dir + 3) % 4; // 반시계방향 90도 회전
				int spinr = r + dr[dir];
				int spinc = c + dc[dir];
				if (!cleanChk[spinr][spinc] && clean[spinr][spinc] == 0) { // 바라보는 방향으로 전진한 칸이 청소 안된 빈 칸일 경우
					active(spinr, spinc, dir);
				}

			}

		}

	}

}// end of class
