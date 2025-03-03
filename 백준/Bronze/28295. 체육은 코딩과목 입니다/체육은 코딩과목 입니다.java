import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ways = {"N", "E", "S", "W"};

        int way = 0;
        for(int i = 0; i < 10; i++){
            int t = Integer.parseInt(br.readLine());
            way += t;
            way %= 4;
        }

        bw.write(ways[way]);
        bw.flush();
        bw.close();
    }
}