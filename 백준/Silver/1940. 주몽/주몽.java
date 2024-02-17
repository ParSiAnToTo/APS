import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); // length
		st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken()); // target

		int[] arr = new int[N]; // data input array
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) { // data input
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int count = 0;
		int start = 0;
		int end = N-1;
		while(start < end) {
			int material = arr[start]+arr[end];
			if(material == M) {
				count++;
				start++;
				end--;
			} else if (material < M) {
				start++;
			} else {
				end--;
			}
		}

		System.out.println(count);


	} // end of main

} // end of class
