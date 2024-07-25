import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static boolean whatIsTheQuestion(String question) {
		try {
			Integer.parseInt(question);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> mapK = new HashMap<>(N);
		HashMap<String, Integer> mapV = new HashMap<>(N);
		for (int i = 0; i < N; i++) {
			String pokemon = br.readLine();
			mapK.put(i + 1, pokemon);
			mapV.put(pokemon, i + 1);
		}
		for (int i = 0; i < M; i++) {
			String question = br.readLine();
			if (whatIsTheQuestion(question)) {
				sb.append(mapK.get(Integer.parseInt(question)) + "\n");
			} else {
				sb.append(mapV.get(question) + "\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class