import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Stack<Integer> stack = new Stack<>();
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();;
		
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch(command) {
			case "1":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "2":
				if(!(stack.isEmpty())) {
					sb.append(stack.pop()).append("\n");
				} else
					sb.append(-1).append("\n");
				break;
			case "3":
				sb.append(stack.size()).append("\n");
				break;
			case "4":
				sb.append(stack.isEmpty() ? 1 : 0).append("\n");
				break;
			case "5":
				if(!(stack.isEmpty())) {
					sb.append(stack.peek()).append("\n");
				} else
					sb.append(-1).append("\n");
				break;
			default:
				break;
			
			
			}
			
			
		}
		System.out.print(sb.toString());
		br.close();
	}
}