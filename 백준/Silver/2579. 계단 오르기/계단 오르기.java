import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] dp;
	static int[] stair;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		stair = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		Arrays.fill(dp, -1);
		dp[0] = stair[0];
		dp[1] = stair[1];
		if (N >= 2) {
			dp[2] = stair[1] + stair[2];
		}

		int ans = maxStair(N);
		System.out.println(ans);

	} // end of main

	static int maxStair(int N) {

		if (dp[N] == -1) {
			dp[N] = Math.max(maxStair(N - 2), maxStair(N - 3) + stair[N - 1]) + stair[N];
		}
		return dp[N];
	}

} // end of class