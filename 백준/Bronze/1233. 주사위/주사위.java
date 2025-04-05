import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S1 = Integer.parseInt(st.nextToken());
        int S2 = Integer.parseInt(st.nextToken());
        int S3 = Integer.parseInt(st.nextToken());

        int[] frequency = new int[S1 + S2 + S3 + 1];

        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    frequency[i + j + k]++;
                }
            }
        }

        int answer = -1;
        int max = -1;
        for (int i = 3; i < frequency.length; i++) {
            if (frequency[i] > max) {
                max = frequency[i];
                answer = i;
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

}