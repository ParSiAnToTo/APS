import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] itemList = new int[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) { 
        	itemList[i]=Integer.parseInt(st.nextToken());
        }
        
        int[][] adjArr = new int[n + 1][n + 1];
 
        for(int i=0; i<=n; i++){
        	Arrays.fill(adjArr[i], 3001);
        	adjArr[i][i]=0;
        }
        
        for (int i = 0; i < r; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			adjArr[a][b]=l;
			adjArr[b][a]=l;
        }
        // 플로이드 워셜
        for (int i = 1; i <= n; i++) { // 중간 노드
            for (int j = 1; j <= n; j++) { // 시작 노드
                for (int j2 = 1; j2 <= n; j2++) { // 도착 노드
                    adjArr[j][j2] = Math.min(adjArr[j][j2], adjArr[j][i] + adjArr[i][j2]);
                }
            }
        }
        
        int ans = 0;
        for (int i = 1; i <= n; i++) {
			int sum =0;
			for (int j = 1; j <= n; j++) {
				if(adjArr[i][j]<=m){
					sum+=itemList[j]; // 아이템 합
				}
			
        	}
        	ans = Math.max(ans, sum);
        }
        
        
        System.out.println(ans);
        
	}
}