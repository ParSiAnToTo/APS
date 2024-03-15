import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		String bomb = br.readLine();
		char last = bomb.charAt(bomb.length() - 1);
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < line.length(); i++) {
			char point = line.charAt(i);
			stack.push(point);

			if (point == last && stack.size() >= bomb.length()) {
				boolean chk = false;
				for (int j = 0; j < bomb.length(); j++) {
					if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
						chk = true;
						break;
					}
				}
				if (!chk) {
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}

		if (stack.size() > 0) {
			for (int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
		} else {
			sb.append("FRULA");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class