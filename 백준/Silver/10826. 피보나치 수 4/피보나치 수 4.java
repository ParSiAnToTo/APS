import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	static BigInteger[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		dp = new BigInteger[10001];
		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.ONE;

		System.out.println(fibo(n));

	}// end of main

	static BigInteger fibo(int n) {
		if (n < 2) {
			return dp[n];
		}

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 2].add(dp[i - 1]);
		}

		return dp[n];
	}

}// end of class