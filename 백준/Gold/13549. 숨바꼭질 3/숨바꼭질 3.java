import java.io.*;
import java.util.*;

public class Main {

    static final int maxPosition = 100000;
    static final int INF = 100000;
    static int[] time = new int[maxPosition + 1];

    static class SubinPosition implements Comparable<SubinPosition> {
        int position;
        int second;

        public SubinPosition(int position, int second) {
            this.position = position;
            this.second = second;
        }

        @Override
        public int compareTo(SubinPosition o) {
            return this.second - o.second;
        }
    }

    static void dijkstra(int startPosition) {
        time[startPosition] = 0;
        PriorityQueue<SubinPosition> pq = new PriorityQueue();
        pq.add(new SubinPosition(startPosition, 0));

        while (!pq.isEmpty()) {
            SubinPosition now = pq.poll();

            if (isValidMove(now.position + 1) && time[now.position + 1] > now.second + 1) {
                time[now.position + 1] = now.second + 1;
                pq.add(new SubinPosition(now.position + 1, now.second + 1));
            }
            if (isValidMove(now.position - 1) && time[now.position - 1] > now.second + 1) {
                time[now.position - 1] = now.second + 1;
                pq.add(new SubinPosition(now.position - 1, now.second + 1));
            }
            if (isValidMove(now.position * 2) && time[now.position * 2] > now.second) {
                time[now.position * 2] = now.second;
                pq.add(new SubinPosition(now.position * 2, now.second));
            }
        }
    }

    static boolean isValidMove(int position) {
        return position > 0 && position <= maxPosition;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            sb.append(N - K);
        } else {
            Arrays.fill(time, INF);
            dijkstra(N);
            sb.append(time[K]);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class