import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean flag = false;
        for (int i = 1; i < 6; i++) {
            String name = br.readLine();
            if(name.contains("FBI")){
                flag = true;
                bw.write(i + " ");
            }
        }

        if(!flag){
            bw.write("HE GOT AWAY!");
        }

        bw.flush();
        bw.close();
    }
}
