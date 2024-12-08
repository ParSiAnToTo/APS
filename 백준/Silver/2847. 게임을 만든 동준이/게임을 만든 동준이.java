import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] levels = new int[N];
        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        int minusCount = 0;
        for (int i = N - 1; i > 0; i--) {
            int currentLevelPoint = levels[i];
            while (currentLevelPoint <= levels[i - 1]) {
                levels[i - 1]--;
                minusCount++;
            }
        }

        bw.write(String.valueOf(minusCount));
        bw.flush();
        bw.close();
    }
}