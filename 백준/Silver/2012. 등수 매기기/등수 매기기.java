import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>(N);
		
		int rank = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			rank = Integer.parseInt(st.nextToken());
			list.add(rank);
		}
		Collections.sort(list);
		long result = 0;
		for (int i = 0; i < N; i++) {
			result += Math.abs((long) list.get(i)-(i+1));
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class