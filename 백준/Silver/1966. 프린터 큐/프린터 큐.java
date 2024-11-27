import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            Queue<Integer> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            int docsCount = Integer.parseInt(st.nextToken());
            int targetDocsIndex = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int index = 0; index < docsCount; index++) {
                int priority = Integer.parseInt(st.nextToken()) * 1000;
                q.add(priority + index);
                pq.add(priority);
            }

            int printIndex = 1;

            while (true) {
                while (q.peek() / 1000 != pq.peek() / 1000) {
                    q.add(q.poll());
                }
                int docs = q.poll();
                pq.poll();
                if (docs % 1000 == targetDocsIndex) {
                    sb.append(printIndex + "\n");
                    break;
                }

                printIndex++;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
