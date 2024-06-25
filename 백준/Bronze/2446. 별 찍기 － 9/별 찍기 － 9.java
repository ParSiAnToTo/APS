import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i <= 2 * (N - 1); i++) {
			sb = new StringBuilder();
			if (i < N) {
				for (int j = 0; j < i; j++) {
					sb.append(" ");
				}
				for (int k = 0; k < 2 * (N - i) - 1; k++) {
					sb.append("*");
				}
				bw.write(sb.toString() + "\n");
			} else {
				for (int j = 0; j < 2 * (N - 1) - i; j++) {
					sb.append(" ");
				}
				for (int k = 0; k < 2 * (i + 1 - N) + 1; k++) {
					sb.append("*");
				}
				bw.write(sb.toString() + "\n");
			}

		}
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class