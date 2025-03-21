import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 7; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num % 2 == 0) {
                    sum += num;
                    min = Math.min(min, num);
                }
            }
            
            sb.append(sum).append(' ').append(min).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}