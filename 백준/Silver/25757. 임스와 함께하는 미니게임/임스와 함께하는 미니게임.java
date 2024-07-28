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
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		String gameType = st.nextToken();
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String userName = br.readLine();
			set.add(userName);
		}
		int answer = 0;
		if (gameType.equals("Y")) {
			answer = set.size();
		} else if (gameType.equals("F")) {
			answer = set.size() / 2;
		} else {
			answer = set.size() / 3;
		}
		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class