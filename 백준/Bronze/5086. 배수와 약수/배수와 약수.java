import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			if(num1 == 0 && num2 == 0) {
				break;
			} else if(num1 < num2 && num2%num1 ==0){
				sb.append("factor\n");
			} else if(num1 > num2 && num1%num2 ==0) {
				sb.append("multiple\n");
			} else {
				sb.append("neither\n");
			}		
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class