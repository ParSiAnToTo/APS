import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken()); // 집의 수
			int n = Integer.parseInt(st.nextToken()); // 길의 수
			if (m == 0 && n == 0) {
				break;
			}
			int[][] edges = new int[n][3];

			int cost = 0;
			for (int i = 0; i < n; i++) {

				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				cost += z;
				edges[i][0] = x;
				edges[i][1] = y;
				edges[i][2] = z;

			}

			Arrays.sort(edges, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			p = new int[m];

			for (int i = 0; i < p.length; i++) {
				p[i] = i;
			}

			int ans = 0;
			int pick = 0;

			for (int i = 0; i < n; i++) {
				int px = find(edges[i][0]);
				int py = find(edges[i][1]);

				if (px != py) {
					union(px, py);
					ans += edges[i][2];
					pick++;
				}

				if (pick == m - 1) {
					break;
				}

			}
			System.out.println(cost - ans);
		}

	} // end of main

	static int find(int x) {
		if (x != p[x]) {
			return find(p[x]);
		}
		return p[x];
	}

	static void union(int x, int y) {
		p[y] = x;
	}

} // end of class