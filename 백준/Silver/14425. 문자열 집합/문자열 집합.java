import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>(N);
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), i);
		}

		int count = 0;
		for (int i = 0; i < M; i++) {
			String cord = br.readLine();
			if (map.containsKey(cord)) {
				count++;
			}
		}

		System.out.println(count);

	} // end of main

} // end of class
