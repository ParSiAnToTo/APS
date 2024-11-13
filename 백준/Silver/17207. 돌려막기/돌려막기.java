import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[][] difficulty = new int[5][5];
        int[][] processingTime = new int[5][5];
        int[] estimatedWork = new int[5];
        String[] names = {"Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"};

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                difficulty[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                processingTime[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int sumOfDiffProcess = 0;
                for (int k = 0; k < 5; k++) {
                    sumOfDiffProcess += difficulty[i][k] * processingTime[k][j];
                }
                estimatedWork[i] += sumOfDiffProcess;
            }
        }

        String mostAvailablePerson = "";
        int min = Integer.MAX_VALUE;
        for (int i = 4; i >= 0; i--) {
            if (estimatedWork[i] < min) {
                min = estimatedWork[i];
                mostAvailablePerson = names[i];
            }
        }

        sb.append(mostAvailablePerson);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}