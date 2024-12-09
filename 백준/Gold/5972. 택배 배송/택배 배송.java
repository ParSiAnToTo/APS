import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<ArrayList<Edge>> adj;
    static int[] dist;

    static class Edge implements Comparable<Edge> {
        int ed;
        int weight;

        public Edge(int ed, int weight) {
            this.ed = ed;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private static void dijk() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.weight > dist[cur.ed]) {
                continue;
            }

            for (Edge next : adj.get(cur.ed)) {
                if (dist[cur.ed] + next.weight < dist[next.ed]) {
                    dist[next.ed] = dist[cur.ed] + next.weight;
                    pq.add(new Edge(next.ed, dist[next.ed]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new Edge(v, w));
            adj.get(v).add(new Edge(u, w));
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijk();

        bw.write(String.valueOf(dist[N]));
        bw.flush();
        bw.close();
    }
}