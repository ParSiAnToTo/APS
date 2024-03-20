import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		HashSet<Integer> set = new HashSet<>(A + B);

		int a = A;
		int b = B;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			if (!set.add(Integer.parseInt(st.nextToken()))) {
				a--;
				b--;
			}
		}

		bw.write(a + b + "\n");
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class