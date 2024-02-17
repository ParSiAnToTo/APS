import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] tree = new int[N];
		long max = 0; //나무 최대 높이 저장 파라미터
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < tree.length; i++) {
			int len = Integer.parseInt(st.nextToken());
			tree[i] = len;
			if (max < len) { //입력받은 나무 높이 비교
				max = len;
			}
		}

		max++;
		System.out.println(upperBoundary(tree, 0, 0, max, M));

	}// end of main

	static long upperBoundary(int[] arr, long min, long mid, long max, int con) {
		while (min < max) {
			mid = (min + max) / 2;
			long sum = 0;

			for (int i = 0; i < arr.length; i++) {
				if(arr[i] - mid > 0) { //기준값보다 길다면 합
				sum += (arr[i] - mid);
				}

			}

			if (sum < con) { //합이 M보다 작다면 절단기 높이 감소
				max = mid;
			} else {
				min = mid + 1; //같거나 더 많다면 절단기 높이 증가
			}
		}

		return min - 1;

	} // end of upperBoundary

}// end of class