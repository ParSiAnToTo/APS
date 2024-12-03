import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int count = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
                count++;
            }

            if (height == 0) {
                continue;
            }

            if (stack.isEmpty() || stack.peek() < height) {
                stack.push(height);
            }
        }

        count += stack.size();


        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}