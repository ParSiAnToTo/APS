import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int[] sequence = new int[N];
		int[] dp = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < dp.length; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (sequence[j] < sequence[i]) {
					if (dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
			}
		}

		int max = -1;
		for (int i = 0; i < dp.length; i++) {
			if (max < dp[i]) {
				max = dp[i];
			}
		}

		System.out.println(max);

	} // end of main

} // end of class
