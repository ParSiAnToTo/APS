import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        HashSet<String> set = new HashSet<>(S.length() * (S.length() + 1) / 2);

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 0; j <= S.length() - i; j++) {
                set.add(S.substring(j, j + i));
            }
        }
        sb.append(set.size());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    } // end of main

} // end of class