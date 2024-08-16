import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    static int minCount = 65;

    static int checker(int i, int j, String[][] board) {
        int wCount = 0;
        int bCount = 0;
        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
                if ((k + l) % 2 == 0) {
                    wCount += board[k][l].equals("W") ? 0 : 1;
                    bCount += board[k][l].equals("B") ? 0 : 1;
                } else {
                    wCount += board[k][l].equals("B") ? 0 : 1;
                    bCount += board[k][l].equals("W") ? 0 : 1;
                }
            }
        }
        return Math.min(wCount, bCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[][] board = new String[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minCount = Math.min(minCount, checker(i, j, board));
            }
        }

        sb.append(minCount);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    } // end of main

} // end of class