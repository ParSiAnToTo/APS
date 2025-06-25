import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            arr[i] = height;
            if (max < height) {
                max = height;
                left++;
            }
        }

        bw.write(String.valueOf(left));
        bw.newLine();

        max = Integer.MIN_VALUE;
        for (int i = N - 1; i >= 0; i--) {
            if (max < arr[i]) {
                max = arr[i];
                right++;
            }
        }

        bw.write(String.valueOf(right));
        bw.flush();
        bw.close();
    }
}