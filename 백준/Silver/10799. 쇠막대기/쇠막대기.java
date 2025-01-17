import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        int count = 0;
        boolean statusChk = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(c);
                statusChk = false;
            } else if (c == ')') {
                stack.pop();
                if (!statusChk) {
                    count += stack.size();
                } else {
                    count++;
                }
                statusChk = true;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
