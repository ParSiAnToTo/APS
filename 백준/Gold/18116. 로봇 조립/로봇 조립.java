import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] p, s;

    static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            if (s[px] < s[py]) {
                p[px] = py;
                s[py] += s[px];
            } else {
                p[py] = px;
                s[px] += s[py];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        p = new int[1000001];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }

        s = new int[1000001];
        for (int i = 0; i < s.length; i++) {
            s[i] = 1;
        }

        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if (input.equals("I")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else if (input.equals("Q")) {
                int x = Integer.parseInt(st.nextToken());
                result.append(s[find(x)]).append("\n");
            }
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
