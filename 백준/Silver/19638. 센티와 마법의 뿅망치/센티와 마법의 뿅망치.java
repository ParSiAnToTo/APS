import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;

        while (pq.peek() >= H && count < T) {
            if(pq.peek() == 1) {
                break;
            } else {
                pq.add(pq.poll()/2);
                count++;
            }
        }

        if(pq.peek() < H && count <= T) {
            sb.append("YES").append("\n");
            sb.append(count).append("\n");
        } else {
            sb.append("NO").append("\n");
            sb.append(pq.peek()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
