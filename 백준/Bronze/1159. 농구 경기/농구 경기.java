import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] lineUp = new int[26];

        for (int i = 0; i < N; i++) {
            int spell = br.readLine().charAt(0) - 'a';
            lineUp[spell]++;
        }

        boolean flag = false;
        for (int i = 0; i < lineUp.length; i++) {
            if (lineUp[i] > 4) {
                sb.append((char) (i + 97));
                flag = true;
            }
        }

        if (!flag) {
            sb.append("PREDAJA");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}