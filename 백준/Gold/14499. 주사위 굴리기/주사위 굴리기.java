import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] diceValue;
	// delta 동 서 북 남 = 우 좌 상 하
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int[][] map;

	static void swap(int a, int b, int c, int d) {
		int temp = diceValue[a];
		diceValue[a] = diceValue[b];
		diceValue[b] = diceValue[c];
		diceValue[c] = diceValue[d];
		diceValue[d] = temp;

	}

	static void reverseSwap(int a, int b, int c, int d) {
		int temp = diceValue[d];
		diceValue[d] = diceValue[c];
		diceValue[c] = diceValue[b];
		diceValue[b] = diceValue[a];
		diceValue[a] = temp;
	}

    static void diceSpin(int way) {
		if (way == 1) { // 동쪽으로!
//			reverseSwap(diceValue[0], diceValue[2], diceValue[5], diceValue[3]);
			reverseSwap(0, 2, 5, 3);

		} else if (way == 2) { // 서쪽으로!
//			swap(diceValue[0], diceValue[2], diceValue[5], diceValue[3]);
			swap(0, 2, 5, 3);

		} else if (way == 3) { // 북쪽으로!
//			reverseSwap(diceValue[0], diceValue[1], diceValue[5], diceValue[4]);
			swap(0, 1, 5, 4);

		} else if (way == 4) { // 남쪽으로!
//			swap(diceValue[0], diceValue[1], diceValue[5], diceValue[4]);
			reverseSwap(0, 1, 5, 4);

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); // 세로 크기
		int M = Integer.parseInt(st.nextToken()); // 가로 크기
		int x = Integer.parseInt(st.nextToken()); // 주사위 시작 x 좌표
		int y = Integer.parseInt(st.nextToken()); // 주사위 시작 y 좌표
		int K = Integer.parseInt(st.nextToken()); // 명령 개수

		map = new int[N][M]; // 지도 생성
		diceValue = new int[6]; //주사위 생성

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // map data input
		
		int[] command = new int[K];// 명령 저장 배열
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < command.length; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		} // 명령 입력

		//통과는 잘 되고 있는데 값 복사가 안되는듯?
		for (int i = 0; i < K; i++) {

			int nr = x + dr[command[i] - 1];
			int nc = y + dc[command[i] - 1];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
				x = nr;
				y = nc;
				diceSpin(command[i]);
				sb.append(diceValue[0]).append("\n");

				if (map[x][y] == 0) {
					map[x][y] = diceValue[5];
				} else {
					diceValue[5] = map[x][y];
					map[x][y]=0;
				}

			} else {
				nr = x;
				nc = y;
				continue;
			}

		}

		System.out.println(sb.toString());

	}// end of main

}// end of class