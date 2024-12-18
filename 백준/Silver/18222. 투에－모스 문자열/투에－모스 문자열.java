import java.io.*;

public class Main {

    public static int divideAndConquer(Long target) {
        int result = 0;
        Long midIndex = 1L;

        while (target > 1) {
            while (target > midIndex) {
                midIndex *= 2;
            }
            midIndex /= 2;

            if (target > midIndex) {
                result = 1 - result;
                target -= midIndex;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Long k = Long.parseLong(br.readLine());
        int answer = divideAndConquer(k);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
