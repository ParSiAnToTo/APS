import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                int len = s.length();
                for (int j = len - 1; j >= 0; j--) {
                    result.append(s.charAt(j));
                }
                result.append(' ');
            }
            result.append('\n');
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}