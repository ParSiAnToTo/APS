import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int startP = 1;
        int endP = 1;
        int sum = 1;
        int answer = 0;

        while (endP <= N) {
            if (sum == N) {
                answer++;
            }
            if (sum >= N) {
                sum -= startP;
                startP++;
            }
            if (sum < N) {
                endP++;
                sum += endP;
            }
        }

        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}