import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] paper;
    static List<Integer> answerList;
    static Queue<Point> q = new LinkedList<>();

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void painting(int x0, int y0, int x1, int y1, boolean[][] paper) {
        for (int i = y0; i < y1; i++) {
            for (int j = x0; j < x1; j++) {
                paper[i][j] = true;
            }
        }
    }

    static void bfs(int i, int j) {
        int size = 0;
        int row = paper.length;
        int col = paper[0].length;
        q.add(new Point(i, j));
        while (!q.isEmpty()) {
            Point now = q.poll();
            size++;
            for (int k = 0; k < 4; k++) {
                int nr = now.r + dr[k];
                int nc = now.c + dc[k];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && !paper[nr][nc]) {
                    q.add(new Point(nr, nc));
                    paper[nr][nc] = true;
                }
            }
        }
        answerList.add(size);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        paper = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x0 = Integer.parseInt(st.nextToken());
            int y0 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            painting(x0, y0, x1, y1, paper);
        }

        answerList = new ArrayList<>();
        int areaCount = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!paper[i][j]) {
                    areaCount++;
                    paper[i][j] = true;
                    bfs(i, j);
                }
            }
        }

        Collections.sort(answerList);
        sb.append(areaCount).append("\n");
        for (int i : answerList) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    } // end of main

} // end of class