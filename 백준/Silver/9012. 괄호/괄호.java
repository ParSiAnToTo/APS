import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> stack = new Stack<>();
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			stack = new Stack<>();
			String line = br.readLine();
			boolean chk = true;
			for (int j = 0; j < line.length(); j++) {
				char c = line.charAt(j);

				if (c == '(') {
					stack.add(c);

				} else if (c == ')' && !stack.isEmpty()) {
					stack.pop();

				} else {
					chk=false;
					break;
				}

			}

			if (chk && stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");

		}

	}

}
