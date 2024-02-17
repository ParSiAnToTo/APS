import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	static void gearSpin(int gearNum, int clockWay, int[][] gears) {
		boolean[] magneticChk = new boolean[3];
		for (int i = 0; i < magneticChk.length; i++) {
			if (gears[i][2] != gears[i + 1][6]) {
				magneticChk[i] = true;
			}
		}

		if (clockWay == 1) { // 기준 톱니 시계방향 회전이라면
			clockwise(gearNum, gears); // 기준 톱니 시계방향 외전
			for (int i = gearNum + 1; i < 4; i++) { // 기준 톱니 우측 회전 검사
				if (magneticChk[i - 1]) { // 접촉 부분 극 반대
					if ((i - gearNum) % 2 == 1) { // 회전 톱니와 반대방향으로 회전
						antiClockwise(i, gears);
					} else if ((i - gearNum) % 2 == 0) { // 회전 톱니와 같은 방향으로 회전
						clockwise(i, gears);
					}
				} else { // 회전 조건 만족 X, 오른쪽 회전 검증 중지
					break;
				}
			}

			for (int i = gearNum - 1; i >= 0; i--) {
				if (magneticChk[i]) { // 접촉 부분 극 반대
					if ((gearNum - i) % 2 == 1) { // 회전 톱니와 반대방향으로 회전
						antiClockwise(i, gears);
					} else if ((i - gearNum) % 2 == 0) { // 회전 톱니와 같은 방향으로 회전
						clockwise(i, gears);
					}
				} else {// 회전 조건 만족 X, 왼쪽 회전 검증 중지
					break;
				}
			}

		} else if (clockWay == -1) { // 기준 톱니 반시계방향 회전이라면
			antiClockwise(gearNum, gears); // 기준 톱니 반시계방향 회전
			for (int i = gearNum + 1; i < 4; i++) { // 기준 톱니 우측 회전 검사
				if (magneticChk[i - 1]) { // 접촉 부분 극 반대
					if ((i - gearNum) % 2 == 1) { // 회전 톱니와 반대방향으로 회전
						clockwise(i, gears);
					} else if ((i - gearNum) % 2 == 0) { // 회전 톱니와 같은 방향으로 회전
						antiClockwise(i, gears);
					}
				} else { // 회전 조건 만족 X, 오른쪽 회전 검증 중지
					break;
				}
			}

			for (int i = gearNum - 1; i >= 0; i--) {
				if (magneticChk[i]) { // 접촉 부분 극 반대
					if ((gearNum - i) % 2 == 1) { // 회전 톱니와 반대방향으로 회전
						clockwise(i, gears);
					} else if ((i - gearNum) % 2 == 0) { // 회전 톱니와 같은 방향으로 회전
						antiClockwise(i, gears);
					}
				} else {// 회전 조건 만족 X, 왼쪽 회전 검증 중지
					break;
				}
			}

		}

	}

	

	static void clockwise(int idx, int[][] gears) {
		int temp = gears[idx][7];
		for (int i = 6; i >= 0; i--) {
			gears[idx][i + 1] = gears[idx][i];
		}
		gears[idx][0] = temp;
	}

	static void antiClockwise(int idx, int[][] gears) {
		int temp = gears[idx][0];
		for (int i = 0; i < 7; i++) {
			gears[idx][i] = gears[idx][i + 1];
		}
		gears[idx][7] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] gear = new int[4][8];

		for (int i = 0; i < 4; i++) {
			String ns = br.readLine();
			for (int j = 0; j < 8; j++) {
				gear[i][j] = ns.charAt(j) - '0';
			}
		}

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken()) - 1;
			int way = Integer.parseInt(st.nextToken());
			gearSpin(num, way, gear);
		}
		int ans = 0;
		for (int i = 0; i < 4; i++) {
			if (gear[i][0] == 1) {
				ans += Math.pow(2, i);
			}
		}

		System.out.println(ans);

	}// end of main

}// end of class