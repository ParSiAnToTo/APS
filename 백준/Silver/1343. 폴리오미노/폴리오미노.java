import java.io.*;

public class Main {

    static String polioA = "AAAA";
    static String polioB = "BB";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int xlen = 0;
        boolean chk = true;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '.' && chk) {
                sb.append('.');
            } else if (input.charAt(i) == '.' && !chk) {
                if (xlen % 2 != 0) {
                    bw.write("-1");
                    bw.flush();
                    bw.close();
                    System.exit(0);
                }

                for (int j = 0; j < xlen; ) {
                    if (xlen - j >= 4) {
                        sb.append(polioA);
                        j += 4;
                    } else {
                        sb.append(polioB);
                        j += 2;
                    }
                }
                xlen = 0;
                sb.append('.');
                chk = true;

            } else {
                xlen++;
                chk = false;
            }
        }

        if (xlen % 2 != 0) {
            bw.write("-1");
            bw.flush();
            bw.close();
            System.exit(0);
        }

        for (int j = 0; j < xlen; ) {
            if (xlen - j >= 4) {
                sb.append(polioA);
                j += 4;
            } else {
                sb.append(polioB);
                j += 2;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
