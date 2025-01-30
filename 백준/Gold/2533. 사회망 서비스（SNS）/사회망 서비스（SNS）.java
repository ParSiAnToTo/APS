import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean[] isEA;

    static void dfs(int cur, int parent) {
        visited[cur] = true;
        boolean isLeaf = true;

        for (int child : graph[cur]) {
            if (!visited[child]) {
                isLeaf = false;
                dfs(child, cur);
                if (!isEA[child]) {
                    isEA[cur] = true;
                }
            }
        }

        if (isLeaf) {
            isEA[cur] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[N + 1];
        isEA = new boolean[N + 1];

        dfs(1, 0);

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isEA[i]) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}