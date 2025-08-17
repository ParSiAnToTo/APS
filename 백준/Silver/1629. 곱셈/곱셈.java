import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int answer = iterative(A, B, C);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    private static int iterative(int a, int b, int c) {
        if (c == 1) return 0;
        long alpha = a % c;
        long beta = 1 % c;
        int exp = b;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                beta = (beta * alpha) % c;
            }
            alpha = (alpha * alpha) % c;
            exp >>= 1;
        }

        return (int) beta;
    }
}