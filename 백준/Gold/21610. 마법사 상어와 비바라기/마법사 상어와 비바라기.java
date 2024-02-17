import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M, di, si;
	static int[][] bucket;
	static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] xr = { -1, -1, 1, 1 };
	static int[] xc = { -1, 1, 1, -1 };
	static boolean[][] rainPoint;
	static StringTokenizer st;
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bucket = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				bucket[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rainDance();
		
		int waterSum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				waterSum+=bucket[i][j];
			}
		}
		
		System.out.println(waterSum);

	}// end of main

	static void rainDance() throws IOException {
		Queue<Node> q = new LinkedList<>();
		// 최초 구름 위치 삽입
		q.offer(new Node(N - 1, 0));
		q.offer(new Node(N - 2, 0));
		q.offer(new Node(N - 1, 1));
		q.offer(new Node(N - 2, 1));

		for (int i = 0; i < M; i++) { // 구름의 이동 정보 
			st = new StringTokenizer(br.readLine(), " ");
			di = Integer.parseInt(st.nextToken());
			si = Integer.parseInt(st.nextToken());

			rainPoint = new boolean[N][N];
			int cloudCount = q.size();
			for (int j = 0; j < cloudCount; j++) {
				Node cloud = q.poll();
				int nr = (N + cloud.r + dr[di] * (si%N)) % N;
				int nc = (N + cloud.c + dc[di] * (si%N)) % N;
				bucket[nr][nc]++; // 비 내려 물 저장량 1 증가
				rainPoint[nr][nc] = true; // 구름 증발
			}
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(rainPoint[j][j2]) { //구름이 있던 위치에 
					copyBug(j, j2); // 물복사 버그
					}
				}
			}

			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if (bucket[j][j2] >= 2 && !rainPoint[j][j2]) {
						// 물 저장량이 2 이상이며 구름이 있던 위치가 아니라면
						q.offer(new Node(j, j2)); // 구름 생성
						bucket[j][j2] -= 2; // 물 저장량 2 감소
					}
				}
			}
		}

	}// end of rainDance

	static void copyBug(int r, int c) {
		int waterCount = 0;
		for (int i = 0; i < 4; i++) { //대각선 delta 탐색
			int nxr = r + xr[i];
			int nxc = c + xc[i];
			if (nxr >= 0 && nxr < N && nxc >= 0 && nxc < N) { //탐색이 범위 내
				if (bucket[nxr][nxc] > 0) { //해당 위치 물 저장량이 1 이상이라면
					waterCount++;
				}
			}
		}

		bucket[r][c] += waterCount; //빈 저장소가 아닌 만큼 물 저장량 증가

	} // end of copyBug

}// end of class