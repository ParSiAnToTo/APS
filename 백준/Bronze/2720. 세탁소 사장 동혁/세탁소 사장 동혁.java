import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int C = Integer.parseInt(br.readLine());
			int Q = C / 25;
			int D = C % 25 / 10;
			int N = C % 25 % 10 / 5;
			int P = C % 25 % 10 % 5;
			sb.append(Q + " " + D + " " + N + " " + P + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class