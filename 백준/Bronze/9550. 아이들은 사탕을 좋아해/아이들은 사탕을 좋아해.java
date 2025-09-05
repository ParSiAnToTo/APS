import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int partyCount = 0;
        for (int j = 0; j < N; j++) {
            int candy = Integer.parseInt(st.nextToken());
            partyCount += candy/K;
        }
        sb.append(partyCount).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}