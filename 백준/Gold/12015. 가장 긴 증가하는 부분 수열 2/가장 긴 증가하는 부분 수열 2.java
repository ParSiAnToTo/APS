import java.io.*;
import java.util.*;

public class Main {

    static int lowerBound(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] sequence = new int[N];
        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (list.isEmpty() || sequence[i] > list.get(list.size() - 1)) {
                list.add(sequence[i]);
            } else {
                int index = lowerBound(list, sequence[i]);
                list.set(index, sequence[i]);
            }
        }

        bw.write(String.valueOf(list.size()));
        bw.flush();
        bw.close();
    }
}