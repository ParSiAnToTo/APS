import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i<num;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		br.close();
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for (int a : list) {
		    sb.append(a).append("\n");
		}
		bw.write(sb.toString());
		
		bw.close();
	}
}
