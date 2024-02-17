import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int len = -1;
		while (true) {
			String palin = br.readLine();
			if(Integer.parseInt(palin)==0) {
				break;
			}// check stop
			
			len = palin.length();
			boolean chk = true;
			for(int i=0; i<len/2; i++) {
				if(palin.charAt(i)!=palin.charAt(len-1-i)) {
					chk = false;
				}
			} //palindrome check
			
			if(chk)
				System.out.println("yes");
			else
				System.out.println("no");
			
			
			
		} //while

	}
}
