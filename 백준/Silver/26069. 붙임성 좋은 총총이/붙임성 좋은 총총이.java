import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>(N + 1);
        set.add("ChongChong");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String personA = st.nextToken();
            String personB = st.nextToken();
            if (set.contains(personA)) {
                set.add(personB);
            } else if (set.contains(personB)) {
                set.add(personA);
            }
        }

        int count = set.size();
        sb.append(count);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}