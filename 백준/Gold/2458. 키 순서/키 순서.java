import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] adj;
    static ArrayList<Integer>[] reverseAdj;

    static void isTheyComparable(int start, boolean[] visited, ArrayList<Integer>[] adj) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int student : adj[cur]) {
                if (!visited[student]) {
                    q.add(student);
                    visited[student] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        reverseAdj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
            reverseAdj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            reverseAdj[b].add(a);
        }

        int count = 0;
        next:
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            boolean[] reverseVisited = new boolean[N + 1];
            isTheyComparable(i, visited, adj);
            isTheyComparable(i, reverseVisited, reverseAdj);

            for (int j = 1; j <= N; j++) {
                if (!visited[j] && !reverseVisited[j]) {
                    continue next;
                }
            }
            count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}