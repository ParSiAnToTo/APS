import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] boxArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];


        int maxLength = 1;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (boxArr[i] < boxArr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (maxLength < dp[i]) {
                maxLength = dp[i];
            }
        }

        bw.write(String.valueOf(maxLength));
        bw.flush();
        bw.close();
    }
}