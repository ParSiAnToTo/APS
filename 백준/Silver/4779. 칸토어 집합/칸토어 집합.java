import java.io.*;

public class Main {

    static boolean[] line;

    static void cantorSet(int st, int ed, int depth) {
        if (depth == 0) {
            return;
        }
        int third = (ed - st) / 3;
        int thirdSt = st + third;
        int thirdEd = thirdSt + third;
        for (int i = thirdSt; i < thirdEd; i++) {
            line[i] = true;
        }
        cantorSet(st, thirdSt, depth - 1);
        cantorSet(thirdEd, ed, depth - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String N;
        while ((N = br.readLine()) != null && !N.isEmpty()) {
            int value = Integer.parseInt(N);
            int length = (int) Math.pow(3, value);
            line = new boolean[length];

            cantorSet(0, length, value);

            for (int i = 0; i < line.length; i++) {
                if (line[i]) {
                    sb.append(" ");
                } else {
                    sb.append("-");
                }
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}