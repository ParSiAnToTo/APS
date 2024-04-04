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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int row, col;

		if (H % (N + 1) == 0) {
			row = H / (N + 1);
		} else {
			row = (H / (N + 1)) + 1;
		}
		if (W % (M + 1) == 0) {
			col = W / (M + 1);
		} else {
			col = (W / (M + 1)) + 1;
		}
		int result = row * col;

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class