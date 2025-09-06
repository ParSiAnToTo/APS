import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while((s = br.readLine()) != null) {
            if(s.isEmpty()) break;
            s = s.replace("iiing", "th");
            bw.write(s);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}