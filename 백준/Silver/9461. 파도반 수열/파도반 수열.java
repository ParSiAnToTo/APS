import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Long[] dp = new Long[101];
        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        for (int i = 3; i <= 100; i++) {
            dp[i] = dp[i - 3] + dp[i - 2];
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}