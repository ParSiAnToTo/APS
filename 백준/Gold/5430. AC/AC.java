import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int T = Integer.parseInt(st.nextToken());
		for (int testCase = 0; testCase < T; testCase++) {
			String command = br.readLine();
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			String[] line = br.readLine().replace("]", "").replace("[", "").split(",");
			sb.append(ac(command, num, line));
			
			if(testCase <T-1) {
				sb.append("\n");
			}

		} // end of testCase

		System.out.println(sb.toString());

	}// end of main

	static String ac(String command, int number, String[] line) {
		Deque<String> dq = new ArrayDeque<>();
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < number; i++) {
			dq.offer(line[i]);
		}

		boolean dir = false;
		for (int i = 0; i < command.length(); i++) {
			char com = command.charAt(i);
			if (com == 'R') {
				if (dir) {
					dir = false;
				} else {
					dir = true;
				}
			} else {
				if (dq.isEmpty()) {
					return ans.append("error").toString();
				}

				if (!dir) {
					dq.pollFirst();
				} else {
					dq.pollLast();
				}
			}

		} // end of command order

		ans.append("[");
		if (!dir) {
			while (!dq.isEmpty()) {
				ans.append(dq.pollFirst()).append(",");
			}
		} else {
			while (!dq.isEmpty()) {
				ans.append(dq.pollLast()).append(",");
			}

		}

		if(ans.length()>1) {
		ans.deleteCharAt(ans.length() - 1);
		}
		
		ans.append("]");
		
		return ans.toString();

	}

}// end of class