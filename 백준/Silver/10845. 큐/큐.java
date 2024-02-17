import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int last;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			switch (command) {
			case "push":
				last = Integer.parseInt(st.nextToken());
				queue.offer(last);
				break;
			case "pop":
				if (!queue.isEmpty()) {
					System.out.println(queue.poll());
				} else {
					System.out.println(-1);
				}
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				if (!queue.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(1);
				}
				break;
			case "front":
				if (!queue.isEmpty()) {
					System.out.println(queue.peek());
				} else {
					System.out.println(-1);
				}
				break;
			case "back":
				if (!queue.isEmpty()) {
					System.out.println(last);
				} else {
					System.out.println(-1);
				}
				break;
			default:
				break;
			}

		}

	}// end of main

}// end of class
