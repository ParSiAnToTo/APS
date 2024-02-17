import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		int[] B = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < B.length; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		int[] newA = new int[N];
		int[] isDup = new int[101];

		for (int i = 0; i < N; i++) {
			int target = B[i];
			int idx = 0;
			for (int j = 0; j < N; j++) {
				if (target >= B[j]) {
					idx++;
				}
			}
			if(isDup[idx]==0) {
				isDup[idx]++;
				newA[i] = idx-1;
			} else {
				newA[i] = idx-1-isDup[idx];
				isDup[idx]++;
			}
			
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += B[i] * A[N-1-newA[i]];
		}

//		System.out.println(Arrays.toString(A));
//		System.out.println(Arrays.toString(newA));
//		System.out.println(Arrays.toString(B));
//		
//		
		System.out.println(ans);

	} // end of main

} // end of class
