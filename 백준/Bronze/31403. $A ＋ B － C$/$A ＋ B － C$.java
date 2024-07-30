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
		String A = br.readLine();
		String B = br.readLine();
		String C = br.readLine();
		int abc = Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C);
		String ab = A + B;
		int abcString = Integer.parseInt(ab) - Integer.parseInt(C);
		sb.append(abc + "\n");
		sb.append(abcString + "\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class