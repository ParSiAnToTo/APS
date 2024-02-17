import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
//	총 데이터 개수는 a^b, a^b % 10 = 0일 경우 10번, 그 외는 나오는 값의 번호에서 마지막 데이터 처리 
//	1 : 1 1 1 1 ..
//	2 : 2 4 8 6 ..
//	3 : 3 9 7 1 ..
//	4 : 4 6 ..
//	5 : 5 ..
//	6 : 6 ..
//	7 : 7 9 3 1 ..
//	8 : 8 4 2 6 ..
//	9 : 9 1 ..
	static int[][] sheet = new int[][] {{10,10,10,10},
								   {1,1,1,1}, 
	                               {2,4,8,6},
	                               {3,9,7,1},
	                               {4,6,4,6},
	                               {5,5,5,5},
	                               {6,6,6,6},
	                               {7,9,3,1},
	                               {8,4,2,6},
	                               {9,1,9,1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // TestCase count
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) % 10;
			int b = Integer.parseInt(st.nextToken());
			int index = b%4;
			if(index != 0) {
				bw.write(sheet[a][index-1] + "\n");
			} else {
				bw.write(sheet[a][3] + "\n");
			}
		} // end of TestCase

		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class