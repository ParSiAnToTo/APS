import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] freqArr = new int[8001];
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            freqArr[4000 + value]++;
        }

        int mean = 0;
        int median = 0;
        int mode = 0;
        int range = 0;

        int sum = 0;
        for (int i = 0; i < freqArr.length; i++) {
            sum += freqArr[i] * (i - 4000);
        }
        mean = (int) Math.round((double) sum / N);

        int count = 0;
        for (int i = 0; i < freqArr.length; i++) {
            count += freqArr[i];
            if (count >= 1 + N / 2) {
                median = i - 4000;
                break;
            }
        }

        int freq = 0;
        boolean dupChk = false;
        for (int i = 0; i < freqArr.length; i++) {
            if (freq < freqArr[i]) {
                freq = freqArr[i];
                mode = i - 4000;
                dupChk = true;
            } else if (freq == freqArr[i] && dupChk) {
                mode = i - 4000;
                dupChk = false;
            }
        }

        int minRange = 0;
        int maxRange = 0;
        for (int i = 0; i < freqArr.length; i++) {
            if (freqArr[i] > 0) {
                minRange = i - 4000;
                break;
            }
        }

        for (int i = 8000; i >= 0; i--) {
            if (freqArr[i] > 0) {
                maxRange = i - 4000;
                break;
            }
        }

        range = maxRange - minRange;

        sb.append(mean).append(" ").append(median).append(" ").append(mode).append(" ").append(range).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}