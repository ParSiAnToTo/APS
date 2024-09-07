import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[10][N + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = 1;
        }

        if (N >= 2) {
            for (int i = 2; i < N + 1; i++) {
                for (int j = 0; j < 10; j++) {
                    if (j > 0) {
                        dp[j][i] += dp[j - 1][i - 1];
                    }
                    if (j < 9) {
                        dp[j][i] += dp[j + 1][i - 1];
                    }
                    dp[j][i] = dp[j][i] % 1000000000;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[i][N];
            answer = answer % 1000000000;
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class