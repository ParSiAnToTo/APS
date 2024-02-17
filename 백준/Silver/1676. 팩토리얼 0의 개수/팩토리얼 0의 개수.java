import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		if(N==0) {
			System.out.println(0);
			System.exit(0);
		}
		
		BigInteger bigNum = BigInteger.ONE;
		
		for (int i = 1; i <= N; i++) {
			
			bigNum = bigNum.multiply(BigInteger.valueOf(i));
		}
		
		String facto = String.valueOf(bigNum);
		
		int ans = 0;
		for (int i = facto.length()-1; i >= 0; i--) {
			if(facto.charAt(i)=='0') {
				ans++;
			} else {
				break;
			}
		}
		
		System.out.println(ans);
				
	}// end of main
		
}// end of class