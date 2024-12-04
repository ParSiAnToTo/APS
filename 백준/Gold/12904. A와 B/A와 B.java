import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String T = br.readLine();
        int count = T.length() - S.length();

        for (int i = 0; i < count; i++) {
            if (T.charAt(T.length() - 1) == 'A') {
                T = T.substring(0, T.length() - 1);
            } else {
                T = T.substring(0, T.length() - 1);
                T = new StringBuilder(T).reverse().toString();
            }
        }

        bw.write(S.equals(T) ? "1" : "0");
        bw.flush();
        bw.close();
    }
}