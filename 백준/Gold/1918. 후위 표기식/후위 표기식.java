import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		ArrayList<Character> postfix = new ArrayList<>();
		String line = br.readLine();
		int len = line.length();

		for (int i = 0; i < len; i++) {
			char value = line.charAt(i);
			switch (value) {
			case '(':
				stack.push(value);
				break;
			case ')':
				while (stack.peek() != '(') {
					postfix.add(stack.pop());
				}
				stack.pop();
				break;
			case '*':
			case '/':
				while ((stack.size() != 0 && stack.peek() == '*') || (stack.size() != 0 && stack.peek() == '/')) {
					postfix.add(stack.pop());
				}
				stack.push(value);
				break;
			case '-':
			case '+':
				while (stack.size() != 0 && stack.peek() != '(') {
					postfix.add(stack.pop());
				}
				stack.push(value);
				break;
			default:
				postfix.add(value);
				break;

			}

		}
		
		while(!stack.isEmpty()) {
			postfix.add(stack.pop());
		}
		
		for(int j=0; j<postfix.size(); j++) {
			sb.append(postfix.get(j));
		}
		System.out.println(sb);

	}
}
