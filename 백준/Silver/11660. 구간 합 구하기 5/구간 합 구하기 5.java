import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] sheet = new int[N][N];
		int[][] memo = new int[N + 1][N + 1]; // prefix sum save array

		for (int i = 0; i < sheet.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < sheet.length; j++) {
				sheet[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < memo.length; i++) {
			for (int j = 1; j < memo.length; j++) {
				memo[i][j] = memo[i][j - 1] + sheet[i - 1][j - 1];
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int sum = 0;
			// max value = 1000*2^20 = 1,048,576,000 => integer

			for (int j = x1; j <= x2; j++) {
				sum += memo[j][y2] - memo[j][y1 - 1];
			}

			sb.append(sum).append("\n");

		}

		sb.delete(sb.length() - 1, sb.length());
		System.out.println(sb.toString());

	} // end of main

} // end of class
