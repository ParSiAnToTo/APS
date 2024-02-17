import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int findSet(int a) {
		if (a != p[a])
			p[a] = findSet(p[a]);
		return p[a];
	}

	static void union(int a, int b) {
		p[b] = a;
	}

	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());

		int[][] edges = new int[M][3];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				return o1[2] - o2[2];
			}

		});

		p = new int[N + 1];

		for (int j = 0; j <= N; j++) {
			p[j] = j;
		}

		int ans = 0;
		int pick = 0;

		for (int i = 0; i < M; i++) {
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);

			if (px != py) {
				union(px, py);
				ans += edges[i][2];
				pick++;
			}

			if (pick == N - 1) {
				break;
			}

		}

		System.out.println(ans);

	} // end of main

}// end of class