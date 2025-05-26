import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 1, -1};

    private static void bombSetup(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] < 0) {
                    board[i][j] = 4;
                }
            }
        }
    }

    private static void bombCount(int[][] board, boolean[][] isExplode) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    board[i][j]--;
                }
            }
        }
    }

    private static void bombExplode(int[][] board, boolean[][] isExplode) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    isExplode[i][j] = true;
                }
            }
        }
        for (int i = 0; i < isExplode.length; i++) {
            for (int j = 0; j < isExplode[i].length; j++) {
                if (isExplode[i][j]) {
                    for (int k = 0; k < 5; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[i].length) {
                            board[nr][nc] = -999;
                        }
                    }
                    isExplode[i][j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] board = new int[R][C];
        boolean[][] isExplode = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char status = line.charAt(j);
                board[i][j] = status == '.' ? -999 : 3;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) {
                bombSetup(board);
            }
            bombCount(board, isExplode);
            bombExplode(board, isExplode);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] > 0) {
                    result.append('O');
                } else {
                    result.append('.');
                }
            }
            result.append('\n');
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}