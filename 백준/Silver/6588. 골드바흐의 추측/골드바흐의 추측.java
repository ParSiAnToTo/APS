import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static boolean[] isPrime = new boolean[1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		prime();

		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}

			int a = 0;
			int b = n;

			while (true) {

				if (!isPrime[a] && !isPrime[b]) {
					sb.append(n).append(" ").append("=").append(" ").append(a).append(" ").append("+").append(" ")
							.append(b).append("\n");
					break;
				}

				if (a == b) {
					sb.append("Goldbach's conjecture is wrong.").append("\n");
					break;
				} 
				a++;
				b--;
			}

		} // end of testCase

		sb.delete(sb.length() - 1, sb.length());
		System.out.println(sb.toString());

	} // end of main

	static void prime() {
		isPrime[0] = true;
		isPrime[1] = true;
		int max = (int) Math.sqrt(1000000);
		for (int i = 2; i <= max; i++) {
			if (isPrime[i] == true) {
				continue;
			}

			for (int j = i * i; j < isPrime.length; j = j + i) {
				isPrime[j] = true;
			}
		}

	}

} // end of class
