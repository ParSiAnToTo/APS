import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());


        if (K + X - 1 < A || K - X + 1 > B) {
            bw.write("IMPOSSIBLE");
        } else {
            int count = 0;
            int left = Math.max(A, K - X);
            int right = Math.min(B, K + X);

            if (left <= right) {
                count = right - left + 1;
            }
            bw.write(String.valueOf(count));
        }

        bw.flush();
        bw.close();
    }
}
