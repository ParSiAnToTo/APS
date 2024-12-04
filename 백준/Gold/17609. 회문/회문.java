import java.io.*;

public class Main {

    static int isPalin(String sentence) {
        int a = 0, b = sentence.length() - 1;
        while (a < b) {
            if (sentence.charAt(a) != sentence.charAt(b)) {
                if (isSubPalin(sentence, a + 1, b) || isSubPalin(sentence, a, b-1)) {
                    return 1;
                } else {
                    return 2;
                }
            }
            a++;
            b--;
        }
        return 0;
    }

    static boolean isSubPalin(String sentence, int a, int b) {
        while (a < b) {
            if (sentence.charAt(a) != sentence.charAt(b)) {
                return false;
            }
            a++;
            b--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String sentence = br.readLine();
            sb.append(isPalin(sentence)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}