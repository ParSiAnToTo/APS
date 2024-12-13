import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new ArrayDeque<>();
        int last = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if (command.equals("push")) {
                last = Integer.parseInt(st.nextToken());
                q.add(last);
            } else if (command.equals("pop")) {
                sb.append(q.isEmpty() ? -1 : q.poll()).append('\n');
            } else if (command.equals("size")) {
                sb.append(q.size()).append('\n');
            } else if (command.equals("empty")) {
                sb.append(q.isEmpty() ? 1 : 0).append('\n');
            } else if (command.equals("front")) {
                sb.append(q.isEmpty() ? -1 : q.peek()).append('\n');
            } else if (command.equals("back")) {
                sb.append(q.isEmpty() ? -1 : last).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}