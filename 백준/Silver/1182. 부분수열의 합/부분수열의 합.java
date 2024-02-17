import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static boolean[] visited;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 주어지는 정수의 개수
		int S = Integer.parseInt(st.nextToken()); // 목표 값

		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		count = 0;
		for (int i = 1; i <= arr.length; i++) {
			visited = new boolean[N];
			back(arr, 0, 0, S, 0, i);
		}
		System.out.println(count);

	}// end of main

	static void back(int[] A, int idx, int sum, int target, int runcount, int length) {
		if ( runcount == length) {
			if (sum == target) {
				count++;
			}
			return;
		}

		for (int i = idx; i < A.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				back(A, i, sum + A[i], target, runcount+1, length);
				visited[i] = false;
			}
		}

	}

}// end of class