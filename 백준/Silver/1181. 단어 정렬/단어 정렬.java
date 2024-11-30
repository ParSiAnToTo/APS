import java.io.*;
import java.util.*;

public class Main {

    static class sentence implements Comparable<sentence> {
        int len;
        String word;

        public sentence(int len, String word) {
            this.len = len;
            this.word = word;
        }

        @Override
        public int compareTo(sentence o) {
            if (this.len != o.len) {
                return this.len - o.len;
            } else {
                return this.word.compareTo(o.word);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        TreeSet<sentence> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            set.add(new sentence(word.length(), word));
        }

        for (sentence s : set) {
            sb.append(s.word).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
