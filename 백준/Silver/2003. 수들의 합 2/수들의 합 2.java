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
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // array length
		int M = Integer.parseInt(st.nextToken()); // target number
		
		int[] sequence = new int[N]; // number array
		int[] preSum = new int[N+1]; // prefix sum array
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) { // number data input
			int num = Integer.parseInt(st.nextToken());
			sequence[i]=num; // number array input
			preSum[i+1]=preSum[i]+num; // prefix sum array input
		}
		
		int ans = 0;
		
		for (int i = 0; i < preSum.length-1; i++) {
			for (int j = i+1; j < preSum.length; j++) {
				if (preSum[j]-preSum[i]<M) { // if sum of partial array < target
					continue;
				} else if (preSum[j]-preSum[i]==M) { // if sum of partial array == target
					ans++;
				} else {
					break;
				}
			}
		}
		
		bw.write(ans + "\n");		
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class
