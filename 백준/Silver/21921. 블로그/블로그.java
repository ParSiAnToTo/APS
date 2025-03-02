import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long subSum = Arrays.stream(arr, 0, X).sum();
        long max = subSum;

        int left = 0;
        int right = X - 1;
        int count = 1;

        while (right + 1 < N) {
            left++;
            right++;
            subSum -= arr[left - 1];
            subSum += arr[right];

            if (max < subSum) {
                max = subSum;
                count = 1;
            } else if (max == subSum) {
                count++;
            }
        }

        if (max == 0) {
            bw.write("SAD");
        } else {
            bw.write(String.valueOf(max));
            bw.newLine();
            bw.write(String.valueOf(count));
        }

        bw.flush();
        bw.close();
    }
}