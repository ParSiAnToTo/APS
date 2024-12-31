import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int sum = N * (N + 1) / 2;
        int sumSquare = sum * sum;
        long squaredSum = 0;
        for (int i = 1; i <= N; i++) {
            squaredSum += (long) i * i * i;
        }
        sb.append(sum).append("\n")
                .append(sumSquare).append("\n")
                .append(squaredSum).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
