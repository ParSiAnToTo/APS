import java.io.*;
import java.util.*;

public class Main {

    static int maxR = -10001;
    static int minR = 10001;
    static int maxC = -10001;
    static int minC = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (r > maxR) {
                maxR = r;
            }
            if (r < minR) {
                minR = r;
            }
            if (c > maxC) {
                maxC = c;
            }
            if (c < minC) {
                minC = c;
            }
        }

        int answer = (maxR - minR) * (maxC - minC);
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class