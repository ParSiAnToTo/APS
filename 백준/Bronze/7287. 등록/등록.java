import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        sb.append("367").append("\n").append("choi_baek_j");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}