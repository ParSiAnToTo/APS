import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String s;

        while (!(s = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '.') {
                    break;
                } else if (s.charAt(i) == '[') {
                    stack.push('[');
                } else if (s.charAt(i) == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(']');
                    }
                } else if (s.charAt(i) == '(') {
                    stack.push('(');
                } else if (s.charAt(i) == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(')');
                    }
                }
            }

            if (stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
