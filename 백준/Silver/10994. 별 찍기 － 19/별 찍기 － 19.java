import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		char[][] star = new char[4 * N - 3][4 * N - 3];
		for (int i = 0; i < star.length; i++) {
			Arrays.fill(star[i], ' ');
		}

		stars(N, star, 0, 0);

		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star.length; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}

		sb.delete(sb.length() - 1, sb.length());
		System.out.println(sb.toString());

	}// end of main

	static void stars(int n, char[][] arr, int r, int c) {
		if (n == 1) {
			arr[arr.length / 2][arr.length / 2] = '*';
			return;
		}

		for (int i = c; i < c + 4 * n - 3; i++) {
			arr[r][i] = '*';
			arr[r + 4 * n - 4][i] = '*';
		}

		for (int i = r; i < r + 4 * n - 3; i++) {
			arr[i][c] = '*';
			arr[i][c + 4 * n - 4] = '*';
		}

		stars(n - 1, arr, r + 2, c + 2);
	}

} // end of class