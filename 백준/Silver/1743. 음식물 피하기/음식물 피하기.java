import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] aisle;
    static boolean[][] checked;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M;

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        checked[r][c] = true;
        int size = 0;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            size++;
            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                if (nr > 0 && nr <= N && nc > 0 && nc <= M) {
                    if (!checked[nr][nc] && aisle[nr][nc]) {
                        checked[nr][nc] = true;
                        q.add(new Node(nr, nc));
                    }
                }
            }
        }

        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        aisle = new boolean[N + 1][M + 1];
        checked = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            aisle[r][c] = true;
        }

        int maximumSizeFood = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (aisle[i][j] && !checked[i][j]) {
                    int foodSize = bfs(i, j);
                    maximumSizeFood = Math.max(maximumSizeFood, foodSize);
                }
            }
        }
        sb.append(maximumSizeFood);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class