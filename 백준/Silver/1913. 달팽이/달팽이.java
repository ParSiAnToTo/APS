import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int chkNum = sc.nextInt();
		sc.close();
		
		int r = N/2;
		int c = N/2;
		
		int[][] snail = new int[N][N];
		

		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		int dir =0;
		int num =1;
		int[] ans = new int[2];

		
		while(num <= N*N) {
			

			snail[r][c]=num;
			
			if (num==chkNum) {
				ans[0]=r;
				ans[1]=c;
			}
			
			
			int nr = r + dr[dir%4];
			int nc = c + dc[dir%4];

			if(nr>=0 && nr <N && nc>0 && nc<N) {
				if(snail[nr][nc]==0) {
					r+= dr[dir%4];
					c+= dc[dir%4];
				} else {
					dir+=3;
					r += dr[dir%4];
					c += dc[dir%4];
				}
				num++;

				
			}
			
			
			dir++;
			

		 
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int a=0; a<N; a++) {
			for(int b=0; b<N; b++) {
				sb.append(snail[a][b]+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		for(int a: ans)
		System.out.print((a+1)+" ");
		

	}

}
