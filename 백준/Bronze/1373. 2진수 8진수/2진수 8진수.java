import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        BigInteger num = new BigInteger(input, 2);
        String oct = num.toString(8);
        bw.write(oct);
        bw.flush();
        bw.close();
    }
}
