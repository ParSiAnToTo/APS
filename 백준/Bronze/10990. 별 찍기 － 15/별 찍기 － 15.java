import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        String line;
        for (int i = 0; i < N; i++) {
            line = " ".repeat(N - i - 1) + "*";
            if (i > 0) {
                line += " ".repeat(2 * i - 1) + "*";
            }
            sb.append(line).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}