import java.io.*;
import java.util.HashSet;

public class Main {

    static int n, k;
    static String[] cards;
    static HashSet<String> set;
    static boolean[] picked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        cards = new String[n];
        picked = new boolean[n];
        set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            cards[i] = br.readLine();
        }

        cardPick(0, "");

        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }

    private static void cardPick(int depth, String card) {
        if (depth == k) {
            set.add(card);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!picked[i]) {
                picked[i] = true;
                cardPick(depth + 1, card + cards[i]);
                picked[i] = false;
            }
        }
    }
}