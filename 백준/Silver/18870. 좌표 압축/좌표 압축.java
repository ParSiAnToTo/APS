import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] arr2 = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr2 = Arrays.copyOf(arr, arr.length);
		Arrays.sort(arr);

		int rank = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], rank++);
			}
		}

		for (int i = 0; i < arr2.length; i++) {
			sb.append(map.get(arr2[i])).append(" ");
		}

		System.out.println(sb.toString());

	} // end of main

} // end of class