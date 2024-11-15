import java.io.*;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        br.close();
        int len = s.length();
        HashSet<String> set = new HashSet<>(len * (len + 1) / 2);

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= len - i; j++) {
                set.add(s.substring(j, j + i));
            }
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }
}
