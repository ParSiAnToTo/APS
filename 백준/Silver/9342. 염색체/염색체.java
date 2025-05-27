import java.io.*;

public class Main {

    static char[] ChromosomeList = {'A', 'B', 'C', 'D', 'E', 'F'};
    static int index;
    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        result = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String chromosome = br.readLine();
            if (chromosomeTest(chromosome)) {
                result.append("Infected!").append('\n');
            } else {
                result.append("Good").append('\n');
            }
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    private static boolean chromosomeTest(String chromosome) {
        index = chromosome.charAt(0) == 'A' ? 0 : 1;
        if (search(chromosome, 'A')) {
            if (search(chromosome, 'F')) {
                if (search(chromosome, 'C')) {
                    if (index <= chromosome.length() && lastWord(chromosome)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean search(String chromosome, char target) {
        int alphabetCount = 0;
        for (int i = index; i < chromosome.length(); i++) {
            if (chromosome.charAt(i) == target) {
                alphabetCount++;
                index++;
            } else {
                break;
            }
        }

        if (alphabetCount >= 1) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean lastWord(String chromosome) {
        if (chromosome.length() == index) {
            return true;
        } else {
            char target = chromosome.charAt(chromosome.length() - 1);
            for (int i = 0; i < ChromosomeList.length; i++) {
                if (target == ChromosomeList[i]) {
                    return true;
                }
            }
            return false;
        }
    }
}