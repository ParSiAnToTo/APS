import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // <= 100
        int M = Integer.parseInt(st.nextToken()); // <= 50

        int minimalPackagePrice = 1001; // init
        int minimalSinglePrice = 1001; // init
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int packagePrice = Integer.parseInt(st.nextToken()); // six amount price, 0 <= 1000
            int singlePrice = Integer.parseInt(st.nextToken()); // one amount price, 0 <= 1000
            // minimalPrice Update
            minimalPackagePrice = Math.min(minimalPackagePrice, packagePrice);
            minimalSinglePrice = Math.min(minimalSinglePrice, singlePrice);
        }

        int packOnly = minimalPackagePrice * (N / 6 + (N % 6 != 0 ? 1 : 0));
        int packAndSingle = minimalPackagePrice * (N / 6) + minimalSinglePrice * (N % 6);
        int singleOnly = minimalSinglePrice * N;

        int minimalPrice = Math.min(packOnly, Math.min(packAndSingle, singleOnly));        
        bw.write(String.valueOf(minimalPrice));
        bw.flush();
        bw.close();
    }
}