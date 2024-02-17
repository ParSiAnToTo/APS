import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] money = new int[N+1];
		int[] dp = new int[K+1];
		
		Arrays.fill(dp, K+1);
		dp[0]=0;
		
		for (int i = 1; i < money.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < money.length; i++) {
			if(money[i]>K) {
				break;
			}
			for (int j = money[i]; j < dp.length; j++) {
				dp[j]=Math.min(dp[j], dp[j-money[i]]+1);
			}
		}
		
		System.out.println(dp[K]);
		
		
	}// end of main

}// end of class