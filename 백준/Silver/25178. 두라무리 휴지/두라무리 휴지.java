import java.io.*;
import java.util.*;

public class Main {

    static boolean duramuriEffect(String a, String b, int n) {

        int[] charA = new int[26];
        int[] charB = new int[26];
        for (int i = 0; i < n; i++) {
            charA[a.charAt(i) - 'a']++;
            charB[b.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (charA[i] != charB[i]) {
                return false;
            }
        }

        if (!(a.charAt(0) == b.charAt(0) && a.charAt(n - 1) == b.charAt(n - 1))) {
            return false;
        }

        String[] vowels = new String[]{"a", "e", "i", "o", "u"};
        for (int i = 0; i < vowels.length; i++) {
            a = a.replace(vowels[i], "");
            b = b.replace(vowels[i], "");
        }
        if (!a.equals(b)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String A = br.readLine();
        String B = br.readLine();

        boolean chk = duramuriEffect(A, B, N);

        bw.write(chk ? "YES" : "NO");
        bw.flush();
        bw.close();
    }
}