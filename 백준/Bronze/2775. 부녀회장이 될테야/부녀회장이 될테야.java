import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        int[][] mension = new int[15][15];
        for (int i = 1; i < mension[0].length; i++) {
            mension[0][i] = mension[0][i - 1] + i;
        }

        for (int i = 1; i < mension.length; i++) {
            for (int j = 1; j < mension[i].length; j++) {
                for (int k = 0; k <= j; k++) {
                    mension[i][j] += mension[i - 1][k];
                }
            }
        }

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(mension[k - 1][n]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    } // end of main

} // end of class