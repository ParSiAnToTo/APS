import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] lan = new int[K];
		long max = 0;
		for (int i = 0; i < lan.length; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			if (max < lan[i]) {
				max = lan[i];
			}
		}

		max++;
		System.out.println(upperBoundary(lan, 0, 0, max, N));

	}// end of main

	static long upperBoundary(int[] arr, long min, long mid, long max, int con) {
		while (min < max) {
			mid = (min + max) / 2;
			long count = 0;

			for (int i = 0; i < arr.length; i++) {
				count += (arr[i] / mid);

			}

			if (count < con) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}

		return min - 1;

	} // end of upperBoundary

}// end of class