import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String bestUniv = null;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                String UnivName = st.nextToken();
                int alcohol = Integer.parseInt(st.nextToken());
                if (alcohol > max) {
                    max = alcohol;
                    bestUniv = UnivName;
                }
            }
            sb.append(bestUniv).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
