import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String N = br.readLine();
		int num = Integer.parseInt(N);
		int target = Integer.parseInt(N);
		int cycle = 1;
		if (target < 10) {
			target = target * 10 + target;
		} else {
			target = target % 10 * 10 + (target / 10 + target % 10) % 10;
		}
		while (num != target) {
			target = target % 10 * 10 + (target / 10 + target % 10) % 10;
			cycle++;
		}

		bw.write(cycle + "\n");
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class