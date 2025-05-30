import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] resist = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

        int f = 0;
        int s = 0;
        int m = 0;

        for (int i = 0; i < 3; i++) {
            String color = br.readLine();
            for (int j = 0; j < 10; j++) {
                if (color.equals(resist[j])) {
                    if (i == 0) {
                        f = j;
                    } else if (i == 1) {
                        s = j;
                    } else {
                        m = j;
                        break;
                    }
                }
            }
        }

        long answer = (f * 10 + s) * (long) Math.pow(10, m);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}