import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int zRecursion(int size, int r, int c) {
        if (size == 0) {
            return 0;
        }
        int quadrantLength = (int) Math.pow(2, size - 1);
        int areaSize = quadrantLength * quadrantLength;

        if (r < quadrantLength && c < quadrantLength) {
            return zRecursion(size - 1, r, c);
        } else if (r < quadrantLength && c >= quadrantLength) {
            return areaSize + zRecursion(size - 1, r, c - quadrantLength);
        } else if (r >= quadrantLength && c < quadrantLength) {
            return areaSize * 2 + zRecursion(size - 1, r - quadrantLength, c);
        } else {
            return areaSize * 3 + zRecursion(size - 1, r - quadrantLength, c - quadrantLength);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int num = zRecursion(N, r, c);

        sb.append(num).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}