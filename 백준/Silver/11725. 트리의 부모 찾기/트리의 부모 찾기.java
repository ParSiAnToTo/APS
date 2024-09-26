import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static boolean[] visited;
    static List<Integer>[] graph;

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = now;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        bfs(1);

        for (int i = 2; i < parent.length; i++) {
            sb.append(parent[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class