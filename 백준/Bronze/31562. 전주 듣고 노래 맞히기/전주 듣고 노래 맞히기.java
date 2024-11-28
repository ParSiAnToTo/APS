import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> song = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String songName = st.nextToken();
            String code = st.nextToken() + st.nextToken() + st.nextToken();
            song.compute(code, (k, v) -> v != null ? "?" : songName);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String code = st.nextToken() + st.nextToken() + st.nextToken();
            sb.append(song.getOrDefault(code, "!")).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}