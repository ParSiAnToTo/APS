import java.io.*;
import java.util.*;

public class Main {

    static int[] tempNum = new int[9];
    static boolean[] base = new boolean[4];
    static int[][] team;
    static boolean[] chk = new boolean[9];
    static int inning, maxResult, gameResult, hit, batIndex, outCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        inning = Integer.parseInt(st.nextToken());

        team = new int[inning][9];
        for (int i = 0; i < inning; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] number = new int[]{2, 3, 4, 5, 6, 7, 8, 9};
        tempNum = new int[9];
        chk = new boolean[9];
        dfs(number, 0);

        bw.write(String.valueOf(maxResult));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int[] arr, int depth) {
        if (depth == 9) {
            maxResult = Math.max(playGame(tempNum, team), maxResult);
            return;
        }
        if (depth == 3) {
            tempNum[depth] = 1;
            dfs(arr, depth + 1);
        }

        for (int i = 0; i < 8; i++) {
            if (!chk[i]) {
                chk[i] = true;
                tempNum[depth] = arr[i];
                dfs(arr, depth + 1);
                chk[i] = false;
            }
        }
    }

    public static int playGame(int[] arr, int[][] team) {
        gameResult = 0;
        batIndex = 0;
        outCount = 0;
        for (int i = 0; i < inning; i++) {
            outCount = 0;
            while (true) {
                hit = team[i][arr[batIndex % 9] - 1];

                if (hit == 0) {
                    outCount++;
                } else if (hit == 4) {
                    for (int j = 0; j < 4; j++) {
                        if (base[j]) {
                            gameResult++;
                            base[j] = false;
                        }
                    }
                    gameResult++;
                } else {
                    for (int j = 3; j > 0; j--) {
                        if (base[j]) {
                            if (j + hit > 3) {
                                base[j] = false;
                                gameResult++;
                            } else {
                                base[j] = false;
                                base[j + hit] = true;
                            }
                        }
                    }
                    base[hit] = true;
                }

                batIndex++;
                if (outCount == 3) {
                    for (int j = 0; j < 4; j++) {
                        base[j] = false;
                    }
                    break;
                }
            } // ith inning
        }
        return gameResult;
    }
}