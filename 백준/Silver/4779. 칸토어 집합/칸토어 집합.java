import java.io.*;

public class Main {

    static void cantorSet(int st, int ed, StringBuilder line, int depth) {
        if (depth == 0) {
            return;
        }
        int third = (ed - st) / 3;
        int thirdSt = st + third;
        int thirdEd = thirdSt + third;
        for (int i = thirdSt; i < thirdEd; i++) {
            line.setCharAt(i, ' ');
        }
        cantorSet(st, thirdSt, line, depth - 1);
        cantorSet(thirdEd, ed, line, depth - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String N;
        while ((N = br.readLine()) != null && !N.isEmpty()) {
            int value = Integer.parseInt(N);
            int length = (int) Math.pow(3, value);
            StringBuilder line = new StringBuilder("-".repeat(length));
            cantorSet(0, length, line, value);
            sb.append(line).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}