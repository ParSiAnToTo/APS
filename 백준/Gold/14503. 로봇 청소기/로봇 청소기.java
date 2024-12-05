import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M, cleanCount;
    static int[][] room;
    static boolean[][] cleaned;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static void robotActivate(int startRow, int startCol, int startDir) {
        while (true) {
            if (!cleaned[startRow][startCol]) {
                cleaned[startRow][startCol] = true;
                cleanCount++;
            }

            boolean isMoved = false;
            for (int i = 0; i < 4; i++) {
                int nd = (startDir + 3) % 4;
                int nr = startRow + dr[nd];
                int nc = startCol + dc[nd];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && room[nr][nc] == 0 && !cleaned[nr][nc]) {
                    startRow = nr;
                    startCol = nc;
                    startDir = nd;
                    isMoved = true;
                    break;
                }
                startDir = nd;
            }

            if (!isMoved) {
                int backDir = (startDir + 2) % 4;
                int nr = startRow + dr[backDir];
                int nc = startCol + dc[backDir];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && room[nr][nc] == 0) {
                    startRow = nr;
                    startCol = nc;
                } else {
                    break;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startRow = Integer.parseInt(st.nextToken());
        int startCol = Integer.parseInt(st.nextToken());
        int startDir = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        cleaned = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleanCount = 0;
        robotActivate(startRow, startCol, startDir);

        bw.write(String.valueOf(cleanCount));
        bw.flush();
        bw.close();
    }
}