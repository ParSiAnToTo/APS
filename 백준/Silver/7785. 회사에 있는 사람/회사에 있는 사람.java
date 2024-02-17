import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		HashMap<String, String> map = new HashMap<>(n);
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			String isEnter = st.nextToken();
			if(isEnter.equals("leave")) {
				map.remove(name);
			} else {
				map.put(name, isEnter);
			}
		}
		
		Set<String> set = map.keySet();
		ArrayList<String> result = new ArrayList<>(set);
		Collections.sort(result, Collections.reverseOrder());
		
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append("\n");
		}
		
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb.toString());


	} // end of main

} // end of class