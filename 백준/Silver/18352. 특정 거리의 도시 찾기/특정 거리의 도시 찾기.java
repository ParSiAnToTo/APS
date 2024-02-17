import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		List<Integer>[] adjList = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			adjList[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(X);
		visited[X] = true;
		while (!q.isEmpty()) {
			if (count == K) {
				int[] ans = new int[q.size()];
				for (int i = 0; i < ans.length; i++) {
					ans[i] = q.poll();
				}
				Arrays.sort(ans);
				for (int i = 0; i < ans.length; i++) {
					sb.append(ans[i]).append("\n");
				}
				break;
			}

			int size = q.size();
			for (int k = 0; k < size; k++) {
				int num = q.poll();
				for (int i = 0; i < adjList[num].size(); i++) {
					if (!visited[adjList[num].get(i)]) {
						q.offer(adjList[num].get(i));
						visited[adjList[num].get(i)] = true;
					}
				}

			}
			count++;
		} // while

		if (sb.length() == 0) {
			sb.append(-1);
		}

		System.out.println(sb.toString());

	}// end of main

}// end of class
