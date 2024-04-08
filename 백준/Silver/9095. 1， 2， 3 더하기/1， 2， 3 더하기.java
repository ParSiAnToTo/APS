import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int[] dp = new int[12];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for (int i = 4; i < 12; i++) {
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        while(T!=0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            bw.write(dp[n] + "\n");
            T--;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}