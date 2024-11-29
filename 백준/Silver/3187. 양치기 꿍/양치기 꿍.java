import java.io.*;
import java.util.StringTokenizer;

public class Main {

    /*상하좌우 이동, 울타리인지, 방문하였는지*/

    static boolean[][] visited;
    static char[][] field;
    static int sheepCount;
    static int wolfCount;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    static void dfs(int x, int y) {
        visited[x][y] = true;
        if (field[x][y] == 'k') {
            sheepCount++;
        } else if (field[x][y] == 'v') {
            wolfCount++;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < field.length && ny >= 0 && ny < field[nx].length && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        field = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = line.charAt(j);
                field[i][j] = c;
                if (c == '#') {
                    visited[i][j] = true;
                }
            }
        }

        int sheepCnt = 0;
        int wolfCnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j]) {

                    dfs(i, j);
                    if (sheepCount > wolfCount) {
                        sheepCnt += sheepCount;
                    } else {
                        wolfCnt += wolfCount;
                    }

                    sheepCount = 0;
                    wolfCount = 0;
                }
            }
        }

        sb.append(sheepCnt).append(" ").append(wolfCnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}