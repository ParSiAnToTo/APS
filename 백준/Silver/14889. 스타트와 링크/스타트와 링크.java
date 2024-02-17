import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr;
	static boolean[] selected;
	static int min=Integer.MAX_VALUE;
//	static int startTeam, linkTeam;

	public static void startLink(int start, int depth) {
		if (depth == N / 2) {
			int startTeam = 0;
			int linkTeam = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (selected[i] && selected[j]) {
						startTeam += arr[i][j];
						startTeam += arr[j][i];
					} else if (!selected[i] && !selected[j]) {
						linkTeam += arr[i][j];
						linkTeam += arr[j][i];
					}
				}
			}
			
			int gap = Math.abs(startTeam-linkTeam);
			if(gap < min) {
				min = gap;
			}

			return;
		}

		for (int i = start; i < N; i++) {
			if (!selected[i]) {
				selected[i] = true;
				startLink(i + 1, depth + 1);
				selected[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		selected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		startLink(0, 0);
		System.out.println(min);
	}// end of main

}// end of class