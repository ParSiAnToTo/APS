import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean chk = false;
        for (int i = 0; i <= 30; i++) {
            if(N == Math.pow(2, i)){
                chk = true;
                break;
            }
        }

        bw.write(chk ? "1" : "0");
        bw.flush();
        bw.close();
    }
}