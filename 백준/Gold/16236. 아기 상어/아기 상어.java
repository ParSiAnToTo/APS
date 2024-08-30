import java.io.*;
import java.util.*;

public class Main {

    static int[][] space;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, size, huntCount, time;

    static class Node implements Comparable<Node> {
        int r;
        int c;
        int second;

        public Node(int r, int c, int second) {
            this.r = r;
            this.c = c;
            this.second = second;
        }

        @Override
        public int compareTo(Node o) {
            if (this.second != o.second) {
                return this.second - o.second;
            } else if (this.r != o.r) {
                return this.r - o.r;
            } else {
                return this.c - o.c;
            }
        }
    }

    static void hunting(int r, int c) {
        while (isAnyFish(space)) {
            Node next = findNextTarget(r, c);
            if (next == null) {
                break;
            }
            space[next.r][next.c] = 0;
            huntCount++;
            if (huntCount == size) {
                size++;
                huntCount = 0;
            }
            r = next.r;
            c = next.c;
            time += next.second;
        }
    }

    static boolean isAnyFish(int[][] space) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (space[i][j] < size && space[i][j] > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static Node findNextTarget(int r, int c) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        q.add(new Node(r, c, 0));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (isValid(nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Node(nr, nc, now.second + 1));

                    if (space[nr][nc] < size && space[nr][nc] > 0) {
                        pq.add(new Node(nr, nc, now.second + 1));
                    }
                }
            }
        }

        return pq.isEmpty() ? null : pq.poll();
    }

    static boolean isValid(int nr, int nc) {
        if (nr >= 0 && nr < N && nc >= 0 && nc < N && space[nr][nc] <= size) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        space = new int[N][N];
        int startR = 0;
        int startC = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int state = Integer.parseInt(st.nextToken());
                if (state == 9) {
                    startR = i;
                    startC = j;
                    space[i][j] = 0;
                } else {
                    space[i][j] = state;
                }
            }
        }

        size = 2;
        huntCount = 0;
        hunting(startR, startC);
        sb.append(time);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class