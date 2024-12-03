import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<Node>[] graph;

    static class Node implements Comparable<Node> {
        int ed;
        int weight;

        public Node(int ed, int weight) {
            this.ed = ed;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return o.weight - this.weight;
        }
    }

    private static int find(int islandA, int islandB) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        pq.add(new Node(islandA, Integer.MAX_VALUE));
        int maxLimitWeight = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            visited[cur.ed] = true;

            if (cur.ed == islandB) {
                maxLimitWeight = cur.weight;
                break;
            }

            for (Node next : graph[cur.ed]) {
                if (!visited[next.ed]) {
                    int curLimitWeight = Math.min(cur.weight, next.weight);
                    pq.add(new Node(next.ed, curLimitWeight));
                }
            }
        }
        return maxLimitWeight;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));
        }

        st = new StringTokenizer(br.readLine());
        int islandA = Integer.parseInt(st.nextToken());
        int islandB = Integer.parseInt(st.nextToken());

        int answer = find(islandA, islandB);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}