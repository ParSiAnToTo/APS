import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] list;
    static int[] visitList;

    private static void tree(int st, int ed, int depth) {
        if (st > ed) {
            return;
        }
        int mid = (st + ed) / 2;
        list[depth].add(visitList[mid]);

        // left call
        tree(st, mid - 1, depth + 1);
        // right call
        tree(mid + 1, ed, depth + 1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(st.nextToken());
        visitList = new int[(int) Math.pow(2, K) - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < visitList.length; i++) { // visit data array
            visitList[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList[K];
        for (int i = 0; i < K; i++) { // tree init
            list[i] = new ArrayList<>();
        }

        tree(0, visitList.length - 1, 0);

        for (List<Integer> depthLine : list) {
            for (int node : depthLine) {
                sb.append(node).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}