import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static Long totalPrice, primPrice;
    static boolean[] visited;
    static ArrayList<Edge>[] graph;

    static class Edge implements Comparable<Edge> {
        int ed;
        Long price;

        public Edge(int ed, Long price) {
            this.ed = ed;
            this.price = price;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.price, o.price);
        }
    }

    static boolean Prim(int start) {
        int count = 0;
        primPrice = 0L;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0L));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.ed]) {
                continue;
            }

            visited[cur.ed] = true;
            primPrice += cur.price;
            count++;

            for (Edge next : graph[cur.ed]) {
                if (!visited[next.ed]) {
                    pq.offer(next);
                }
            }
        }

        return count == N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        totalPrice = 0L; 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Long price = Long.parseLong(st.nextToken());
            graph[a].add(new Edge(b, price));
            graph[b].add(new Edge(a, price));
            totalPrice += price;
        }

        boolean isConnected = Prim(1);

        if (isConnected) {
            bw.write(String.valueOf(totalPrice - primPrice));
        } else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
    }
}
