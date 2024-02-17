import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); // length
		int M = Integer.parseInt(st.nextToken()); // target

		int[] arrA = new int[N]; // A data input array
		int[] arrB = new int[M]; // B data input array
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) { // array A data input
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) { // array B data input
			arrB[i] = Integer.parseInt(st.nextToken());
		}

		int idxA = 0;
		int idxB = 0;

		while (idxA < N && idxB < M) {
			if (arrA[idxA] <= arrB[idxB]) {
				sb.append(arrA[idxA]).append(" ");
				idxA++;
			} else {
				sb.append(arrB[idxB]).append(" ");
				idxB++;
			}

			if (idxA == N) { // arrA 전부 입력 시
				for (int i = idxB; i < M; i++) {
					sb.append(arrB[i]).append(" ");
				}
			}

			if (idxB == M) { // arrB 전부 입력 시
				for (int i = idxA; i < N; i++) {
					sb.append(arrA[i]).append(" ");
				}
			}

		} // end of two pointer

		System.out.println(sb.toString());

	} // end of main

} // end of class
