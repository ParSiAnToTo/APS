import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String line;
            line = " ".repeat(N - i) + "* ".repeat(i);
            sb.append(line).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}