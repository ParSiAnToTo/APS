import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        String targetS = null;
        String targetT = null;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < N - 1; i++) {
            String tempTargetS = list.get(i);
            for (int j = i + 1; j < N; j++) {
                String tempTargetT = list.get(j);
                int duplicateLength = 0;
                for (int k = 0; k < Math.min(tempTargetS.length(), tempTargetT.length()); k++) {
                    if (tempTargetS.charAt(k) == tempTargetT.charAt(k)) {
                        duplicateLength++;
                    } else {
                        break;
                    }
                }
                if (duplicateLength > maxLength) {
                    maxLength = duplicateLength;
                    targetS = tempTargetS;
                    targetT = tempTargetT;
                }
            }
        }

        bw.write(targetS + "\n" + targetT);
        bw.flush();
        bw.close();
    }
}