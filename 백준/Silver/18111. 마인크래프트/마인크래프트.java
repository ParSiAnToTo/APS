import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int maxZ = -1;
        int minZ = 257;
        int[][] site = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int zValue = Integer.parseInt(st.nextToken());
                site[i][j] = zValue;
                maxZ = Math.max(maxZ, zValue);
                minZ = Math.min(minZ, zValue);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int targetZ = Integer.MIN_VALUE;
        for (int estimateZ = minZ; estimateZ <= maxZ; estimateZ++) {
            int removeCount = 0;
            int addCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int gap = site[i][j] - estimateZ;

                    if (gap > 0) {
                        removeCount += gap;
                    } else if (gap < 0) {
                        addCount -= gap;
                    }
                }
            }

            if (addCount > B + removeCount) {
                continue;
            }

            int time = removeCount * 2 + addCount;
            if (time < minTime || (time == minTime && estimateZ > targetZ)) {
                minTime = time;
                targetZ = estimateZ;
            }
        }

        sb.append(minTime).append(" ").append(targetZ);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}