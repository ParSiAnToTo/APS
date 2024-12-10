import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    static int[] result;
    static boolean[] checked;

    static void combination(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!checked[i]) {
                checked[i] = true;
                result[depth] = nums[i];
                combination(depth + 1);
                checked[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        checked = new boolean[N + 1];
        nums = new int[N + 1];
        result = new int[M];
        for (int i = 1; i <= N; i++) {
            nums[i] = i;
        }

        combination(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}