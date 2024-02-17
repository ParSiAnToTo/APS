import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int n;
	static Queue<Integer> Goldbach;
	static boolean[] isPrime = new boolean[10001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		prime();

		for (int testCase = 0; testCase < T; testCase++) {
			n = Integer.parseInt(br.readLine());
			Goldbach = new LinkedList<>();
			for (int i = 0; i <= n; i++) {
				if (!isPrime[i]) {
					Goldbach.offer(i);
				}
			}

			int a = n / 2;
			int b = n / 2;

			while (true) {
				if (!isPrime[a] && !isPrime[b]) {
					sb.append(a).append(" ").append(b).append("\n");
					break;
				}

				a--;
				b++;
			}

		} // end of testCase

		sb.delete(sb.length() - 1, sb.length());
		System.out.println(sb.toString());

	} // end of main

	static void prime() {
		isPrime[0] = true;
		isPrime[1] = true;

		for (int i = 2; i <= Math.sqrt(10000); i++) {
			if (isPrime[i] == true) {
				continue;
			}

			for (int j = i * i; j < isPrime.length; j = j + i) {
				isPrime[j] = true;
			}
		}

	}

} // end of class
