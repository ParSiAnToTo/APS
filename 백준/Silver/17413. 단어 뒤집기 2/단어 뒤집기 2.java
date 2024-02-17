import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		br.close();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		int len = S.length();


		boolean meetBracket = false;
		for(int i=0; i<len; i++) {
			if(S.charAt(i)=='<') { 
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(S.charAt(i));
				meetBracket = true;
			} else if (S.charAt(i)=='>') {
				sb.append(S.charAt(i));
				meetBracket = false;
			} else if (S.charAt(i)==' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(S.charAt(i));
			} else if (meetBracket) {
				sb.append(S.charAt(i));
			} else if (i==len-1){
				stack.push(S.charAt(i));
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
			} else {
				stack.push(S.charAt(i));
			}
		}

		System.out.println(sb);

	}

}
