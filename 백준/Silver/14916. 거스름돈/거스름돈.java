import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int count = 0;

        if (N % 5 == 0) {
            count = N / 5;
        } else {
            if (N < 5) {
                if (N % 2 != 0) {
                    count = -1;
                } else {
                    count = N / 2;
                }
            } else {
                int modFive = N % 5;
                if ((modFive) % 2 != 0) {
                    count = (N / 5 - 1) + ((modFive + 5) / 2);
                } else {
                    count = (N / 5) + (modFive / 2);
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}