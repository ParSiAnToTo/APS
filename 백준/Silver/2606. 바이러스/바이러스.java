import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static List<Integer>[] adjList;

    static int bfs(int start) {
        int count = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;

            for (int next : adjList[cur]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int pcCount = Integer.parseInt(br.readLine());
        int pairCount = Integer.parseInt(br.readLine());

        visited = new boolean[pcCount + 1];
        adjList = new ArrayList[pcCount + 1];
        for (int i = 0; i < pcCount + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < pairCount; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }

        int wormCount = bfs(1) - 1;

        bw.write(String.valueOf(wormCount));
        bw.flush();
        bw.close();
    }
}