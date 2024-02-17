import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] dp = new int[k + 1];
		int[] money = new int[n + 1];
		for (int i = 1; i < money.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			money[i] = Integer.parseInt(st.nextToken());
		}
		br.close();

		Arrays.fill(dp, 10001);
		dp[0]=0;

		for (int i = 1; i < n + 1; i++) {
			for (int j = money[i]; j < k + 1; j++) {
				dp[j] = Math.min(dp[j], dp[j - money[i]] + 1);

			}

		}
		
		if(dp[k]==10001) {
			System.out.println(-1);
		} else {
			System.out.println(dp[k]);
		}

	}// end of main

}// end of class