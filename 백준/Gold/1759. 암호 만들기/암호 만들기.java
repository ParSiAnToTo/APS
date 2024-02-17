import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int L, C;
	static StringBuilder sb = new StringBuilder();
	static char[] code;
	static char[] result;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		code = new char[C];
		String[] codeLine = br.readLine().split(" ");
		for (int i = 0; i < C; i++) {
			code[i] = codeLine[i].charAt(0);
		}
		Arrays.sort(code); // 알파벳 정렬

		result = new char[L]; // 암호 조합 저장 배열
		visited = new boolean[C]; // 암호 중복 체크 배열

		back(0, 0);
		sb.delete(sb.length() - 1, sb.length());
		System.out.println(sb.toString());

	} // end of main

	static void back(int n, int idx) {
		if (idx == L) {
			if (codeCheck(result)) { // 암호 조건 검증
				for (int i = 0; i < result.length; i++) {
					sb.append(result[i]);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = n; i < C; i++) {

			if (visited[i]) {
				continue;
			}
			result[idx] = code[i];
			visited[i] = true;
			back(i + 1, idx + 1);
			visited[i] = false;

		}

	} // end of backTracking

	static boolean codeCheck(char[] arr) {
		int consonantCnt = 0; // 자음 개수 확인 파라미터
		int vowelCnt = 0; // 모음 개수 확인 파라미터

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
				vowelCnt++; // 모음 확인 시 증가
			} else {
				consonantCnt++; // 자음 확인 시 증가
			}
		}

		if (vowelCnt >= 1 && consonantCnt >= 2) {
			return true;
		} else {
			return false;
		}
	}

} // end of class
