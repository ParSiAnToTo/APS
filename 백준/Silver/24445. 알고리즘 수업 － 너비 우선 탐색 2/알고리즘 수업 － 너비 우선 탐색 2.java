import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] visitedList;
    static int index;

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        visitedList[start] = index++;
        q.add(start);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i : graph[curr]) {
                if (!visited[i]) {
                    visited[i] = true;
                    visitedList[i] = index++;
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
        visitedList = new int[N + 1];
        index = 1;

        bfs(R);

        for (int i = 1; i < N + 1; i++) {
            sb.append(visitedList[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class