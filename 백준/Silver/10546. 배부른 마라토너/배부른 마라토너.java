import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String entry = br.readLine();
            map.put(entry, map.getOrDefault(entry, 0) + 1);
        }

        for (int i = 0; i < N-1; i++) {
            String finish = br.readLine();
            map.compute(finish, (k, v) -> v - 1);
        }

        StringBuilder result = new StringBuilder();
        for (String s : map.keySet()) {
            if(map.get(s) > 0) {
                result.append(s).append("\n");
            }
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
