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
            ArrayList<Integer> priorityList = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int docsCount = Integer.parseInt(st.nextToken());
            int targetDocsIndex = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int index = 0; index < docsCount; index++) {
                int priority = Integer.parseInt(st.nextToken()) * 1000;
                q.add(priority + index);
                priorityList.add(priority);
            }
            Collections.sort(priorityList, Collections.reverseOrder());

            int printIndex = 1;
            int priorityIndex = 0;
            int highestPriority = priorityList.get(priorityIndex);

            while (true) {
                while (q.peek() / 1000 != highestPriority / 1000) {
                    q.add(q.poll());
                }
                int docs = q.poll();
                if (docs % 1000 == targetDocsIndex) {
                    sb.append(printIndex + "\n");
                    break;
                }

                printIndex++;
                priorityIndex++;
                highestPriority = priorityList.get(priorityIndex);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
