import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int R, C, sheepCount, wolfCount;
    static char[][] field;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void sheepAndWolfCheck(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        int subSheepCount = 0;
        int subWolfCount = 0;

        q.add(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (field[cur[0]][cur[1]] == 'v') {
                subWolfCount++;
            } else if (field[cur[0]][cur[1]] == 'k') {
                subSheepCount++;
            }

            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + dr[k];
                int nc = cur[1] + dc[k];
                if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }

        if (subSheepCount > subWolfCount) {
            sheepCount += subSheepCount;
        } else {
            wolfCount += subWolfCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        field = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char type = line.charAt(j);
                field[i][j] = type;
                if (type == '#') {
                    visited[i][j] = true;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j]) {
                    sheepAndWolfCheck(i, j);
                }
            }
        }

        sb.append(sheepCount).append(" ").append(wolfCount);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}