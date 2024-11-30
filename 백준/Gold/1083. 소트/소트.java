import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int swapCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < N && swapCount > 0; i++) {
            int maxIdx = i;

            for (int j = i + 1; j < N && j <= i + swapCount; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }

            for (int j = maxIdx; j > i; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                swapCount--;
            }

            if (swapCount == 0) {
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
