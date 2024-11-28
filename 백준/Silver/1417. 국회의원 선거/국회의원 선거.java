import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int dasom = Integer.parseInt(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (!pq.isEmpty() && pq.peek() >= dasom) {
            int winner = pq.poll();
            winner--;
            dasom++;
            pq.add(winner);
            answer++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
