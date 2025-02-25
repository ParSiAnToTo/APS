import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] buildTimes = new int[N + 1];
            for (int j = 1; j < N + 1; j++) {
                buildTimes[j] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer>[] graph = new ArrayList[N + 1];
            int[] inDegree = new int[N + 1];
            int[] dp = new int[N + 1];

            for (int j = 0; j < N + 1; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                inDegree[v]++;
            }

            int target = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();

            for (int j = 1; j < N + 1; j++) {
                dp[j] = buildTimes[j];
                if (inDegree[j] == 0) {
                    q.add(j);
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int next : graph[cur]) {
                    dp[next] = Math.max(dp[next], dp[cur] + buildTimes[next]);
                    inDegree[next]--;

                    if (inDegree[next] == 0) {
                        q.add(next);
                    }
                }
            }

            bw.write(dp[target] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
