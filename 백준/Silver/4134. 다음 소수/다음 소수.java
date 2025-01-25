import java.io.*;

public class Main {

    static boolean isPrime(Long digit) {
        if (digit % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(digit); i += 2) {
            if (digit % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            Long digit = Long.parseLong(br.readLine());
            if (digit <= 2) {
                result.append(2).append("\n");
                continue;
            }
            while (true) {
                if (isPrime(digit)) {
                    result.append(digit).append("\n");
                    break;
                } else {
                    digit++;
                }
            }
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
