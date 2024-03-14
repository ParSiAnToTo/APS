import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		int N = line.length();
		if (N % 10 == 0) {
			for (int i = 0; i < N; i += 10) {
				bw.write(line.substring(i, i + 10) + "\n");
			}
		} else {
			for (int i = 0; i < N; i += 10) {
				if (i == (N / 10) * 10) {
					bw.write(line.substring(i, N) + "\n");
				} else {
					bw.write(line.substring(i, i + 10) + "\n");
				}
			}
		}

		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class