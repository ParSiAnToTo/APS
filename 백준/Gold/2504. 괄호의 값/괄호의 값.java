import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int len = input.length();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int sum = 1;

        for (int i = 0; i < len; i++) {
            Character c = input.charAt(i);

            if (c == '(') {
                stack.push(c);
                sum *= 2;

            } else if (c == '[') {
                stack.push(c);
                sum *= 3;

            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    answer = 0;
                    break;
                } else if (i > 0 && input.charAt(i - 1) == '(') {
                    answer += sum;
                }
                sum /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    answer = 0;
                    break;
                } else if (i > 0 && input.charAt(i - 1) == '[') {
                    answer += sum;
                }
                sum /= 3;
            }
        }

        if (!stack.isEmpty()) {
            answer = 0;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}