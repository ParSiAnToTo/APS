import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Long S = Long.parseLong(br.readLine());
        Long limit = (long) Math.sqrt(2 * S);
        Long sum = 0L;
        int count = 0;
        for (Long i = 1L; i <= limit + 1; i++) {
            sum += i;
            if (sum > S) {
                break;
            }
            count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}