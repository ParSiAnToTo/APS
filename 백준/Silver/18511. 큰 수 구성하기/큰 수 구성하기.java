import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K, len;
    static int[] kArr;
    static int maxValue;

    static void dfs(int digit, int depth) {
        if (digit > N) {
            return;
        }

        maxValue = Math.max(maxValue, digit);

        if (depth == len) {
            return;
        }

        for (int i = 0; i < K; i++) {
            dfs(digit * 10 + kArr[i], depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String strN = st.nextToken();
        N = Integer.parseInt(strN);
        len = strN.length();
        K = Integer.parseInt(st.nextToken());
        kArr = new int[K];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            kArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(kArr);

        dfs(0, 0);

        bw.write(String.valueOf(maxValue));
        bw.flush();
        bw.close();
    }
}