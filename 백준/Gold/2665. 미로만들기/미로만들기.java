import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    /*
     * n x n 모양의 방
     * 검은 방 1 흰방 0
     * 검은 방은 입장 불가, 흰방끼리 통행 가능
     * 0,0 -> n-1, n-1
     * 이 루트로 갈 때 검은 방을 방문하는 최소 수는?
     *
     *
     * */
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return this.count - o.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] rooms = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                rooms[i][j] = line.charAt(j) - '0';
            }
        }

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.x == -1 && cur.y == -1) {
                break;
            }

            if (dist[cur.x][cur.y] < cur.count) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dr[i];
                int nextY = cur.y + dc[i];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                    continue;
                }
                int nextCount = cur.count;
                if (rooms[nextX][nextY] == 0) {
                    nextCount++;
                }
                if (dist[nextX][nextY] > nextCount) {
                    dist[nextX][nextY] = nextCount;
                    pq.offer(new Node(nextX, nextY, nextCount));
                }
            }
        }

        int answer = dist[n-1][n-1];

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}