import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static ArrayList<coor> house;
	static ArrayList<coor> chicken;
	static boolean[] chk;

	static class coor {
		int x, y;

		public coor(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static void dfs(int start, int depth) {
		if (depth == M) {
			int sum = 0;

			for (int i = 0; i < house.size(); i++) {
				int temp = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (chk[j]) {
						int dist = Math.abs(house.get(i).x - chicken.get(j).x)
								+ Math.abs(house.get(i).y - chicken.get(j).y);
						temp = Math.min(temp, dist);
					}

				}

				sum += temp;
			}

			ans = Math.min(ans, sum);

			return;
		}

		for (int i = start; i < chk.length; i++) {
			chk[i] = true;
			dfs(i + 1, depth + 1);
			chk[i] = false;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		house = new ArrayList<coor>();
		chicken = new ArrayList<coor>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 0) {
					continue;
				} else if (value == 1) {
					house.add(new coor(i, j));
				} else if (value == 2) {
					chicken.add(new coor(i, j));
				}
			}
		}

		ans = Integer.MAX_VALUE;
		chk = new boolean[chicken.size()];

		dfs(0, 0);
		System.out.println(ans);

	}// end of main

}// end of class