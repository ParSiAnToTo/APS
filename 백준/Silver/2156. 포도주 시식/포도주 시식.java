import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            sb.append(wine[0]);
        } else if (n == 2) {
            sb.append(wine[0] + wine[1]);
        } else {
            dp[0] = wine[0];
            dp[1] = wine[0] + wine[1];
            dp[2] = Math.max(wine[0] + wine[1], Math.max(wine[0] + wine[2], wine[1] + wine[2]));
            if (n > 3) {
                for (int i = 3; i < n; i++) {
                    dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
                }
            }
            sb.append(dp[n - 1]);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}