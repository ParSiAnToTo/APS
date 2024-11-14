import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = dp[3] = 2;
        for (int i = 4; i < dp.length; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i - 1] + dp[i / 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
