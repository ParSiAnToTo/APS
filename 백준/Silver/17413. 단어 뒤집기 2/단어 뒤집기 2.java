import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean flag = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '<') {
                flag = true;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(c);
            } else if (c == '>') {
                flag = false;
                sb.append(c);
            } else if (c == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(c);
            } else if (flag) {
                sb.append(c);
            } else if (i == s.length() - 1) {
                stack.push(c);
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            } else {
                stack.push(c);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
