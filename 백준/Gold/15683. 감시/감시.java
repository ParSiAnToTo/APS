import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static StringBuilder sb = new StringBuilder();
	static int[][] cctv;
	static int[][] checked;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static ArrayList<Node> list = new ArrayList<>();

	static class Node {
		int r;
		int c;
		int type;

		public Node(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cctv = new int[N][M]; // 사무실 정보 저장 배열
		checked = new int[N][M]; // 사각지대 정보 저장 배열

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int type = Integer.parseInt(st.nextToken());
				if (type > 0 && type < 6) { // cctv가 존재한다면
					list.add(new Node(i, j, type)); // cctv 좌표와 종류 저장
					checked[i][j] = 99; // cctv 위치 파악

				} else if (type == 6) { // 벽 위치 파악
					checked[i][j] = 999;
				}
				cctv[i][j] = type; //사무실 정보 저장
			}
		}

		ans = Integer.MAX_VALUE;
		back(0);

		System.out.println(ans);

	} // end of main

	static int blindSpot(int[][] arr) { // 사각지대 계산 메서드
		int blind = 0; // 0인 값 카운트
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					blind++;
				}
			}
		}
		return blind;
	}

	static void monitor(int r, int c, int dir, boolean chk) {
		int nr = r;
		int nc = c;

		while (true) {
			nr += dr[dir];
			nc += dc[dir];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M) { // 범위 벗어나면 중단
				break;
			}
			if (checked[nr][nc] == 999) { // 벽에 부딪히면 중단
				break;
			}

			if (chk) { // 감시 상태일 때
				checked[nr][nc]++;
			} else { // 감시 해제 처리
				if(checked[nr][nc]>0) {
					checked[nr][nc]--;
				}
			}

		}
	}

	static void back(int idx) {
		if (idx == list.size()) {
			int cnt = blindSpot(checked);
			if (ans > cnt) { // 사각지대 최소 크기 갱신
				ans = cnt;
			}
			return;
		}

		int r = list.get(idx).r;
		int c = list.get(idx).c;
		int type = list.get(idx).type;

		switch (type) {
		case 1:
			for (int dir = 0; dir < 4; dir++) {
				monitor(r, c, dir, true); // 감시 체크
				back(idx + 1);
				monitor(r, c, dir, false); // 기존 감시 영역 해제
			}

			break;
		case 2:
			for (int dir = 0; dir < 2; dir++) {
				monitor(r, c, dir, true); // 감시 체크
				monitor(r, c, dir+2, true); // 감시 체크
				back(idx + 1);
				monitor(r, c, dir, false); // 기존 감시 영역 해제
				monitor(r, c, dir+2, false); // 기존 감시 영역 해제
			}

			break;
		case 3:
			for (int dir = 0; dir < 4; dir++) {
				monitor(r, c, dir, true); // 감시 체크
				monitor(r, c, (dir+1)%4, true); // 감시 체크
				back(idx + 1);
				monitor(r, c, dir, false); // 기존 감시 영역 해제
				monitor(r, c, (dir+1)%4, false); // 기존 감시 영역 해제
			}

			break;
		case 4:
			for (int dir = 0; dir < 4; dir++) {
				monitor(r, c, dir, true); // 감시 체크 
				monitor(r, c, (dir+3)%4, true); // 감시 체크
				monitor(r, c, (dir+1)%4, true); // 감시 체크
				back(idx + 1);
				monitor(r, c, dir, false); // 기존 감시 영역 해제
				monitor(r, c, (dir+3)%4, false); // 기존 감시 영역 해제
				monitor(r, c, (dir+1)%4, false); // 기존 감시 영역 해제
			}

			break;
		case 5:
			monitor(r, c, 0, true); // 감시 체크
			monitor(r, c, 1, true); // 감시 체크
			monitor(r, c, 2, true); // 감시 체크
			monitor(r, c, 3, true); // 감시 체크
			back(idx + 1);
			monitor(r, c, 0, false); // 기존 감시 영역 해제
			monitor(r, c, 1, false); // 기존 감시 영역 해제
			monitor(r, c, 2, false); // 기존 감시 영역 해제
			monitor(r, c, 3, false); // 기존 감시 영역 해제

			break;

		default:
			break;
		}

	}

} // end of class
