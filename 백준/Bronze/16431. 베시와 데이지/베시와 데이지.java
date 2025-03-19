import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] cor = new int[3][2];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                cor[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int bessie = Math.max(Math.abs(cor[0][0] - cor[2][0]), Math.abs(cor[0][1] - cor[2][1]));
        int daisy = Math.abs(cor[1][0] - cor[2][0]) + Math.abs(cor[1][1] - cor[2][1]);

        String answer = bessie > daisy ? "daisy" : bessie == daisy ? "tie" : "bessie";

        bw.write(answer);
        bw.flush();
        bw.close();
    }

}