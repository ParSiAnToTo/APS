import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		boolean chk = false;

		search: for (int i = 0; i <= (N / 3); i++) {
			for (int j = 0; j <= (N / 5); j++) {
				if (i * 3 + j * 5 == N) {
					chk = true;
					System.out.println(j + i);
					break search;
				}
			}
		}

		if (!chk)
			System.out.println(-1);

	}

}