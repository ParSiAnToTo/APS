import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] bingo = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[] answerList = new int[25];
        for (int i = 0; i < 5; i++) {
            String[] answer = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                answerList[i * 5 + j] = Integer.parseInt(answer[j]);
            }
        }

        for (int i = 0; i < 25; i++) {
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (bingo[r][c] == answerList[i]) {
                        bingo[r][c] = 0;
                    }
                }
            }

            int lineCount = 0;
            //row check
            outer:
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if (bingo[r][c] != 0) {
                        continue outer;
                    }
                }
                lineCount++;
            }

            //col check
            outer:
            for (int c = 0; c < 5; c++) {
                for (int r = 0; r < 5; r++) {
                    if (bingo[r][c] != 0) {
                        continue outer;
                    }
                }
                lineCount++;
            }

            for (int idx = 0; idx < 5; idx++) {
                if (bingo[idx][idx] != 0) {
                    break;
                } else if (idx == 4) {
                    lineCount++;
                }
            }

            for (int idx = 0; idx < 5; idx++) {
                if (bingo[idx][4 - idx] != 0) {
                    break;
                } else if (idx == 4) {
                    lineCount++;
                }
            }

            if (lineCount >= 3) {
                bw.write(String.valueOf(i + 1));
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}