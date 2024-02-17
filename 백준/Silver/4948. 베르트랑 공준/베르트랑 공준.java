import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[] prime = new boolean[123456 * 2 + 1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		Prime();

		int next = Integer.parseInt(st.nextToken());
		while (next != 0) {
			int cnt = 0;
			for (int i = next + 1; i <= 2 * next; i++) {
				if (!prime[i]) {
					cnt++;
				}
			}

			sb.append(cnt).append("\n");

			st = new StringTokenizer(br.readLine(), " ");
			next = Integer.parseInt(st.nextToken());
		}

		System.out.println(sb.toString());

	} // end of main

	static void Prime() {
		prime[0] = true;
		prime[1] = true;

		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i]) {
				continue;
			} else {
				for (int j = i * i; j < prime.length; j += i) {
					prime[j] = true;
				}
			}
		}

	}

} // end of class
