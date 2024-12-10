import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> nicknameMap = new HashMap<>();
        HashSet<String> nicknameSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String nicknameInput = br.readLine();
            nicknameMap.compute(nicknameInput, (k, v) -> v == null ? 1 : v + 1);

            boolean isNew = false;
            for (int j = 1; j <= nicknameInput.length(); j++) {
                String prefix = nicknameInput.substring(0, j);
                if (nicknameSet.add(prefix) && !isNew) {
                    isNew = true;
                    sb.append(prefix).append("\n");
                }
            }

            if (!isNew) {
                sb.append(nicknameInput).append(nicknameMap.get(nicknameInput) == 1 ? "" : nicknameMap.get(nicknameInput)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}