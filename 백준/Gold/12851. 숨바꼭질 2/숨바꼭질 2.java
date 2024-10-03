import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int max = 100000;
    static int min = 0;
    static int N, K, second, count;
    static int[] time = new int[max + 1];

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();        
        q.add(start);
        time[start] = 0;        
        boolean flag = false;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();

                if (now == K) {
                    count++;
                    flag = true;
                } else {
                    int next = time[now] + 1;
                    if (now - 1 >= min && (time[now - 1] == 0 || time[now - 1] == next)) {
                        q.add(now - 1);
                        time[now - 1] = next;
                    }
                    if (now + 1 <= max && (time[now + 1] == 0 || time[now + 1] == next)) {
                        q.add(now + 1);
                        time[now + 1] = next;
                    }
                    if (now * 2 <= max && (time[now * 2] == 0 || time[now * 2] == next)) {
                        q.add(now * 2);
                        time[now * 2] = next;
                    }
                }
            }
            if (flag) {
                break;
            }
            second++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K <= N) {
            sb.append(N - K).append("\n").append(1);
        } else {
            bfs(N);
            sb.append(second).append("\n").append(count);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}