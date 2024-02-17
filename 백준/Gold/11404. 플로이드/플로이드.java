import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int INF = 99999999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] adjArr = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) { //인접행렬 초기화
			for (int j = 0; j <= n; j++) {
				if (i == j) {
					adjArr[i][j] = 0;
				} else {
					adjArr[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < m; i++) { //노드 정보 삽입
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjArr[a][b] = Math.min(adjArr[a][b], c); //중복 시 최소 값 입력
		}

		for (int i = 1; i <= n; i++) { // 중간 노드
			for (int j = 1; j <= n; j++) { // 시작 노드
				for (int j2 = 1; j2 <= n; j2++) { // 도착 노드
					adjArr[j][j2] = Math.min(adjArr[j][j2], adjArr[j][i] + adjArr[i][j2]);
				}
			}
		}
		
		for (int i = 1; i < adjArr.length; i++) {
			for (int j = 1; j < adjArr.length; j++) {
				if(adjArr[i][j]==INF) {
					adjArr[i][j]=0;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(adjArr[i][j]).append(" ");
			}
			sb.append("\n");
		}

		sb.delete(sb.length() - 1, sb.length());
		System.out.println(sb.toString());

	} // end of main

} // end of class
