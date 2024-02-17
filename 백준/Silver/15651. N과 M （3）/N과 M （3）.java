import java.util.Scanner;

public class Main {
	public static int[] nums;
	public static int[] result;
	public static int N;
	public static int M;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		nums = new int[N];
		for (int i = 1; i <= N; i++) {
			nums[i - 1] = i;
		}
		result = new int[M];

		dfs(N, M, 0);
		System.out.println(sb);

	}

	public static void dfs(int n, int m, int depth) {
		if (depth == M) {
			for (int i = 0; i < depth; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int j = 0; j < n; j++) {
			result[depth] = nums[j];
			dfs(N, M, depth + 1);
		}

	} // dfs

}