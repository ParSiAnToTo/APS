import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tempAge;
	static String[] tempName;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arrAge = new int[N];
		tempAge = new int[N];
		String[] arrName = new String[N];
		tempName = new String[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arrAge[i] = Integer.parseInt(st.nextToken());
			arrName[i] = st.nextToken();
		}
		
		mergeSort(arrAge, arrName, 0, N-1);
		for(int i=0; i<N; i++) {
			sb.append(arrAge[i]).append(" ").append(arrName[i]).append("\n");
		}
		System.out.println(sb.toString());

	}

	public static void mergeSort(int[] arr, String[] name, int l, int r) {

		if (l == r) {
			return;
		}
		int mid = (l + r) / 2;
		mergeSort(arr, name, l, mid);
		mergeSort(arr, name, mid + 1, r);
		merge(arr, name, l, mid, r);

	}
	
	public static void merge(int[] arr, String[] name, int l, int mid, int r) {
		int left = l;
		int right = mid +1;
		int idx = l;
		
		while (left <= mid && right <= r) {
			if(arr[left] <= arr[right]) {
				tempAge[idx] = arr[left];
				tempName[idx] = name[left];
				idx++;
				left++;
			} else {
				tempAge[idx] = arr[right];
				tempName[idx] = name[right];
				idx++;
				right++;
			}
		}
		
		if(left > mid) {
			while(right<=r) {
				tempAge[idx] = arr[right];
				tempName[idx] = name[right];
				idx++;
				right++;
			}
		} else {
			while(left <= mid) {
				tempAge[idx] = arr[left];
				tempName[idx] = name[left];
				idx++;
				left++;
			}
		}
		
		for(int i=l; i<=r; i++) {
			arr[i] = tempAge[i];
			name[i] = tempName[i];
		}
		
	}
}