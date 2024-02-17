import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String T = br.readLine();
		String P = br.readLine();

		int count = 0;
		int Tlen = T.length();
		int Plen = P.length();
		int[] patternTable = new int[Plen + 1];
		moveTable(P, patternTable); // 이동 경로 테이블 생성

		int idx = 0;
		for (int i = 0; i < Tlen; i++) {
			while (idx > 0 && T.charAt(i) != P.charAt(idx)) { //1개 이상부터, 불일치 시
				idx = patternTable[idx - 1]; //인덱스 이동
			}

			if (T.charAt(i) == P.charAt(idx)) { //해당 패턴 인덱스 일치 
				if (idx + 1 == Plen) { // 패턴 끝까지 동일하다면
					count++; // 정답 수 증가
					sb.append(i - Plen + 2).append(" "); // 동일패턴 인덱스 저장
					idx = patternTable[idx]; // 인덱스 이동
				} else {
					idx++; // 다음 문자 비교
				}
			}
		}
		System.out.println(count);
		System.out.println(sb.toString());

	} // end of main

	static void moveTable(String pattern, int[] table) {
		int len = pattern.length();
		int preIdx = 0; // 머리 인덱스
		for (int sufIdx = 1; sufIdx < len; sufIdx++) { // 꼬리 인덱스
			while (preIdx > 0 && pattern.charAt(preIdx) != pattern.charAt(sufIdx)) { //1개 이상부터 비교, 불일치 시
				preIdx = table[preIdx - 1]; // 인덱스 되돌리기
			}

			if (pattern.charAt(preIdx) == pattern.charAt(sufIdx)) {
				table[sufIdx] = ++preIdx; //이동경로 저장
			}

		}

	}

} // end of class
