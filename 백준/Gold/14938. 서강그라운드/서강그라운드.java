import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m, r;
    static int[] itemValue;
    static int[][] adj;

    static void FloydWarshall() {
        for (int stopOver = 1; stopOver <= n; stopOver++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    if (adj[start][end] > adj[start][stopOver] + adj[stopOver][end]) {
                        adj[start][end] = adj[start][stopOver] + adj[stopOver][end];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        itemValue = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            itemValue[i] = Integer.parseInt(st.nextToken());
        }

        adj = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(adj[i], 150001);
            adj[i][i] = 0;
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[a][b] = w;
            adj[b][a] = w;
        }

        FloydWarshall();

        int maxItemValue = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (adj[i][j] <= m) {
                    sum += itemValue[j];
                }
            }
            maxItemValue = Math.max(maxItemValue, sum);
        }
        
        bw.write(String.valueOf(maxItemValue));
        bw.flush();
        bw.close();
    }
}