import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		HashSet<String> set = new HashSet<>(N);
		for (int i = 0; i < N; i++) {
			String next = br.readLine();
			if (next.equals("ENTER")) {
				set.clear();
			} else {
				if (set.add(next)) {
					count++;
				}
			}
		}
		
		System.out.println(count);

	} // end of main

} // end of class