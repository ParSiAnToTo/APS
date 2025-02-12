import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        String[][] map = new String[R][C];
        String[][] newMap = new String[R][C];


        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                String s = String.valueOf(input.charAt(j));
                map[i][j] = s;
                newMap[i][j] = s;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j].equals("X")) {
                    int count = 4;

                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc].equals("X")) {
                            count--;
                        }
                    }

                    if (count > 2) {
                        newMap[i][j] = ".";
                    }
                }
            }
        }

        int minR = R;
        int minC = C;
        int maxR = -1;
        int maxC = -1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (newMap[i][j].equals("X")) {
                    minR = Math.min(minR, i);
                    minC = Math.min(minC, j);
                    maxR = Math.max(maxR, i);
                    maxC = Math.max(maxC, j);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                result.append(newMap[i][j]);
            }
            result.append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
