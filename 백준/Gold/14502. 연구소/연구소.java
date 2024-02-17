import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, maxSafe, virusCount;
	static int[][] lab;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int[][] virus;

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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M]; // 연구소 정보 배열 생성
		virusCount = 0; // 바이러스 수 입력하는 파라미터
		maxSafe = 0; // 최대 안전구역 수 파라미터

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int point = Integer.parseInt(st.nextToken());
				if (point == 2) { // 바이러스 확인 시 증가
					virusCount++;
				}
				lab[i][j] = point;
			}
		}
		int indexr = 0;
		int indexc = 0;

		virus = new int[2][virusCount]; // 바이러스 좌표 저장 배열 생성
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 2) { // 바이러스 좌표 저장
					virus[0][indexr++] = i;
					virus[1][indexc++] = j;
				}

			}
		}

		buildWall(0);

		System.out.println(maxSafe);

	}// end of main

	static void buildWall(int count) {
		if (count == 3) { // 벽을 3개 세웠다면 bfs로 확인
			bfs();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 0) { // 벽 생성 백트래킹
					lab[i][j] = 1;
					buildWall(count + 1);
					lab[i][j] = 0;
				}

			}
		}
	} // end if backtracking

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < virusCount; i++) {
			q.offer(new Node(virus[0][i], virus[1][i]));
		} // 초기 바이러스 위치 삽입

		int[][] testCaseLab = new int[N][M]; // 임시 배열 생성
		for (int i = 0; i < N; i++) {
			System.arraycopy(lab[i], 0, testCaseLab[i], 0, M);
		} // 임시 배열 깊은 복사

		while (!q.isEmpty()) {
			Node pos = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + dr[i];
				int nc = pos.c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (testCaseLab[nr][nc] == 0) { // delta 탐색하여 좌표가 확산 가능하다면
						testCaseLab[nr][nc] = 2; // 해당 좌표 감염 처리
						q.offer(new Node(nr, nc));
					}
				}
			}
		}

		int safeCount = 0; // 안전구역의 수 저장 파라미터

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (testCaseLab[i][j] == 0) { //안전구역 확인 시 파라미터 증가
					safeCount++;
				}
			}
		}

		maxSafe = Math.max(maxSafe, safeCount);

	} // end of bfs
}// end of class