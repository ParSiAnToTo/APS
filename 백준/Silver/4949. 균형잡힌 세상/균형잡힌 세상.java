import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		String string;
		while (true) {
			stack = new Stack<>();
			string = br.readLine();
			if(string.equals(".")) //종료조건
				break;
			
			int len = string.length();
			for (int i = 0; i < len; i++) {
				char ch = string.charAt(i);
				
				if (ch=='(') {
					stack.push(ch);
				} else if (ch=='[') {
					stack.push(ch);
					
				} else if (ch==')') {
					
					if(stack.isEmpty()) {
						stack.push(ch);
						break;
					} else if (stack.peek()=='(') {
						stack.pop();						
					} else 
						break;
					
				} else if (ch==']') {
					
					if (stack.isEmpty()) {
						stack.push(ch);
						break;
					} else if (stack.peek()=='[') {
						stack.pop();		
					} else
						break;
				}

			} // for

			if (stack.isEmpty())
				System.out.println("yes");
			else if(!stack.isEmpty())
				System.out.println("no");

		}
		br.close();
	}
}
