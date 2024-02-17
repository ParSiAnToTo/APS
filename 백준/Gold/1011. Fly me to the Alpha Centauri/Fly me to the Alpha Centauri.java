import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dist = y - x;
			int ans = 0;

			double count = Math.sqrt(dist);
			if (count % 1 == 0) {
				ans = (int) Math.round(2 * count - 1);
			} else {
				double cheker = Math.ceil(count);
				if (dist > Math.pow(cheker, 2) - cheker) {
					ans = (int) (2 * cheker - 1);
				} else {
					ans = (int) (2 * cheker - 2);
				}

			}

			sb.append(ans).append("\n");

		}

		System.out.println(sb.toString());

	}// end of main

}// end of class