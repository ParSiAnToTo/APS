import java.io.IOException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int zero = 1;
			int one = 0;
			int zeroPlusOne = 1;
			for (int j = 0; j < N; j++) {
				zero=one;
				one = zeroPlusOne;
				zeroPlusOne = zero+one;
			}
			System.out.println(zero+" "+one);
					
		}
		
	}// end of main

}// end of class
