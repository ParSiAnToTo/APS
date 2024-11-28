import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        String hashFunction = sc.next();


        BigInteger decode = BigInteger.ZERO;
        BigInteger key = BigInteger.valueOf(31);
        BigInteger pow = BigInteger.ONE;
        for (int i = 0; i < N; i++) {
            int x = hashFunction.charAt(i) - 'a' + 1;
            decode = decode.add(BigInteger.valueOf(x).multiply(pow));
            pow = pow.multiply(key);
        }

        bw.write(decode.toString());
        bw.flush();
        bw.close();
    }
}
