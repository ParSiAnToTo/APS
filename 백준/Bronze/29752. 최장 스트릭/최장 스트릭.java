import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxLength = 0;
        int cur = 0;
        for (int num : arr) {
            if (num != 0) {
                cur++;
                maxLength = Math.max(maxLength, cur);
            } else {
                cur = 0;
            }
        }

        bw.write(String.valueOf(maxLength));
        bw.flush();
        bw.close();
    }
}