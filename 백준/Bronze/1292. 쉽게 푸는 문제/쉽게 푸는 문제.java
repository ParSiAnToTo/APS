import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        int num = 1;
        while(list.size() < B){
            for (int i = 0; i < num; i++) {
                list.add(num);
            }
            num++;
        }

        int answer = 0;
        for (int i = A-1; i < B; i++) {
            answer += list.get(i);
        }


        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }


}
