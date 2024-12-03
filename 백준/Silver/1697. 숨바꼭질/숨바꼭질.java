import java.io.*;
import java.util.*;

public class Main {

    private static int findYou(int n, int m) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        int time = 0;
        q.add(n);
        visited[n] = true;
        if (n == m) {
            return time;
        }

        outer:
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == m) {
                    break outer;
                }
                if (cur + 1 >= 0 && cur + 1 < 100001 && !visited[cur + 1]) {
                    q.add(cur + 1);
                    visited[cur + 1] = true;
                }
                if (cur - 1 >= 0 && cur - 1 < 100001 && !visited[cur - 1]) {
                    q.add(cur - 1);
                    visited[cur - 1] = true;
                }
                if (cur * 2 >= 0 && cur * 2 < 100001 && !visited[cur * 2]) {
                    q.add(cur * 2);
                    visited[cur * 2] = true;
                }
            }
            time++;
        }
        return time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int sec = findYou(N, M);

        bw.write(String.valueOf(sec));
        bw.flush();
        bw.close();
    }
}