import java.io.*;
import java.util.*;


public class Main {

    static int n, m, count;
    static List<Integer>[] graph;
    static boolean[] visited;


    static void marriageVisiter() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        int depth = 0;
        while (!q.isEmpty() && depth < 2) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                for (int j : graph[curr]) {
                    if (!visited[j]) {
                        visited[j] = true;
                        q.add(j);
                        count++;
                    }
                }
            }
            depth++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[n + 1];
        marriageVisiter();

        sb.append(count);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class