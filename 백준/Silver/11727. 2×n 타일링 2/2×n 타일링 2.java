import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 2];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        if (n > 2) {
            for (int i = 3; i < n + 1; i++) {
                dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
            }
        }

        sb.append(dp[n]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class