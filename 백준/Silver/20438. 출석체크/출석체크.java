import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] sleep = new boolean[N + 3];
        boolean[] isChecked = new boolean[N + 3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            sleep[Integer.parseInt(st.nextToken())] = true;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int message = Integer.parseInt(st.nextToken());
            if (sleep[message]) {
                continue;
            }

            for (int j = message; j < N + 3; j += message) {
                if (sleep[j]) {
                    continue;
                }
                isChecked[j] = true;
            }
        }

        int[] prefixSum = new int[N + 3];
        for (int i = 3; i < N + 3; i++) {
            prefixSum[i] = prefixSum[i - 1] + (isChecked[i] ? 0 : 1);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int rangeSum = prefixSum[E] - prefixSum[S - 1];
            result.append(rangeSum).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
