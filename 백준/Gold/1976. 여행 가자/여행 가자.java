import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] p;

    private static int find(int x) {
        if (p[x] != x) {
            return p[x] = find(p[x]);
        }
        return p[x];
    }

    private static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            p[px] = py;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int isConnected = Integer.parseInt(st.nextToken());
                if (isConnected == 1) {
                    union(i, j);
                }
            }
        }

        int[] list = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        boolean chk = true;
        int root = find(list[0]);
        for (int i = 1; i < M; i++) {
            if (find(list[i]) != root) {
                chk = false;
                break;
            }
        }

        bw.write(chk ? "YES" : "NO");
        bw.flush();
        bw.close();
    }
}