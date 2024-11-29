import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static HashSet<Integer> set = new HashSet<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] numberBoard = new int[5][5];

    static class Jump {
        int r; // row index
        int c; // column index
        int sixDigit;
        int moveCounter;

        public Jump(int r, int c, int sixDigit, int moveCounter) {
            this.r = r;
            this.c = c;
            this.sixDigit = sixDigit;
            this.moveCounter = moveCounter;
        }
    }

    static void bfs(int r, int c) {
        Queue<Jump> q = new ArrayDeque<>();
        q.add(new Jump(r, c, numberBoard[r][c], 0));
        while (!q.isEmpty()) {
            Jump current = q.poll();
            if (current.moveCounter == 5) { // end of move
                set.add(current.sixDigit);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];
                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5) { // 4-way search
                    int newDigit = current.sixDigit * 10 + numberBoard[nr][nc];
                    q.add(new Jump(nr, nc, newDigit, current.moveCounter + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                numberBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bfs(i, j);
            }
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }
}