import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb;
		for (int i = 0; i < 2 * N - 1; i++) {
			sb = new StringBuilder();
			if (i < N) {
				for (int j = 0; j < N - 1 - i; j++) {
					sb.append(" ");
				}
				for (int j2 = 0; j2 < i + 1; j2++) {
					sb.append("*");
				}
			} else {
				for (int j = 0; j < i - (N - 1); j++) {
					sb.append(" ");
				}
				for (int j2 = 0; j2 < 2 * N - 1 - i; j2++) {
					sb.append("*");
				}
			}
			bw.write(sb.toString() + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class