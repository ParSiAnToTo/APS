import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] updown = new int[2];
	static int[] plus;
	static int ans, F, G;
	static boolean[] visited;
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		F = Integer.parseInt(st.nextToken()); // 건물 총 층 수
		int S = Integer.parseInt(st.nextToken()); // 강호의 현재 위치
		G = Integer.parseInt(st.nextToken()); // 목표 층 수
		int U = Integer.parseInt(st.nextToken()); // 위로 올라가는 층 수
		int D = Integer.parseInt(st.nextToken()); // 내려가는 층 수
		String fail = "use the stairs";

		updown[0] = U;
		updown[1] = -D;
		visited = new boolean[F + 1];
		plus = new int[F+1];
		Arrays.fill(plus, -1);
		q = new LinkedList<>();
		ans = -1;

		bfs(S);
		if (ans == -1) {
			System.out.println(fail);
		} else {
			System.out.println(ans);
		}

	}// end of main

	static void bfs(int st) {

		q.offer(st);
		visited[st] = true;
		plus[st]=0;

		while (!q.isEmpty()) {
			int num = q.poll();

			if(num == G) {
				ans = plus[num];
				return;
			}
			for (int i = 0; i < updown.length; i++) {
				if (num + updown[i] <= F && num + updown[i] >= 1) {
					if (!visited[num + updown[i]]) {
						visited[num + updown[i]]=true;
						plus[num + updown[i]]=plus[num]+1;
						q.offer(num + updown[i]);
						
					}

				}

			}
		}

	}// end of method

}// end of class