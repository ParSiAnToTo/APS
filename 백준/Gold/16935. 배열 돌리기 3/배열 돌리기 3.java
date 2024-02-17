import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[][] temparr;

	public static void reverse() {
		int[][] temparr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temparr[i][j] = arr[N - 1 - i][j];
			}
		}

		arr = temparr;

	}

	public static void reverseLR() {
		int[][] temparr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temparr[i][j] = arr[i][M - 1 - j];
			}
		}

		arr = temparr;

	}

	public static void clockwiseRotation() {
		int[][] temparr = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				temparr[i][j] = arr[N - 1 - j][i];
			}
		}

		arr = temparr;

		int temp = M;
		M = N;
		N = temp;

	}

	public static void counterclockwiseRotation() {
		int[][] temparr = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				temparr[i][j] = arr[j][M - 1 - i];
			}
		}

		arr = temparr;

		int temp = M;
		M = N;
		N = temp;

	}

	public static void quadrantClockwiseRotation() {
		int[][] temparr = new int[N][M];
		for (int i = 0; i < N / 2; i++) { // 3사분면 자료 이동
			for (int j = 0; j < M / 2; j++) {
				temparr[i][j] = arr[N / 2 + i][j];
			}
		}

		for (int i = 0; i < N / 2; i++) { // 2사분면 자료 이동
			for (int j = M / 2; j < M; j++) {
				temparr[i][j] = arr[i][j - M / 2];
			}
		}

		for (int i = N / 2; i < N; i++) { // 1사분면 자료 이동
			for (int j = M / 2; j < M; j++) {
				temparr[i][j] = arr[i - N / 2][j];
			}
		}

		for (int i = N / 2; i < N; i++) { // 4사분면 자료 이동
			for (int j = 0; j < M / 2; j++) {
				temparr[i][j] = arr[i][M / 2 + j];
			}
		}

		arr = temparr;

	}

	public static void quadrantCounterclockwiseRotation() {
		int[][] temparr = new int[N][M];
		for (int i = 0; i < N / 2; i++) { // 1사분면 자료 이동
			for (int j = 0; j < M / 2; j++) {
				temparr[i][j] = arr[i][M / 2 + j];
			}
		}

		for (int i = 0; i < N / 2; i++) { // 4사분면 자료 이동
			for (int j = M / 2; j < M; j++) {
				temparr[i][j] = arr[N / 2 + i][j];
			}
		}

		for (int i = N / 2; i < N; i++) { // 3사분면 자료 이동
			for (int j = M / 2; j < M; j++) {
				temparr[i][j] = arr[i][j - M / 2];
			}
		}

		for (int i = N / 2; i < N; i++) { // 2사분면 자료 이동
			for (int j = 0; j < M / 2; j++) {
				temparr[i][j] = arr[i - N / 2][j];
			}
		}

		arr = temparr;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nmr = br.readLine().split(" ");
		N = Integer.parseInt(nmr[0]);
		M = Integer.parseInt(nmr[1]);
		int R = Integer.parseInt(nmr[2]);
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}

		String[] commandString = br.readLine().split(" ");
		
		for (int i = 0; i < R; i++) {
			int command = Integer.parseInt(commandString[i]);
			if (command == 1) { // 상하반전
				reverse();
			} else if (command == 2) { // 좌우반전
				reverseLR();
			} else if (command == 3) { // 시계방향 90도
				clockwiseRotation();
			} else if (command == 4) { // 반시계방향 90도
				counterclockwiseRotation();
			} else if (command == 5) { // 4분할 후 시계방향으로 한칸 이동
				quadrantClockwiseRotation();
			} else if (command == 6) { // 4분할 후 반시계방향으로 한칸 이동
				quadrantCounterclockwiseRotation();
			}

		} // command loop

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}