import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] count;
    static int[][] paper;

    static void recursion(int size, int r, int c) {
        if (areaColorCheck(size, r, c)) {
            count[paper[r][c]]++;
            return;
        }

        int nextSize = size / 2;
        recursion(nextSize, r, c);
        recursion(nextSize, r + nextSize, c);
        recursion(nextSize, r, c + nextSize);
        recursion(nextSize, r + nextSize, c + nextSize);

    }

    static boolean areaColorCheck(int size, int r, int c) {
        int startColor = paper[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (paper[i][j] != startColor) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = new int[2];
        recursion(N, 0, 0);

        result.append(count[0]).append("\n").append(count[1]);

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}