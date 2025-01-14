import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, cost;
    static int[][] city;
    static boolean[] visited;

    static void tps(int start, int cur, int depth, int curCost) {
        if (depth == N - 1) {
            if (city[cur][start] != 0) {
                cost = Math.min(cost, curCost + city[cur][start]);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && city[cur][i] != 0) {
                visited[i] = true;
                tps(start, i, depth + 1, curCost + city[cur][i]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        city = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cost = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            tps(i, i, 0, 0);
            visited[i] = false;
        }

        bw.write(String.valueOf(cost));
        bw.flush();
        bw.close();
    }
}
