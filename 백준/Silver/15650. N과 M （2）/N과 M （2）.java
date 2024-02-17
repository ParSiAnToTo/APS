import java.util.Scanner;

public class Main {
	public static int[] nums;
	public static int[] result;
	public static boolean[] visited;
	public static int N;
	public static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		nums = new int[N];
		for (int i = 1; i <= N; i++) {
			nums[i - 1] = i;
		}
		result = new int[M];
		visited = new boolean[N];

		dfs(N, M, 0);

	}

	public static void dfs(int n, int m, int depth) {
		StringBuilder sb = new StringBuilder();
		if (depth == M) {
			for (int i = 0; i < depth; i++) {

				if (depth == 1) {
					System.out.println(result[i]);
				} else if (i < depth - 1 && result[i] < result[i + 1]) {
					sb.append(result[i]).append(" ");

				} else if (i == depth - 1 && result[i - 1] < result[i]) {
					sb.append(result[i]).append("\n");

				} else {
					return;
				}

			} // for

			if (depth != 1) {
				System.out.print(sb);
			}
			return;
		}

		for (int j = 0; j < n; j++) {

			if (!visited[j]) {

				visited[j] = true;
				result[depth] = nums[j];

				dfs(N, M, depth + 1);
				visited[j] = false;
			}

		}

	} // dfs

}
