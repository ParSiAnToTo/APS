import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TestCase = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < TestCase; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            while (N > 2) {
                for (int j = 0; j < (N + 1) / 2; j++) {
                    arr[j] = arr[j] + arr[N - 1 - j];
                }
                N = (int) Math.ceil((double) N / 2);
            }

            String winner = arr[0] > arr[1] ? "Alice" : "Bob";
            result.append("Case #").append(i + 1).append(": ").append(winner).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}