import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String A = br.readLine();
        String B = br.readLine();

        BigInteger plus = new BigInteger(A).add(new BigInteger(B));
        BigInteger minus = new BigInteger(A).subtract(new BigInteger(B));
        BigInteger multiply = new BigInteger(A).multiply(new BigInteger(B));

        sb.append(plus).append("\n").append(minus).append("\n").append(multiply);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
