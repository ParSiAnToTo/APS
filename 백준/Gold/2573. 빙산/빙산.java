import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, sea, result;
	static int[][] iceberg;
	static boolean[][] checker, copyC;
	static int[] dr = new int[] { 1, -1, 0, 0 };
	static int[] dc = new int[] { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		iceberg = new int[N][M];
		checker = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int length = Integer.parseInt(st.nextToken());
				if (length == 0) {
					checker[i][j] = true;
				} else {
					iceberg[i][j] = length;
				}
			}
		}

		int year = 0;

		while (true) {
			// 빙산 구역 개수 체크
			copyC = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				copyC[i] = Arrays.copyOf(checker[i], M);
			}
			result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(!copyC[i][j] && iceberg[i][j] != 0) {
						DFS(i, j);
						result++;
					}				
				}				
			}
			
			// 분리가 안될 경우 0 출력
			if(result == 0) {
				bw.write(0 + "\n");
				break;
			}	
			
			// 2개 이상 분리 시 개수 출력
			if (result >= 2) {
				bw.write(year + "\n");
				break;
			}		
			
			// 햇수 증가
			year++;
			
			// 빙산 녹기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(!checker[i][j] && iceberg[i][j] != 0) {
						sea = 0;
						for (int way = 0; way < 4; way++) {
							int nr = i + dr[way];
							int nc = j + dc[way];
							if(nr >=0 && nr < N && nc >=0 && nc < M) {
								if(checker[nr][nc] && iceberg[nr][nc]==0) {
									sea++;
								}
							}
						}
						
						if(iceberg[i][j] - sea <0 ) {
							iceberg[i][j] = 0;
						} else {
							iceberg[i][j] -= sea;
						}
					}
				}
			}
			
			// checker 갱신
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(!checker[i][j] && iceberg[i][j]==0) {
						checker[i][j]=true;
					}
				}
			}
		}

		bw.flush();
		bw.close();
		br.close();

	} // end of main

	private static void DFS(int r, int c) {
		copyC[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr >=0 && nr < N && nc >=0 && nc < M) {
				if(!copyC[nr][nc] && iceberg[nr][nc]!=0) {
					DFS(nr,nc);
				}
			}
		}
	} // end of DFS

} // end of class