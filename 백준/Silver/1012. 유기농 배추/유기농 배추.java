import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] visited;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken()); // col
			int N = Integer.parseInt(st.nextToken()); // row
			int K = Integer.parseInt(st.nextToken()); // romain count
			int[][] field = new int[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int X = Integer.parseInt(st.nextToken()); 
				int Y = Integer.parseInt(st.nextToken()); 
				field[Y][X] = 1;
			} // field data input
			
			int worm = BFS(field, M, N);	
			sb.append(worm).append("\n");
			
		} // end of testCase
		
		System.out.println(sb.toString());

	} // end of main
	
	static int BFS(int[][] arr, int M, int N) {
		visited = new boolean[N][M];
		Queue<Integer> q = new LinkedList<>();
		int countWorm = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j]==1 && !visited[i][j]) {
					q.offer(i*100 + j);
					visited[i][j]=true;
					countWorm++;
					while(!q.isEmpty()) {
						int point = q.poll();
						int r = point/100;
						int c = point%100;
						for (int k = 0; k < 4; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];
							if(nr < N && nr >=0 && nc < M && nc >=0) {
								if(arr[nr][nc]==1 && !visited[nr][nc]) {
									visited[nr][nc] = true;
									q.offer(nr*100 + nc);
								}
							}
						}
					} // while
					
				}
			} //for j
		} // for i
		
		
		return countWorm;
	} // end of BFS

} // end of class
