import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // array length
		int K = Integer.parseInt(st.nextToken()); // target number

		int[] sequence = new int[N]; // number array

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) { // number data input
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		int ans = -100000001; // answer parameter
		int sum = 0; // partial array sum
		for (int i = 0; i <K; i++) {
			sum += sequence[i]; // partial array sum init
		}
		ans = Math.max(ans, sum);
		
		for (int i = K; i < sequence.length; i++) { // sliding window
			sum += sequence[i]; 
			sum -= sequence[i-K];
			ans = Math.max(ans, sum); // ans update
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class