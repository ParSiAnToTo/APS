import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(st.nextToken());

        int[][] lines = new int[6][2];
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        int maxHeight = 0;
        int maxWidth = 0;
        for (int i = 0; i < 6; i++) {
            if (lines[i][0] < 3) {
                maxWidth = Math.max(maxWidth, lines[i][1]);
            } else {
                maxHeight = Math.max(maxHeight, lines[i][1]);
            }
        }

        int largeArea = maxWidth * maxHeight;
        int amountOfMelon = 0;

        for (int i = 0; i < 6; i++) {
            if (lines[i % 6][0] == 3 && lines[(i + 1) % 6][0] == 2) {
                amountOfMelon = K * (largeArea - lines[i % 6][1] * lines[(i + 1) % 6][1]);
                break;
            } else if (lines[i % 6][0] == 2 && lines[(i + 1) % 6][0] == 4) {
                amountOfMelon = K * (largeArea - lines[i % 6][1] * lines[(i + 1) % 6][1]);
                break;
            } else if (lines[i % 6][0] == 4 && lines[(i + 1) % 6][0] == 1) {
                amountOfMelon = K * (largeArea - lines[i % 6][1] * lines[(i + 1) % 6][1]);
                break;
            } else if (lines[i % 6][0] == 1 && lines[(i + 1) % 6][0] == 3) {
                amountOfMelon = K * (largeArea - lines[i % 6][1] * lines[(i + 1) % 6][1]);
                break;
            }
        }
        
        sb.append(amountOfMelon);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}