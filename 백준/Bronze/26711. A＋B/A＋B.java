import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger a = new BigInteger(br.readLine().trim());
        BigInteger b = new BigInteger(br.readLine().trim());
        BigInteger c = a.add(b);

        bw.write(String.valueOf(c));
        bw.flush();
        bw.close();
    }
}
