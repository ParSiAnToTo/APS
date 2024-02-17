import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<int[]> stack = new Stack<int[]>();
		for (int i = 1; i <= N; i++) {
			int tower = Integer.parseInt(st.nextToken());

			if (stack.isEmpty()) {
				sb.append(0).append(" ");
				stack.push(new int[] { i, tower });
			} else {
				while (true) {
					if(stack.isEmpty()) {
						sb.append(0).append(" ");
						stack.push(new int[] { i, tower });
						break;
					}else if (stack.peek()[1] >= tower) {
						sb.append(stack.peek()[0]).append(" ");
						stack.push(new int[] { i, tower });
						break;
					} else {
						stack.pop();
					} 
				}//while
			}

		}//for

		System.out.println(sb);

	}
}
