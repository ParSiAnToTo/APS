import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] visitedDepthList;

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        visitedDepthList[start] = 0;
        q.add(start);
        int nowWidthCount = q.size();
        int nextWidthCount = 0;
        int depth = 1;

        while (!q.isEmpty()) {
            if (nowWidthCount == 0) {
                depth++;
                nowWidthCount = nextWidthCount;
                nextWidthCount = 0;
            }

            int curr = q.poll();
            nowWidthCount--;

            for (int i : graph[curr]) {
                if (!visited[i]) {
                    visited[i] = true;
                    visitedDepthList[i] = depth;
                    nextWidthCount++;
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i = 0; i < N + 1; i++) {
            graph[i].sort(Comparator.reverseOrder());
        }

        visited = new boolean[N + 1];
        visitedDepthList = new int[N + 1];
        Arrays.fill(visitedDepthList, -1);

        bfs(R);

        for (int i = 1; i < N + 1; i++) {
            sb.append(visitedDepthList[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class