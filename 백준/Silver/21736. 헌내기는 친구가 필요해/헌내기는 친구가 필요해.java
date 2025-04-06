import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, count;
    static int[][] campus;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new int[N][M];
        count = 0;
        int r = 0;
        int c = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = line.charAt(j);
                if (ch == 'O') {
                    campus[i][j] = 0;
                } else if (ch == 'X') {
                    campus[i][j] = -1;
                } else if (ch == 'I') {
                    campus[i][j] = 99999999;
                    r = i;
                    c = j;
                } else if (ch == 'P') {
                    campus[i][j] = 1;
                }
            }
        }

        bfs(r, c);

        bw.write(count == 0 ? "TT" : Integer.toString(count));
        bw.flush();
        bw.close();
    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (campus[cur[0]][cur[1]] == 1) {
                count++;
            }
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && campus[nr][nc] != -1) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

}