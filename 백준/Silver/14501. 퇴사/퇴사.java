import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] calender = new int[2][N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			calender[0][i] = Integer.parseInt(st.nextToken());
			calender[1][i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N + 2];
		for (int i = N; i >= 0; i--) {
			if (calender[0][i] > N - i + 1) {
				dp[i] = dp[i + 1];
			} else {
				dp[i] = Math.max(calender[1][i] + dp[i + calender[0][i]], dp[i + 1]);
			}
		}
		bw.write(String.valueOf(dp[1]));
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class