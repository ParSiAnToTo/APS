import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] tempArr, diary;
	static StringBuilder sb;
	static boolean chk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		for (int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			diary = new int[N];
			tempArr = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < diary.length; i++) {
				diary[i] = Integer.parseInt(st.nextToken());
			}

			mergeSort(diary, 0, N - 1);

			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				chk = false;
				binarySearch(Integer.parseInt(st.nextToken()), 0, N - 1);
				if (!chk) {
					sb.append(0).append("\n");
				}
			}
			
			sb.delete(sb.length()-1, sb.length());
			System.out.println(sb.toString());

		} // end of testCase

	}// end of main

	static void mergeSort(int[] arr, int l, int r) {
		if (l == r) {
			return;
		}

		int mid = (l + r) / 2;
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}// end of mergeSort

	static void merge(int[] arr, int l, int mid, int r) {
		int leftPoint = l;
		int rightPoint = mid + 1;
		int idx = l;

		while (leftPoint <= mid && rightPoint <= r) {

			if (arr[leftPoint] <= arr[rightPoint]) {
				tempArr[idx] = arr[leftPoint];
				idx++;
				leftPoint++;
			} else {
				tempArr[idx] = arr[rightPoint];
				idx++;
				rightPoint++;
			}
		}

		if (leftPoint > mid) {
			while (rightPoint <= r) {
				tempArr[idx] = arr[rightPoint];
				idx++;
				rightPoint++;
			}
		} else {
			while (leftPoint <= mid) {
				tempArr[idx] = arr[leftPoint];
				idx++;
				leftPoint++;
			}
		}

		for (int i = l; i <= r; i++) {
			arr[i] = tempArr[i];
		}

	}// end of merge

	static void binarySearch(int key, int st, int ed) {
		if (st > ed) {
			return;
		}

		int mid = (st + ed) / 2;
		if (diary[mid] == key) {
			sb.append(1).append("\n");
			chk = true;
		} else if (diary[mid] > key) {
			binarySearch(key, st, mid - 1);
		} else {
			binarySearch(key, mid + 1, ed);
		}

	}// end of binarySearch

}// end of class