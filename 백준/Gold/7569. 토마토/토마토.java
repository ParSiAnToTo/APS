import java.io.*;
import java.util.*;

public class Main {

    static int M, N, H, tomatoCount;
    static int[][][] tomatoBox;
    static Queue<int[]> queue;
    static int[] dr = {0, 0, -1, 1, 0, 0};
    static int[] dc = {-1, 1, 0, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};


    static int bfs() {
        int sec = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tomato = queue.poll();

                for (int dir = 0; dir < 6; dir++) {
                    int nr = tomato[0] + dr[dir];
                    int nc = tomato[1] + dc[dir];
                    int nh = tomato[2] + dh[dir];
                    if (nr >= 0 && nr < M && nc >= 0 && nc < N && nh >= 0 && nh < H) {
                        if (tomatoBox[nr][nc][nh] == 0) {
                            tomatoBox[nr][nc][nh] = 1;
                            queue.add(new int[]{nr, nc, nh});
                        }
                    }
                }
            }
            sec++;
        }

        return sec;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoBox = new int[M][N][H];
        queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int tomatoStatus = Integer.parseInt(st.nextToken());
                    tomatoBox[k][j][i] = tomatoStatus;
                    if (tomatoStatus == 1) {
                        queue.add(new int[]{k, j, i});
                    }
                }
            }
        }

        int ripeTime = bfs();

        boolean chk = false;
        outer:
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomatoBox[k][j][i] == 0) {
                        chk = true;
                        break outer;
                    }
                }
            }
        }

        bw.write(String.valueOf(chk ? -1 : ripeTime - 1));
        bw.flush();
        bw.close();
    }
}