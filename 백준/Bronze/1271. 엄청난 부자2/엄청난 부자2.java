import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String n = st.nextToken();
        String m = st.nextToken();

        BigInteger money = new BigInteger(n);
        BigInteger thing = new BigInteger(m);
        BigInteger quotient = money.divide(thing);
        BigInteger change = money.mod(thing);
        sb.append(quotient).append("\n").append(change);

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class