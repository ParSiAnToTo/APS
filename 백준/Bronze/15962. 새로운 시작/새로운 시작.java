import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        sb.append("파이팅!!");

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class