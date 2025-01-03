import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[][] adjArr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adjArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int stopOver = 0; stopOver < N; stopOver++) {
            for (int start = 0; start < N; start++) {
                for (int end = 0; end < N; end++) {
                    if (adjArr[start][stopOver] == 1 && adjArr[stopOver][end] == 1) {
                        adjArr[start][end] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(adjArr[i][j]).append(' ');
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
