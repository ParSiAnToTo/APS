import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            while(st.hasMoreTokens()) {
                sum += Integer.parseInt(st.nextToken());
            }
            result.append(sum).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}