import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	static class Edge {
		int ed;
		int w;

		public Edge(int ed, int w) {
			this.ed = ed;
			this.w = w;
		}
	}

	static final long INF = Long.MAX_VALUE;
	static int N;
	static int M;
	static long[] dist;
	static List<Edge>[] busList;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		busList = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			busList[i] = new ArrayList<>();
		}

		dist = new long[N + 1];
		Arrays.fill(dist, INF);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			boolean dupChk = false;
			for (Edge e : busList[a]) {
				if (e.ed == b) {
					e.w = Math.min(e.w, w);
					dupChk = true;
					break;
				}
			}
			if (!dupChk) {
				busList[a].add(new Edge(b, w));
			}

		}

		if (bellmanFord()) {
			for (int i = 2; i <= N; i++) {
				if (dist[i] != INF) {
					sb.append(dist[i]).append("\n");
				} else {
					sb.append("-1").append("\n");
				}
			}
		} else {
			sb.append("-1");
		}

		System.out.println(sb.toString());

	}// end of main

	static boolean bellmanFord() {
		dist[1] = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= N; j++) {
				for (Edge e : busList[j]) {
					if (dist[j] != INF) {
						if (dist[e.ed] > dist[j] + e.w) {
							dist[e.ed] = dist[j] + e.w;
						}
					}
				}

			}
		}

		for (int i = 1; i <= N; i++) {
			for (Edge e : busList[i]) {
				if (dist[i] != INF) {
					if (dist[e.ed] > dist[i] + e.w) {
						return false;
					}
				}
			}

		}

		return true;

	}

} // end of class
