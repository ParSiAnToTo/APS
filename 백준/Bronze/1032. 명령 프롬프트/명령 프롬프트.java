import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Character> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            for (int j = 0; j < name.length(); j++) {
                if (!map.containsKey(j)) {
                    map.put(j, name.charAt(j));
                } else if (!map.get(j).equals(name.charAt(j))) {
                    map.put(j, '?');
                }
            }
        }

        for (char c : map.values()) {
            sb.append(c);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}