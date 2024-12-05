import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int voltex(int r, int c) {
        int level = Math.max(Math.abs(r), Math.abs(c));
        int levelDefaultValue = (2 * level + 1) * (2 * level + 1);
        int offsetValue;

        if (r == level) {
            offsetValue = level - c;
        } else if (c == -level) {
            offsetValue = (2 * level) + (level - r);
        } else if (r == -level) {
            offsetValue = (4 * level) + (c + level);
        } else {
            offsetValue = (6 * level) + (r + level);
        }

        return levelDefaultValue - offsetValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int rowLen = r2 - r1 + 1;
        int colLen = c2 - c1 + 1;
        int[][] field = new int[rowLen][colLen];
        int maxDigits = 0;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int r = r1 + i;
                int c = c1 + j;
                field[i][j] = voltex(r, c);
                maxDigits = Math.max(maxDigits, field[i][j]);
            }
        }

        int maxDigitLength = String.valueOf(maxDigits).length();

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                sb.append(String.format("%" + maxDigitLength + "d ", field[i][j]));
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}