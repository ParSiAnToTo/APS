import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static StringBuilder sb;
	static int[] arr;
	static int[] result;

	public static void combination(int n, int depth) {
		if (depth == M) {

			for (int a : result) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int chk = -1;
		for (int i = n; i < N; i++) {

			if (arr[i] != chk) {
				result[depth] = arr[i];
				chk = arr[i];
				combination(i, depth + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		result = new int[M];
		combination(0, 0);
		System.out.println(sb);

	} // end of main

}// end of class