import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> right = new PriorityQueue<>();

		int target, swap;
		for (int i = 0; i < N; i++) {
			target = Integer.parseInt(br.readLine());
			if (left.size() == right.size()) {
				left.offer(target);
			} else {
				right.offer(target);
			}

			if (!left.isEmpty() && !right.isEmpty()) {
				if (right.peek() < left.peek()) {
					swap = left.poll();
					left.offer(right.poll());
					right.offer(swap);
				}

			}

			sb.append(left.peek() + "\n");

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class