import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int digit = Integer.parseInt(st.nextToken());
            arr[i] = digit;
            sum += digit;
        }

        long answer = 0;
        for (int i = 0; i < n - 1; i++) {
            sum -= arr[i];
            answer += arr[i] * sum;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
