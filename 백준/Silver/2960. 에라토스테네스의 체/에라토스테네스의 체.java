import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		boolean[] prime = new boolean[N+1];
		prime[0] = true;
		prime[1] = true;

		int cnt = 1;

		for (int i = 2; i <= N; i++) {
			int j=i;
			while(j<=N) {
				
				if (!prime[j]) {
					prime[j] = true;
					
					if(cnt==K) {
						System.out.println(j);
						return;
					} else {
						j+=i;
						cnt++;
					}
					
				} else { // 이미 지운 수라면
					j+=i;
				}
			} //while
		}

	}
}
