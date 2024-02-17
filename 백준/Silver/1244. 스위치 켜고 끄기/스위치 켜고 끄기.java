import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		String[] lineString = line.split(" ");
		int[] switchData = new int[N];
		for (int input = 0; input < N; input++) {
			switchData[input] = Integer.parseInt(lineString[input]);
		}
		int stdN = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int i = 0; i < stdN; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int switchIdx = Integer.parseInt(st.nextToken());

			if (sex == 1) { // 남학생일때
				for (int male = switchIdx; male < N + 1; male += switchIdx) {
					if (switchData[male - 1] == 0) {
						switchData[male - 1] = 1;
					} else {
						switchData[male - 1] = 0;
					} // 남학생이면 스위치인덱스 배수 값 전환

				} // 남학생일 경우의 명령 반복 완료

			} else { // 여학생일때
				for (int j = 0; switchIdx - j > 0 && switchIdx + j < N + 1; j++) {
					if (switchData[switchIdx - 1 - j] == switchData[switchIdx - 1 + j]) {
						if (switchData[switchIdx - 1 - j] == 0) {
							switchData[switchIdx - 1 - j] = 1;
							switchData[switchIdx - 1 + j] = 1;
						} else {
							switchData[switchIdx - 1 - j] = 0;
							switchData[switchIdx - 1 + j] = 0;
						} 
                           
					}else
                        break;
				}
			}

		}

		int i = 1;
		StringBuilder sb = new StringBuilder();
		sb.append(switchData[0]).append(" ");
		while (i < N) {
			if (i % 20 == 0) {
				sb.append("\n");
			}
			sb.append(switchData[i]).append(" ");
			i++;
		}
		System.out.println(sb.toString());

	}
}
