import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static void bombSetup(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] < 0) {
                    board[i][j] = 4;
                }
            }
        }
    }

    private static void bombCount(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    board[i][j]--;
                }
            }
        }
    }

    private static void bombExplode(int[][] board) {
        ArrayList<int[]> targetList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    targetList.add(new int[]{i, j});
                }
            }
        }

        for (int[] target : targetList) {
            int i = target[0];
            int j = target[1];
            board[i][j] = -999;
            board[i - 1 >= 0 ? i - 1 : i][j] = -999;
            board[i + 1 < board.length ? i + 1 : i][j] = -999;
            board[i][j - 1 >= 0 ? j - 1 : j] = -999;
            board[i][j + 1 < board[i].length ? j + 1 : j] = -999;
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
            bombCount(board);
            bombExplode(board);
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