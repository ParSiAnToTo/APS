import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int goodWord = 0;

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }

            if (stack.isEmpty()) {
                goodWord++;
            }
        }

        bw.write(String.valueOf(goodWord));
        bw.flush();
        bw.close();
    }
}
