import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        int len = S.length();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String suffix = S.substring(i, len);
            list.add(suffix);
        }

        Collections.sort(list);
        
        for (String word : list) {
            sb.append(word).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class