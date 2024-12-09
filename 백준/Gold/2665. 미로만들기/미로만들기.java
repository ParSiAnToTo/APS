import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] adjArr;
    static int[][] dist;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static void dijk() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[2]));
        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curR = cur[0];
            int curC = cur[1];
            int curW = cur[2];

            if (curR == N - 1 && curC == N - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];
                if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                    int nw = curW + adjArr[nr][nc];
                    if (nw < dist[nr][nc]) {
                        dist[nr][nc] = nw;
                        pq.add(new int[]{nr, nc, nw});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        adjArr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                int w = line.charAt(j) - '0';
                adjArr[i][j] = w == 1 ? 0 : 1;
            }
        }

        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dijk();

        bw.write(String.valueOf(dist[N - 1][N - 1]));
        bw.flush();
        bw.close();
    }
}