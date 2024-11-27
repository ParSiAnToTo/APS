import java.io.*;
import java.util.*;

public class Main {

    static class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            Queue<Document> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            int docsCount = Integer.parseInt(st.nextToken());
            int targetDocsIndex = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int index = 0; index < docsCount; index++) {
                int priority = Integer.parseInt(st.nextToken());
                q.add(new Document(index, priority));
                pq.add(priority);
            }

            int printIndex = 0;

            while (!q.isEmpty()) {
                Document doc = q.poll();
                if (doc.priority == pq.peek()) {
                    printIndex++;
                    pq.poll();
                    if (doc.index == targetDocsIndex) {
                        sb.append(printIndex).append("\n");
                        break;
                    }
                } else {
                    q.add(doc);
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
