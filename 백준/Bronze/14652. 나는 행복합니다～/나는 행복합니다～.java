import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        outer: for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(k == 0){
                    bw.write(String.valueOf(i));
                    bw.write(" ");
                    bw.write(String.valueOf(j));
                    break outer;
                }
                k--;
            }
        }


        bw.flush();
        bw.close();
    }
}
