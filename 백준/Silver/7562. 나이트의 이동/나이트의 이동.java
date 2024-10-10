import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
    static boolean[][] visited;

    static class Knight {
        int r;
        int c;

        public Knight(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int bfs(int len, int targetRow, int targetCol, int knightRow, int knightCol) {
        Queue<Knight> q = new LinkedList<>();
        visited = new boolean[len][len];
        q.add(new Knight(knightRow, knightCol));
        visited[knightRow][knightCol] = true;
        int moveCount = 0;

        outer:
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Knight cur = q.poll();
                if (cur.r == targetRow && cur.c == targetCol) {
                    break outer;
                }

                for (int j = 0; j < 8; j++) {
                    int nr = cur.r + dr[j];
                    int nc = cur.c + dc[j];
                    if (verification(nr, nc)) {
                        visited[nr][nc] = true;
                        q.add(new Knight(nr, nc));
                    }
                }
            }
            moveCount++;
        }

        return moveCount;
    }

    static boolean verification(int row, int col) {
        if (row >= 0 && row < visited.length && col >= 0 && col < visited.length && !visited[row][col]) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int targetRow = Integer.parseInt(st.nextToken());
            int targetCol = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int knightRow = Integer.parseInt(st.nextToken());
            int knightCol = Integer.parseInt(st.nextToken());
            sb.append(bfs(len, targetRow, targetCol, knightRow, knightCol)).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}