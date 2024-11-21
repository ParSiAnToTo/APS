import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        for (int i = 0; i < 5; i++) {
            int point =  Integer.parseInt(br.readLine());
            if (point < 40) {
                point = 40;
            }
            answer += point;
        }

        bw.write(String.valueOf(answer/5));
        bw.flush();
        bw.close();
    }
}
