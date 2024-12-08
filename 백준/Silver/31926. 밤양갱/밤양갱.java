import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int firstInit = 8;
        int lastInit = 2;

        int count;
        if (N == 1) {
            count = firstInit + lastInit;
        } else {
            long sum = 0;
            int len = 0;
            for (int i = 0; i <= 30; i++) {
                sum += (1 << i);
                if (N <= sum) {
                    len = i;
                    break;
                }
            }
            count = firstInit + len + lastInit;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}