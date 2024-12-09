import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] dist;

    private static void FloydWarshall() {
        for (int stopOver = 1; stopOver < N + 1; stopOver++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (dist[i][stopOver] != Integer.MAX_VALUE && dist[stopOver][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][stopOver] + dist[stopOver][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dist = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) {
                break;
            }
            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        FloydWarshall();

        int maxPoint = Integer.MAX_VALUE;

        int[] scores = new int[N + 1];
        Arrays.fill(scores, 0);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] != Integer.MAX_VALUE) {
                    scores[i] = Math.max(scores[i], dist[i][j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            maxPoint = Math.min(maxPoint, scores[i]);
        }

        int candidateNumber = 0;
        StringBuilder candidatesString = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (scores[i] == maxPoint) {
                candidateNumber++;
                candidatesString.append(i).append(" ");
            }
        }

        bw.write(String.format("%d %d\n", maxPoint, candidateNumber));
        bw.write(candidatesString.toString());
        bw.flush();
        bw.close();
    }
}