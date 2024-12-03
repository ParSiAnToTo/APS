import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                Long num = Long.parseLong(st.nextToken());
                pq.add(num);
            }
            Long cost = 0L;
            while (pq.size() > 1) {
                Long X1 = pq.poll();
                Long X2 = pq.poll();
                Long Y1 = X1 + X2;
                pq.add(Y1);
                cost += Y1;
            }
            sb.append(cost).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}