import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = (int) Math.sqrt(M); i <= (int) Math.sqrt(N); i++) {
            int perfect = (int) Math.pow(i, 2);
            if (perfect >= M && perfect <= N) {
                list.add(perfect);
            }
        }
        
        Collections.sort(list);
        int sum = 0;
        for (int i : list) {
            sum += i;
        }

        if (list.isEmpty()) {
            bw.write("-1");
        } else {
            bw.write(Integer.toString(sum));
            bw.newLine();
            bw.write(Integer.toString(list.get(0)));
        }

        bw.flush();
        bw.close();
    }

}