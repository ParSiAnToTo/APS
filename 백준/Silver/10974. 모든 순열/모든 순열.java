import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static StringBuilder sb = new StringBuilder();
	static int[] result;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		result = new int[N];
		visited = new boolean[N + 1];
		visited[0] = true;

		back(0);
		sb.delete(sb.length() - 1, sb.length());
		System.out.println(sb.toString());

	} // end of main

	static void back(int idx) {
		if (idx == N) {
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i <= N; i++) {

			if (visited[i]) {
				continue;
			}

			result[idx] = i;
			visited[i] = true;
			back(idx + 1);
			visited[i] = false;

		}

	} // end of backTracking

} // end of class
