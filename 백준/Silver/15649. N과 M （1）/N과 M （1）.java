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

		if (depth == M) {

			for (int i = 0; i < depth; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
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
