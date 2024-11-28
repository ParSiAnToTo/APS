import java.io.*;
import java.util.*;

public class Main {

    static HashMap<Integer, Integer> combSubSum(ArrayList<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int sum = arr.get(j) - (i > 0 ? arr.get(i - 1) : 0);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return map;
    }

    static ArrayList<Integer> inputArray(BufferedReader br) throws IOException {
        int len = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr.add(Integer.parseInt(st.nextToken()));
        if (len > 1) {
            for (int i = 1; i < len; i++) {
                arr.add(arr.get(i - 1) + Integer.parseInt(st.nextToken()));
            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrA = inputArray(br);
        ArrayList<Integer> arrB = inputArray(br);

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