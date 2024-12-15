import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> pokeDictIdx = new HashMap<>();
        HashMap<String, Integer> pokeDictName = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String pokemon = br.readLine();
            pokeDictIdx.put(i, pokemon);
            pokeDictName.put(pokemon, i);
        }
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if(input.charAt(0) - '0' >= 17){
                sb.append(pokeDictName.get(input)).append("\n");
            } else {
                sb.append(pokeDictIdx.get(Integer.parseInt(input))).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}