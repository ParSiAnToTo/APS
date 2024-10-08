import java.io.*;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int cur = 1;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());

            while (cur <= target) {
                stack.push(cur++);
                sb.append("+").append("\n");
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                flag = true;
            }
        }

        if (flag) {
            sb = new StringBuilder().append("NO");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}