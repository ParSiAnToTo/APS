import java.io.*;
import java.util.*;

public class Main {

    static char[][] stars;

    static void drawing(int r, int c, int n, boolean isBlank) {
        if (isBlank) {
            for (int i = r; i < r + n; i++) {
                for (int j = c; j < c + n; j++) {
                    stars[i][j] = ' ';
                }
            }
            return;
        }

        if (n == 1) {
            stars[r][c] = '*';
            return;
        }

        int size = n / 3;
        int blankFinder = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                blankFinder++;
                if (blankFinder == 5) {
                    drawing(r + i * size, c + j * size, size, true);
                } else {
                    drawing(r + i * size, c + j * size, size, false);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        stars = new char[N][N];

        drawing(0, 0, N, false);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}