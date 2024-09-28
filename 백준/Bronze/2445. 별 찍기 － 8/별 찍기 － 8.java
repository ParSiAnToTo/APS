import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < 2 * N; i++) {
            String line;
            if(i <= N){
                line = "*".repeat(i) + " ".repeat(2 * (N - i)) + "*".repeat(i);
            } else {
                line = "*".repeat(2 * N - i) + " ".repeat(2 * (i - N)) + "*".repeat(2 * N - i);
            }
            sb.append(line).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}