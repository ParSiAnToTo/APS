import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        Stack<Integer> pointer = new Stack<>();
        Deque<Character> strings = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int way = Integer.parseInt(st.nextToken());
            if (way < 3) {
                if (way == 1) {
                    pointer.push(way);
                    strings.addLast(st.nextToken().charAt(0));
                } else if (way == 2) {
                    pointer.push(way);
                    strings.addFirst(st.nextToken().charAt(0));
                }
            } else {
                if (!pointer.isEmpty()) {
                    int command = pointer.pop();
                    if (command == 1) {
                        strings.pollLast();
                    } else if (command == 2) {
                        strings.pollFirst();
                    }
                }
            }
        }

        if (strings.isEmpty()) {
            sb.append("0");
        } else {
            while (!strings.isEmpty()) {
                sb.append(strings.pollFirst());
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
