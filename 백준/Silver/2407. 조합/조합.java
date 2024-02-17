import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		BigInteger A = BigInteger.ONE;
		BigInteger B = BigInteger.ONE;

		for (int i = 0; i < m; i++) {
			A = A.multiply(new BigInteger(String.valueOf(n - i)));
			B = B.multiply(new BigInteger(String.valueOf(i + 1)));

		}

		System.out.println(A.divide(B));

	}
}
