import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        String input = br.readLine();
        while (!input.equals("end")) {
            char[] line = input.toCharArray();

            boolean containsVowel = false;
            for (char c : line) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    containsVowel = true;
                    break;
                }
            }

            boolean isNotTriple = true;
            if (line.length > 2) {
                for (int i = 2; i < line.length; i++) {
                    int vCount = 0;
                    int cCount = 0;
                    for (int j = i - 2; j <= i; j++) {
                        if (line[j] == 'a' || line[j] == 'e' || line[j] == 'i' || line[j] == 'o' || line[j] == 'u') {
                            vCount++;
                        } else {
                            cCount++;
                        }
                    }
                    if (vCount == 3 || cCount == 3) {
                        isNotTriple = false;
                        break;
                    }
                }
            }

            boolean isNotEqual = true;
            if (line.length > 1) {
                for (int i = 1; i < line.length; i++) {
                    char target = line[i];
                    if(target == 'e' || target == 'o'){
                        continue;
                    }
                    if (target == line[i - 1]) {
                        isNotEqual = false;
                        break;
                    }
                }
            }

            if(containsVowel && isNotTriple && isNotEqual) {
                result.append('<').append(input).append("> is acceptable.");
            } else {
                result.append('<').append(input).append("> is not acceptable.");
            }
            result.append('\n');

            input = br.readLine();
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
