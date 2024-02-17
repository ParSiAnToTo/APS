import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static long A, B;
	static int count;
	static boolean chk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		count = 0;
		bfs(A, B);

		if (chk) {
			System.out.println(-1);
		} else {
			System.out.println(count+1);
		}

	}// end of main

	static void bfs(long x, long y) {
		Queue<Long> q = new LinkedList<>();
		q.offer(x);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				long num = q.poll();
				if (num == y) {
					return;
				}
				if (num * 2 <= y) {
					q.offer(num * 2);
				}
				if (num * 10 + 1 <= y) {
					q.offer(num * 10 + 1);
				}

			}

			count++;
		}

		chk = true;

	}

}// end of class