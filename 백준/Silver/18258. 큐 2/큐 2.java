import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int last;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
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
					sb.append(queue.poll()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				if (!queue.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(1).append("\n");
				}
				break;
			case "front":
				if (!queue.isEmpty()) {
					sb.append(queue.peek()).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
				break;
			case "back":
				if (!queue.isEmpty()) {
					sb.append(last).append("\n");
				} else {
					sb.append(-1).append("\n");
				}
				break;
			default:
				break;
			}

		} //for
		System.out.println(sb.toString());

	}// end of main

}// end of class