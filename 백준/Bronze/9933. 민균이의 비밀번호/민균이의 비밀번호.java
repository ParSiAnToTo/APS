import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashSet<String> passwordList = new HashSet<>(N);

        String password = null;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            String reverse = new StringBuilder(word).reverse().toString();
            if (word.equals(reverse) || passwordList.contains(reverse)) {
                password = word;
                break;
            }
            passwordList.add(word);
        }
        sb.append(password.length()).append(" ").append(password.charAt(password.length() / 2));


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}