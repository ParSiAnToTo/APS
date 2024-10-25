import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> ropes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            ropes.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(ropes, Collections.reverseOrder());

        int maxWeight = 0;
        for (int i = 0; i < N; i++) {
            maxWeight = Math.max(maxWeight, ropes.get(i) * (i + 1));
        }

        bw.write(String.valueOf(maxWeight));
        bw.flush();
        bw.close();
    }
}