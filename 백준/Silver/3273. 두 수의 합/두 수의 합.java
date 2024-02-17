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

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) { // array data input
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken()); // target

		Arrays.sort(arr); // array sorted

		int ans = 0;
		int start = 0;
		int end = n - 1;

		while (start < end) {
			int sum = arr[start] + arr[end];
			if (sum == x) {
				ans++;
				start++;
				end--;
			} else if (sum > x) {
				end--;
			} else {
				start++;
			}
		}

		System.out.println(ans);

	} // end of main

} // end of class