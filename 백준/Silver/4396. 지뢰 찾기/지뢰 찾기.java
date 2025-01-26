import java.io.*;

public class Main {

    static int n;
    static int[] dr = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dc = {0, 1, 0, -1, 1, -1, -1, 1};
    static boolean[][] mine;

    static int mineChecker(int i, int j) {
        int count = 0;
        for (int k = 0; k < 8; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                if (mine[nr][nc]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        mine = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '*') {
                    mine[i][j] = true;
                }
            }
        }

        String[][] gameBoard = new String[n][n];
        boolean isActivated = false;
        for (int i = 0; i < n; i++) {
            String printLine = br.readLine();
            for (int j = 0; j < printLine.length(); j++) {
                if (printLine.charAt(j) == 'x') {
                    if (mine[i][j]) {
                        isActivated = true;
                    }
                    gameBoard[i][j] = String.valueOf(mineChecker(i, j));
                } else {
                    gameBoard[i][j] = ".";
                }
            }
        }

        if (isActivated) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mine[i][j]) {
                        gameBoard[i][j] = "*";
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.append(gameBoard[i][j]);
            }
            result.append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
