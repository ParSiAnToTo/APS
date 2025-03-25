import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double R = Double.parseDouble(br.readLine());
        double uc = Math.pow(R, 2) * Math.PI;
        double tax = Math.pow(R, 2) * 2;
        
        bw.write(String.format("%.6f", uc));
        bw.newLine();
        bw.write(String.format("%.6f", tax));
        bw.flush();
        bw.close();
    }

}