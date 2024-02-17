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

	static int N;
	static int M;
	static int W;
	static long[] dist;
	static List<Edge>[] roadList;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int TC = Integer.parseInt(st.nextToken()); // 테스트 케이스 수

		for (int testCase = 0; testCase < TC; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 지점 수
			M = Integer.parseInt(st.nextToken()); // 도로 수
			W = Integer.parseInt(st.nextToken()); // 웜홀 수

			roadList = new ArrayList[N + 1]; // 경로 저장 리스트
			for (int i = 0; i < N + 1; i++) {
				roadList[i] = new ArrayList<>();
			}

			dist = new long[N + 1]; // 최소 거리 저장 배열

			for (int i = 0; i < M + W; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				if (i >= M) { // 단방향
					w = -1 * w;
					roadList[a].add(new Edge(b, w));
				} else { // 양방향
					roadList[a].add(new Edge(b, w));
					roadList[b].add(new Edge(a, w));
				}

			}

			if (bellmanFord()) {
				sb.append("NO").append("\n");
			} else {
				sb.append("YES").append("\n");
			}

		} // end of testCase

		System.out.println(sb.toString());

	}// end of main

	static boolean bellmanFord() {

		for (int i = 1; i < N; i++) { // 지점 수 -1 만큼 반복
			for (int j = 1; j <= N; j++) { // 출발 지점
				for (Edge e : roadList[j]) {

					if (dist[e.ed] > dist[j] + e.w) {
						dist[e.ed] = dist[j] + e.w; // 거리 갱신
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) { // 음의 사이클 체크
			for (Edge e : roadList[i]) {

				// 이미 갱신을 완료하였으나 다시 갱신이 발생한다면 음의 사이클이 생성된 것이다.
				if (dist[e.ed] > dist[i] + e.w) {
					return false; // 사이클 존재
				}

			}
		}

		return true; // 음의 사이클이 없다

	}

} // end of class