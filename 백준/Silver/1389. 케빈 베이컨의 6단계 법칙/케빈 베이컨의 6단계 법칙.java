import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] adjArr = new int[N + 1][N + 1];
		int maxRank = 101;

		for (int i = 0; i <= N; i++) { // 배열 초기화
			for (int j = 0; j <= N; j++) {
				if (i == j) {
					adjArr[i][j] = 0;
				} else {
					adjArr[i][j] = maxRank;
				}

			}
		}

		for (int i = 0; i < M; i++) { // 친구 정보 삽입
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjArr[a][b] = 1;
			adjArr[b][a] = 1;
		}

		for (int i = 1; i <= N; i++) { // 중간 노드
			for (int j = 1; j <= N; j++) { // 시작 노드
				for (int j2 = 1; j2 <= N; j2++) { // 도착 노드
					adjArr[j][j2] = Math.min(adjArr[j][j2], adjArr[j][i] + adjArr[i][j2]);
				}
			}
		}

		int kevinMin = Integer.MAX_VALUE;
		int people = 0;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) { // 케빈 베이컨 수 
				sum += adjArr[i][j];
			}
			if (kevinMin > sum) { // 케빈 베이컨 수가 작은 사람 갱신
				kevinMin = sum;
				people = i;
			}
		}

		System.out.println(people);

	} // end of main

} // end of class