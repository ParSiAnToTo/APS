import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class point {
		int r;
		int c;

		public point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static int M, N, sec;
	static int[][] tomatoBox;
	static Queue<point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		tomatoBox = new int[N][M];
		q = new LinkedList<point>();

		boolean isZero = false; //저장 시점부터 모든 토마토가 익었는지
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 0) {
					isZero = true; //안익은 토마토 하나라도 발견
				} else if (input == 1) {
					q.offer(new point(i, j));
				}
				tomatoBox[i][j] = input;

			}
		}
		if (!isZero) { //저장 시점부터 모든 토마토가 익었다면
			System.out.println(0);
		} else {
			sec=0;
			bfs();
			boolean isFail = false; //모든 토마토 익었는지
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(tomatoBox[i][j]==0) {
						isFail=true;
					}
				}
			}
			
			if(isFail) {
				System.out.println(-1);
			} else {
				System.out.println(sec-1);
			}
			
		}
		


	}// end of main

	static void bfs() {

		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				point dot = q.poll();
				for (int j = 0; j < 4; j++) {  //poll delta
					int nr = dot.r + dr[j];
					int nc = dot.c + dc[j];
					// delta 범위 내
					if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
						if (tomatoBox[nr][nc] == 0) { // 안익은 토마토라면
							q.offer(new point(nr, nc));
							tomatoBox[nr][nc] = 1; // 토마토 익음 체크
						}
					}
				}
			} // sec 시점 토마토 숙성 체크 완료
			
			sec++;
			
		}
	}

}// end of class