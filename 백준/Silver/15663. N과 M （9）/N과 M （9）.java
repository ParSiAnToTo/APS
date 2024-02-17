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
	static boolean[] visited;

	public static void combination(int n, int depth) {
		if (depth == M) {

			for (int a : result) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int chk = -1;
		for (int i = 0; i < N; i++) {

			if (!visited[i] && arr[i] != chk) {
				visited[i] = true;
				result[depth] = arr[i];
				chk = arr[i];
				combination(n, depth + 1);
				visited[i] = false;
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
		visited = new boolean[N];
		combination(0, 0);
		System.out.println(sb);

	} // end of main

}// end of class