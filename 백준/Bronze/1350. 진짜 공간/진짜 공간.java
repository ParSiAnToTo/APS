import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[] fileList = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fileList[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0;
        long clusterSize = Long.parseLong(br.readLine());
        for(long file : fileList) {
            if(file == 0) continue;
            answer += file <= clusterSize ? clusterSize :
            file % clusterSize == 0 ? file : (file / clusterSize + 1) * clusterSize;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}