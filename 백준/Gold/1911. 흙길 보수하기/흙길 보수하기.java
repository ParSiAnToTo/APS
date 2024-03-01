import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[][] list = new int[N][2];
		int srt = 0;
		int end = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			srt = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			list[i][0] = srt;
			list[i][1] = end;
		}
		Arrays.sort(list, (a,b)->Integer.compare(a[0], b[0]));

		int result = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if(list[i][0] > idx) {
				idx = list[i][0];
			}
			
			while(idx < list[i][1]) {
				idx += L;
				result++;
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class