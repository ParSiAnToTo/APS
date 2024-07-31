import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String[] line = br.readLine().split("");
		for (int i = 0; i < line.length; i++) {
			if (line[i].charAt(0) <= 90) {
				sb.append((char) (line[i].charAt(0) + 32));
			} else {
				sb.append((char) (line[i].charAt(0) - 32));
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class