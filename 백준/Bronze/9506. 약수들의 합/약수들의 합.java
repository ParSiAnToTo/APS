import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n != -1) {
            ArrayList<Integer> divisor = new ArrayList<>();
            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    divisor.add(i);
                }
            }
            int sum = 0;
            for (int i : divisor) {
                sum += i;
            }

            sb.append(n).append(" ");
            if (sum == n) {
                sb.append("= ");
                for (int i = 0; i < divisor.size(); i++) {
                    if (i != divisor.size() - 1) {
                        sb.append(divisor.get(i)).append(" + ");
                    } else {
                        sb.append(divisor.get(i));
                    }
                }
            } else {
                sb.append("is NOT perfect.");
            }

            sb.append("\n");
            n = Integer.parseInt(br.readLine());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class