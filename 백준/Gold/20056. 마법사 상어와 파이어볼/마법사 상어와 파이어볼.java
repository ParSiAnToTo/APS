import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class fireBall {
		int r; // row
		int c; // col
		int m; // mass
		int s; // speed
		int d; // direction

		public fireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	static int[] dr = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dir0 = new int[] { 0, 2, 4, 6 };
	static int[] dir1 = new int[] { 1, 3, 5, 7 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // size of map
		int M = Integer.parseInt(st.nextToken()); // number of fireball
		int K = Integer.parseInt(st.nextToken()); // number of move command

		Queue<fireBall> q = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			q.offer(new fireBall(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		ArrayList<fireBall>[][] map = new ArrayList[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		int nr, nc, nums, splitMass, splitSpeed, dirIdx;
		boolean flag;
		int[] dirChk;
		for (int i = 0; i < K; i++) {
			// 1. move fireBall
			while (!q.isEmpty()) {
				fireBall target = q.poll();
				nr = (N + target.r + dr[target.d] * target.s % N) % N;
				nc = (N + target.c + dc[target.d] * target.s % N) % N;
				if (nr == 0) {
					nr = N;
				}
				if (nc == 0) {
					nc = N;
				}
				map[nr][nc].add(new fireBall(nr, nc, target.m, target.s, target.d));
			}

			// 2. if duplicated
			for (int x = 1; x <= N; x++) {
				for (int y = 1; y <= N; y++) {
					nums = map[x][y].size();
					if (nums > 1) {
						dirChk = new int[nums];
						splitMass = 0;
						splitSpeed = 0;
						dirIdx = 0;
						for (fireBall fireball : map[x][y]) {
							splitMass += fireball.m;
							splitSpeed += fireball.s;
							dirChk[dirIdx++] = fireball.d % 2;
						}

						splitMass = splitMass / 5;
						if (splitMass == 0) {
							map[x][y].clear();
							continue;
						}
						splitSpeed = splitSpeed / nums;

						flag = false;
						for (int j = 0; j < nums - 1; j++) {
							if (dirChk[j] != dirChk[j + 1]) {
								flag = true;
								break;
							}
						}
						if (!flag) {
							for (int j = 0; j < 4; j++) {
								q.offer(new fireBall(x, y, splitMass, splitSpeed, dir0[j]));
							}
						} else {
							for (int j = 0; j < 4; j++) {
								q.offer(new fireBall(x, y, splitMass, splitSpeed, dir1[j]));
							}
						}
					} else if (nums == 1) {
						if (map[x][y].get(0).m != 0) {
							q.offer(map[x][y].get(0));
						}
					}
					map[x][y].clear();
				}
			}
		}

		int result = 0;
		fireBall end;
		while (!q.isEmpty()) {
			end = q.poll();
			result += end.m;
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class