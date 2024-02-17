import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr;
	static int[] operator;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void back(int depth, int res) {
		if (depth == N-1) {
			if (res > max) {
				max = res;
			}
			if (res < min) {
				min = res;
			}

			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;
				switch (i) {
				case 0:
					back(depth + 1, res + arr[depth + 1]);
					break;
				case 1:
					back(depth + 1, res - arr[depth + 1]);
					break;
				case 2:
					back(depth + 1, res * arr[depth + 1]);
					break;
				case 3:
					back(depth + 1, res / arr[depth + 1]);
					break;
				default:
					break;
				}
				operator[i]++;

			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		operator = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < operator.length; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		back(0, arr[0]);
		System.out.println(max);
		System.out.println(min);

	}// end of main

}// end of class