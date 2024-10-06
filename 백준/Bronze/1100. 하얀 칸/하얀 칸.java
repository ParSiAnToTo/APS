import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int whiteChessPiece = 0;

        for (int i = 0; i < 8; i++) {
            char[] line = br.readLine().toCharArray();

            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    if (line[j] == 'F') {
                        whiteChessPiece++;
                    }
                } else if (i % 2 == 1 && j % 2 == 1) {
                    if (line[j] == 'F') {
                        whiteChessPiece++;
                    }
                }
            }
        }

        sb.append(whiteChessPiece);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}