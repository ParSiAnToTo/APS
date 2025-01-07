import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        String input;

        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);

            if (st.countTokens() < 2) {
                break;
            }

            String s = st.nextToken();
            String t = st.nextToken();

            int index = 0;
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) == s.charAt(index)) {
                    index++;
                }
                if (index == s.length()) {
                    break;
                }
            }

            if (index == s.length()) {
                result.append("Yes");
            } else {
                result.append("No");
            }
            result.append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
