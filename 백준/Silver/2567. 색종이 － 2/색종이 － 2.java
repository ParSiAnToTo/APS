import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int[][] paper = new int[101][101];
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();

			for (int j = r; j < r + 10; j++) {
				for (int k = c; k < c + 10; k++) {
					paper[j][k] = 1;
				}
			}
		} // paper paste

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };

		int cnt = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {

				if (paper[i][j] == 1) {
					for (int dir = 0; dir < 4; dir++) {
						if (i + dr[dir] >= 0 && i + dr[dir] < 101 && j + dc[dir] >= 0 && j + dc[dir] < 101
								&& paper[i + dr[dir]][j + dc[dir]] == 0)
							cnt++;

					}
				}
			}
		}

		System.out.println(cnt);

	}

}