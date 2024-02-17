import java.util.Scanner;

public class Main {
	public static boolean[] prime;

	public static void primeCheck(int n) { 
		prime = new boolean[n + 1];
		if (n < 2) {
			return;
		}
		prime[0] = true;
		prime[1] = true;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (prime[i] == true) {
				continue;
			}

			for (int j = i * i; j < prime.length; j = j + i) { 
				prime[j] = true;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		primeCheck(N);
		
		for(int i=M; i<=N; i++) {
			if(!prime[i])
				System.out.println(i);
		}
		
		
	}
}
