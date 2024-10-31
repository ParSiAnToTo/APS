import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] sequence = new int[n];
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = sequence[0];
        int curr = dp[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            curr = Math.max(sequence[i], curr + sequence[i]);
            max = Math.max(max, curr);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}