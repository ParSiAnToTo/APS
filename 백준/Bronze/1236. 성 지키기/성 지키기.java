import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] isRowBlocked = new boolean[N];
        boolean[] isColBlocked = new boolean[M];

        for (int i = 0; i < N; i++) {
            String floor = br.readLine();
            for (int j = 0; j < M; j++) {
                if (floor.charAt(j) != '.') {
                    isRowBlocked[i] = true;
                    isColBlocked[j] = true;
                }
            }
        }

        int countR = 0;
        for (int i = 0; i < N; i++) {
            if (!isRowBlocked[i]) {
                countR++;
            }
        }

        int countC = 0;
        for (int i = 0; i < M; i++) {
            if (!isColBlocked[i]) {
                countC++;
            }
        }

        bw.write(String.valueOf(Math.max(countR, countC)));
        bw.flush();
        bw.close();
    }
}