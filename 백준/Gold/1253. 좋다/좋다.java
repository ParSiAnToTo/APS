import java.io.*;
import java.util.*;

public class Main {

    static int answer = 0;
    static int N;
    static int[] arr;

    private static void findPairs(int target, int index) {
        int left = 0;
        int right = N - 1;

        while (left < right) {
            if (left == index) {
                left++;
                continue;
            }
            if (right == index) {
                right--;
                continue;
            }
            
            int sum = arr[left] + arr[right];

            if (sum == target) {
                answer++;
                return;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;

        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int target = arr[i];
            findPairs(target, i);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
