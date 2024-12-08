import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String[] cardArray = br.readLine().split(" ");

            char[] cards = new char[N];
            for (int j = 0; j < N; j++) {
                cards[j] = cardArray[j].charAt(0);
            }

            ArrayDeque<Character> createString = new ArrayDeque<>();
            createString.addFirst(cards[0]);
            for (int j = 1; j < N; j++) {
                if (cards[j] <= createString.peekFirst()) {
                    createString.addFirst(cards[j]);
                } else {
                    createString.addLast(cards[j]);
                }
            }

            while (!createString.isEmpty()) {
                sb.append(createString.pollFirst());
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}