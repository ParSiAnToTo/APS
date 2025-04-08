import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        outer: for (int i = N; i > 0; i--) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != '4' && s.charAt(j) != '7') {
                    continue outer;
                }
            }
            answer = i;
            break;
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}