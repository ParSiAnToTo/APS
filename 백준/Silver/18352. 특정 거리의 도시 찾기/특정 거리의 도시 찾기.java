import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, X;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static ArrayList<Integer> distanceK;

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N + 1];
        distanceK = new ArrayList<>();
        int distance = 0;

        q.add(X);
        visited[X] = true;

        while (!q.isEmpty()) {
            if (distance == K) {
                while (!q.isEmpty()) {
                    distanceK.add(q.poll());
                }
                break;
            }

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int next : adjList[cur]) {
                    if (!visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }

            distance++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
        }

        bfs();

        if (distanceK.isEmpty()) {
            sb.append("-1");
        } else {
            Collections.sort(distanceK);
            for (int city : distanceK) {
                sb.append(city).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}