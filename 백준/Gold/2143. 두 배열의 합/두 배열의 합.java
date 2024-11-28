import java.io.*;
import java.util.*;

public class Main {

    static HashMap<Integer, Integer> combSubSum(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = arr[j] - (i > 0 ? arr[i - 1] : 0);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return map;
    }

    static int[] inputArray(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        if (len > 1) {
            for (int i = 1; i < len; i++) {
                arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] arrA = inputArray(br);
        int[] arrB = inputArray(br);

        HashMap<Integer, Integer> subSumA = combSubSum(arrA);
        HashMap<Integer, Integer> subSumB = combSubSum(arrB);

        Long count = 0L;
        for (Map.Entry<Integer, Integer> entry : subSumA.entrySet()) {
            int lack = T - entry.getKey();
            count += (long) entry.getValue() * subSumB.getOrDefault(lack, 0);
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}