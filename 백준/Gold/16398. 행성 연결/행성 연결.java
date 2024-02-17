import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());

		int[][] adjArr = new int[N][N];
		for (int i = 0; i < adjArr.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < adjArr.length; j++) {
				int flow = Integer.parseInt(st.nextToken());
				adjArr[i][j] = flow;
			}
		}

		boolean[] visited = new boolean[N]; // 정점 선택
		long[] dist = new long[N]; // dist 갱신

		Arrays.fill(dist, Long.MAX_VALUE);
    
		dist[0] = 0; //0번 지점 시작
		long ans = 0;

		for (int i = 0; i < N; i++) {
			long min = Long.MAX_VALUE;
			int idx = -1;
  
			for (int j = 0; j < N; j++) { //미선택 정점 중 최소값 선택
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}

			visited[idx] = true; // 선택

			for (int j = 0; j < N; j++) { //미선택 && 최단거리 갱신
				if (!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
				}
			}
		}

		for (int i = 0; i < N; i++) {
			ans += dist[i];
		}

		System.out.println(ans);

	} // end of main

} // end of class