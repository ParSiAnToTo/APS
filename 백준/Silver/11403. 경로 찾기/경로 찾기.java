import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][N];

		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 경로 체크
		for (int i = 0; i < arr.length; i++) { // 중간 노드
			for (int j = 0; j < arr.length; j++) { // 시작 노드
				for (int k = 0; k < arr.length; k++) { // 도착 노드
					if (arr[j][i] == 1 && arr[i][k] == 1) { // 경유 가능 여부 확인
						arr[j][k] = 1;
					}

				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	} // end of main

} // end of class
