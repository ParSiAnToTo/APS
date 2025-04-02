import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int j = N; j <= M; j++) {
                String num = String.valueOf(j);
                for (int k = 0; k < num.length(); k++) {
                    if (num.charAt(k) == '0') {
                        count++;
                    }
                }
            }

            bw.write(Integer.toString(count));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

}