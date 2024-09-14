import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[][] rgbPrice = new int[3][N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgbPrice[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[3][N + 1];
        dp[0][1] = rgbPrice[0][1];
        dp[1][1] = rgbPrice[1][1];
        dp[2][1] = rgbPrice[2][1];

        for (int i = 2; i < N + 1; i++) {
            dp[0][i] = Math.min(dp[1][i - 1], dp[2][i - 1]) + rgbPrice[0][i];
            dp[1][i] = Math.min(dp[0][i - 1], dp[2][i - 1]) + rgbPrice[1][i];
            dp[2][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + rgbPrice[2][i];
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            answer = Math.min(dp[i][N], answer);
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class