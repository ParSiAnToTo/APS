import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        boolean[] checked = new boolean[N + 1];

        int num = 0;
        int count = 0;
        int c;

        while ((c = br.read()) != -1) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == ' ' | c == '\n') {
                if (checked[num]) {
                    bw.write(String.valueOf(num));
                    break;
                } else {
                    checked[num] = true;
                    num = 0;
                    count++;
                    if (count == N) break;
                }
            }
        }

        bw.flush();
        bw.close();
    }
}