import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // length
		int H = Integer.parseInt(st.nextToken()); // height

		int[] stalactite = new int[H + 2]; // prefix sum save array
		int[] stalagmite = new int[H + 2]; // prefix sum save array

		for (int i = 0; i < N / 2; i++) {
			stalagmite[Integer.parseInt(br.readLine())]++;
			stalactite[H - Integer.parseInt(br.readLine()) + 1]++;
		}

		for (int i = 1; i <= H; i++) { // prefix sum calc
			stalagmite[i] += stalagmite[i - 1];
		}
		for (int i = H; i >= 1; i--) { // prefix sum calc
			stalactite[i] += stalactite[i + 1];
		}

		int min = Integer.MAX_VALUE;
		int minimumRangeCount = 0;
		int obstacle = 0;
		for (int i = 1; i <= H; i++) {
			obstacle = stalagmite[H] - stalagmite[i - 1] + stalactite[1] - stalactite[i + 1];
			if (min > obstacle) {
				min = obstacle;
				minimumRangeCount = 1;
			} else if (min == obstacle) {
				minimumRangeCount++;
			}
		}

		System.out.println(min + " " + minimumRangeCount);

	} // end of main

} // end of class
