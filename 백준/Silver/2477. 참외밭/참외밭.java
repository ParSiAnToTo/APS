import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		int[][] ways = new int[6][2];

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				ways[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int maxh = 0;
		int maxv = 0;
		for (int i = 0; i < 6; i++) { // 육각형의 최대 높이, 폭 추적
			if (ways[i][0] == 1 || ways[i][0] == 2) { // 폭 최대값 추적
				if (maxh < ways[i][1]) {
					maxh = ways[i][1];
				}
			}

			if (ways[i][0] == 3 || ways[i][0] == 4) { // 높이 최대값 추적
				if (maxv < ways[i][1]) {
					maxv = ways[i][1];
				}
			}

		}

		int square = maxh * maxv;

		int ans = 0; // 면적당 생산량 * (사각형 최대 면적 - 육각형 파인 면적)
		for (int i = 0; i < 6; i++) {
			if (ways[i % 6][0] == 3 && ways[(i + 1) % 6][0] == 2) { // ㅢ형태
				ans = T * (square - ways[i % 6][1] * ways[(i + 1) % 6][1]);
			} else if (ways[i % 6][0] == 2 && ways[(i + 1) % 6][0] == 4) { // ㄴ 형태
				ans = T * (square - ways[i % 6][1] * ways[(i + 1) % 6][1]);
			} else if (ways[i % 6][0] == 4 && ways[(i + 1) % 6][0] == 1) { // ㅣㅡ형태
				ans = T * (square - ways[i % 6][1] * ways[(i + 1) % 6][1]);
			} else if (ways[i % 6][0] == 1 && ways[(i + 1) % 6][0] == 3) { // ㄱ형태
				ans = T * (square - ways[i % 6][1] * ways[(i + 1) % 6][1]);
			}
		}

		System.out.println(ans);

	}
}
