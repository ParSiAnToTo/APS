import java.io.*;
import java.util.*;

public class Main {

    static int[] p;

    static int findSet(int x) {
        if (p[x] != x) {
            p[x] = findSet(p[x]);
        }
        return p[x];
    }

    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if (px != py) {
            p[px] = py;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        p = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            p[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (command == 1) {
                if (findSet(a) != findSet(b)) {
                    sb.append("NO").append("\n");
                } else {
                    sb.append("YES").append("\n");
                }
            } else {
                union(a, b);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
