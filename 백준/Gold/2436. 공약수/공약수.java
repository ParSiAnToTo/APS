import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long xy = b / a;
		long i = 1;
		long threshold = (long) Math.floor(Math.sqrt(xy));
		long minSum = Long.MAX_VALUE;
		long[] store = new long[2];
		while (i <= threshold) {
			if (xy % i == 0) {
				long x = i;
				long y = xy / i;
				if (gcd(x * a, y * a) == a) {
					if (minSum > (x + y) * a) {
						minSum = (x + y) * a;
						store[0] = x * a;
						store[1] = y * a;
					}
				}
			}
			i++;
		}

		System.out.println(store[0] + " " + store[1]);

	}// end of main

	static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);

	}// end of gcd

}// end of class