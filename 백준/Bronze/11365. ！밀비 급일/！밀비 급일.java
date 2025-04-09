import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        String s;
        while(!(s = br.readLine()).equals("END")) {
            StringBuilder decode = new StringBuilder(s).reverse();
            result.append(decode).append("\n");
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}