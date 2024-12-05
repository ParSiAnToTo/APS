import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] studentInfo = new int[N][5];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int grade = 0; grade < 5; grade++) {
                studentInfo[i][grade] = Integer.parseInt(st.nextToken());
            }
        }

        int[] count = new int[N];
        for (int student = 0; student < N; student++) {
            for (int other = 0; other < N; other++) {
                if (student == other) {
                    continue;
                }
                for (int grade = 0; grade < 5; grade++) {
                    if (studentInfo[student][grade] == studentInfo[other][grade]) {
                        count[student]++;
                        break;
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int reader = 0;
        for (int student = 0; student < N; student++) {
            if (count[student] > max) {
                max = count[student];
                reader = student + 1;
            }
        }

        bw.write(String.valueOf(reader));
        bw.flush();
        bw.close();
    }
}