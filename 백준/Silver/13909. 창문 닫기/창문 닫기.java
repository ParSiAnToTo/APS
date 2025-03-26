import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int sqrt = (int) Math.floor(Math.sqrt(N));

        bw.write(Integer.toString(sqrt));
        bw.flush();
        bw.close();
    }

}