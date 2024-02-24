import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	
	static int N,K, patternlength, result;
	static String hexaNum;
	static HashSet<String> hashSet;
	static ArrayList<String> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // testCase count
		
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // hexadecimal array length
			K = Integer.parseInt(st.nextToken()); // sequence index
			patternlength = N/4;
			
			hashSet = new HashSet<>(); // hexadecimal save collection
			String hexaLine = br.readLine();
			for (int i = 0; i < patternlength; i++) {
				for (int j = 0; j <= N-patternlength; j+= patternlength) {
					hexaNum = hexaLine.substring(j, j+patternlength);
					hashSet.add(hexaNum); // 
				}
				hexaLine = hexaLine.substring(1) + hexaLine.substring(0, 1); // next pattern
			}
		
			list = new ArrayList<>(hashSet);
			Collections.sort(list, Collections.reverseOrder());
			result = Integer.parseInt(list.get(K-1), 16);
			bw.write("#"+ testCase + " " + result + "\n");
			
		} // end of testCase

		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class