import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int point = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int isCollect = Integer.parseInt(st.nextToken());
            if (isCollect == 1) {
                sum += point;
                point++;
            } else {
                point = 1;
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
