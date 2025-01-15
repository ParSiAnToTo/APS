import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int countB = 0;
        int countD = 0;
        int index = 0;
        int roundNumber = 1;
        int roundIndex = 0;
        int answer = 0;

        while (true) {
            if (roundIndex < 4 && roundIndex % 2 == 0) {
                countB++;
                roundIndex++;
            } else if (roundIndex < 4 && roundIndex % 2 == 1) {
                countD++;
                roundIndex++;
            } else if (roundIndex < 4 + roundNumber + 1) {
                countB++;
                roundIndex++;
            } else if (roundIndex < 4 + (roundNumber + 1) * 2) {
                countD++;
                roundIndex++;
            }

            if (roundIndex == 4 + (roundNumber + 1) * 2) {
                roundIndex = 0;
                roundNumber++;
            }

            if ((target == 0 && countB == T) || (target == 1 && countD == T)) {
                answer = index % A;
                break;
            }
            index++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
