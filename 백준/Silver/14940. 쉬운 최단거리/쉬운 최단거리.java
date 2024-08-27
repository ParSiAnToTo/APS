import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int n;
    static int m;

    static class Node {
        int r;
        int c;
        int len;

        public Node(int r, int c, int len) {
            this.r = r;
            this.c = c;
            this.len = len;
        }

    }

    private static void bfs(int startR, int startC) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startR, startC, 0));
        visited[startR][startC] = true;
        map[startR][startC] = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    map[nr][nc] = now.len + 1;
                    q.add(new Node(nr, nc, now.len + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        int startR = 0;
        int startC = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int land = Integer.parseInt(st.nextToken());
                if (land == 2) {
                    startR = i;
                    startC = j;
                } else if (land == 0) {
                    visited[i][j] = true;
                }
            }
        }

        bfs(startR, startC);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    sb.append(-1).append(" ");
                } else {
                    sb.append(map[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class