import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int ans, count, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 수빈이
		K = Integer.parseInt(st.nextToken()); // 동생
		
		if(N==K) {
			System.out.println(0);
		} else {
		bfs(N);
		System.out.println(ans);
		}

	}// end of main

	static void bfs(int st) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[100001];

		q.offer(st);
		visited[st] = true;

		while (!q.isEmpty()) {
			count++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int num = q.poll();
				visited[num] = true;
				if (num + 1 == K || num - 1 == K || num * 2 == K) {
					ans = count;
					return;
				}

				if (num - 1 >= 0 && !visited[num - 1]) {
					visited[num - 1] = true;
					q.offer(num - 1);
				}
				if (num + 1 <= 100000 && !visited[num + 1]) {
					visited[num + 1] = true;
					q.offer(num + 1);
				}
				if (num * 2 <= 100000 && !visited[num * 2]) {
					visited[num * 2] = true;
					q.offer(num * 2);
				}

			}

		}

	}

}// end of class
