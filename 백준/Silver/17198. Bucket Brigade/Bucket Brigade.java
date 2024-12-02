import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] farm;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int bfs(int lakeR, int lakeC, int barnR, int barnC) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{lakeR, lakeC, 0});
        farm[lakeR][lakeC] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if (r == barnR && c == barnC) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < 10 && nc >= 0 && nc < 10) {
                    if (!farm[nr][nc]) {
                        farm[nr][nc] = true;
                        q.add(new int[]{nr, nc, dist + 1});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        farm = new boolean[10][10];
        int barnR = 0, barnC = 0, lakeR = 0, lakeC = 0;

        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                char c = line.charAt(j);
                if (c == 'B') {
                    barnR = i;
                    barnC = j;
                } else if (c == 'L') {
                    lakeR = i;
                    lakeC = j;
                } else if (c == 'R') {
                    farm[i][j] = true;
                }
            }
        }

        int bucketBrigadeLength = bfs(lakeR, lakeC, barnR, barnC) -1;

        bw.write(String.valueOf(bucketBrigadeLength));
        bw.flush();
        bw.close();
    }
}