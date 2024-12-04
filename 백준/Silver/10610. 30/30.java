import java.io.*;

public class Main {

    static boolean isDiverse(int[] targetNumber, int diverse) {
        int reminder = 0;

        for (int i = 0; i < targetNumber.length; i++) {
            reminder = (reminder * 10 + targetNumber[i]) % diverse;
        }

        return reminder == 0;
    }

    static boolean permutation(int[] targetNumber) {
        int indexA = targetNumber.length - 2;
        while (indexA >= 0 && targetNumber[indexA] >= targetNumber[indexA + 1]) {
            indexA--;
        }
        if (indexA < 0) {
            return false;
        }

        int indexB = targetNumber.length - 1;
        while (targetNumber[indexB] >= targetNumber[indexA]) {
            indexB--;
        }

        int temp = targetNumber[indexB];
        targetNumber[indexB] = targetNumber[indexA];
        targetNumber[indexA] = temp;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();
        int diverse = 30;

        int[] targetNumber = N.chars()
                .map(c -> c - '0')
                .boxed()
                .sorted((a, b) -> b - a)
                .mapToInt(Integer::intValue)
                .toArray();


        boolean isFailed = false;
        while (true) {
            if (targetNumber[0] == 0) {
                isFailed = true;
                break;
            }

            if (isDiverse(targetNumber, diverse)) {
                for (int i = 0; i < targetNumber.length; i++) {
                    sb.append(targetNumber[i]);
                }
                break;
            }

            if (!permutation(targetNumber)) {
                isFailed = true;
                break;
            }
        }

        bw.write(isFailed ? "-1" : sb.toString());
        bw.flush();
        bw.close();
    }
}