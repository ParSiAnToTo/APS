import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>(N);
		
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), null);
		}
		
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if(map.containsKey(name)) {
				result.add(name);
			}
		}

		Collections.sort(result);
		sb.append(result.size()).append("\n");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append("\n");
		}
		
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb.toString());


	} // end of main

} // end of class