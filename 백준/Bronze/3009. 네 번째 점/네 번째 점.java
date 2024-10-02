import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> rowList = new ArrayList<>();
        ArrayList<Integer> colList = new ArrayList<>();

        int duplicatedRow = 0;
        int duplicatedCol = 0;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(!rowList.contains(r)){
                rowList.add(r);
            } else {
                duplicatedRow = r;
            }
            if(!colList.contains(c)){
                colList.add(c);
            } else {
                duplicatedCol = c;
            }
        }

        int r = 0;
        int c = 0;
        Collections.sort(rowList);
        Collections.sort(colList);

        for (int i : rowList) {
            if(i != duplicatedRow){
                r = i;
            }
        }
        for (int i : colList) {
            if(i != duplicatedCol){
                c = i;
            }
        }

        sb.append(r).append(" ").append(c);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}