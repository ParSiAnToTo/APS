import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static String[][] keyboard = new String[][]
            {{"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"},
                    {"a", "s", "d", "f", "g", "h", "j", "k", "l", " "},
                    {"z", "x", "c", "v", "b", "n", "m", " ", " ", " "}};

    static int[] findPosition(String word) {
        int[] position = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if (keyboard[i][j].equals(word)) {
                    position[0] = i;
                    position[1] = j;
                }
            }
        }
        return position;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String firstFingerPosition = st.nextToken();
        String secondFingerPosition = st.nextToken();
        String[] input = br.readLine().split("");

        int ffr = 0;
        int ffc = 0;
        int sfr = 0;
        int sfc = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                if (keyboard[i][j].equals(firstFingerPosition)) {
                    ffr = i;
                    ffc = j;
                }
                if (keyboard[i][j].equals(secondFingerPosition)) {
                    sfr = i;
                    sfc = j;
                }
            }
        }

        int second = 0;
        for (int i = 0; i < input.length; i++) {
            String word = input[i];
            int[] wordPosition = findPosition(word);
            if (wordPosition[1] >= 5 || wordPosition[0] == 2 && wordPosition[1] == 4) {
                second += Math.abs(sfr - wordPosition[0]) + Math.abs(sfc - wordPosition[1]);
                sfr = wordPosition[0];
                sfc = wordPosition[1];
            } else {
                second += Math.abs(ffr - wordPosition[0]) + Math.abs(ffc - wordPosition[1]);
                ffr = wordPosition[0];
                ffc = wordPosition[1];
            }
            second++;
        }

        bw.write(String.valueOf(second));
        bw.flush();
        bw.close();
    }
}
