import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] inDegree;
    static int[] result;

    static void Topological() {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                result[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                inDegree[next]--;
                result[next] = Math.max(result[next], result[cur] + 1);

                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            inDegree[v]++;
        }

        result = new int[N + 1];

        Topological();

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}