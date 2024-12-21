import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int max = 0;
    static ArrayList<Integer>[] graph;
    static int[] list;
    static boolean[] visited;
    static int count;

    public static void dfs(int i) {
        visited[i] = true;
        count++;
        for (int next : graph[i]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            count = 0;            
            dfs(i);
            list[i] = count;
        }

        for (int i = 1; i < N + 1; i++) {
            max = Math.max(max, list[i]);
        }

        for (int i = 1; i < N + 1; i++) {
            if (list[i] == max) {
                sb.append(i).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
