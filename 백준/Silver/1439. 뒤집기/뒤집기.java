import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        int countZero = 0;
        int countOne = 0;
        int prev = -1;
        for (int i = 0; i < S.length(); i++) {
            int cur = S.charAt(i) - '0';
            if (cur == 0 && prev != 0) {
                countZero++;
                prev = 0;
            } else if (cur == 1 && prev != 1) {
                countOne++;
                prev = 1;
            }
        }

        int answer = Math.min(countZero, countOne);
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}