import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String docs = br.readLine();
        String sentence = br.readLine();


        int count = 0;
        for (int i = 0; ; i++) {
            if (docs.length() >= sentence.length() + i) {
                if (docs.substring(i, i + sentence.length()).equals(sentence)) {
                    count++;
                    i += sentence.length() - 1;
                }
            } else {
                break;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}