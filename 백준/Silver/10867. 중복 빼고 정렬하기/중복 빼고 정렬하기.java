import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (list.isEmpty() || !list.contains(num)) {
                list.add(num);
            }
        }

        Collections.sort(list);

        for (int number : list) {
            sb.append(number).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}