import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[][] tempArr;
	static int rowSumMin, now, next, N, M, K;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int[] result;
	static int[][] spinArr;
	static boolean[] visited;
	// 좌 하 우 상

	public static void arrSpin(int r, int c, int s) {
		int ucorr = r - s - 1; // 0
		int ucorc = c - s - 1; // 1
		int lcorr = r + s - 1; // 4
		int lcorc = c + s - 1; // 5
		int sr = ucorr;
		int sc = ucorc;

		while (ucorr != lcorr) {
			int i = 0;

			now = tempArr[sr][sc]; // 외부에서 시작값 저장
			while (true) {
				int nc = sc + dc[i];
				int nr = sr + dr[i];

				if (nr == ucorr && nc == ucorc) {
					tempArr[nr][nc] = next;
					ucorr++;
					ucorc++;
					lcorr--;
					lcorc--;
					sr = ucorr;
					sc = ucorc;
					break;

				} else if (nr >= ucorr && nr <= lcorr && nc >= ucorc && nc <= lcorc) {
					next = tempArr[nr][nc]; // 다음 값 저장
					tempArr[nr][nc] = now; // 저장해 온 값 입력
					sr = nr;
					sc = nc;
				} else {
					i++;
				}
				now = next; // 입력하는 변수 값 갱신
			}

		}

	}

	public static void rowCalc() {
		for (int i = 0; i < N; i++) {
			int rowSum = 0;
			for (int j = 0; j < M; j++) {
				rowSum += tempArr[i][j];
			}

			if (rowSum < rowSumMin) {
				rowSumMin = rowSum;
			}
		}
	}

	public static void perm(int depth) {
		if (depth == K) {
			tempArr = new int[N][M];
			for (int i = 0; i < N; i++) {
				System.arraycopy(arr[i], 0, tempArr[i], 0, M);
			}
			
			for (int a : result) {
				arrSpin(spinArr[a][0], spinArr[a][1], spinArr[a][2]);
			}
			rowCalc();
			return;
		}

		for (int i = 0; i < spinArr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[depth] = i;
				perm(depth + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		spinArr = new int[K][3];
		for (int i = 0; i < spinArr.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			spinArr[i][0] = Integer.parseInt(st.nextToken());
			spinArr[i][1] = Integer.parseInt(st.nextToken());
			spinArr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		
		
		result = new int[K];
		visited = new boolean[K];
		rowSumMin = Integer.MAX_VALUE;
		perm(0);
		System.out.println(rowSumMin);

	}// end of main

}// end of class