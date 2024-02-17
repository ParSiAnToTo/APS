import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken()); //테스트 케이스 횟수
		int ans =1;
		
		
		for (int i = 0; i < T; i++) {
			
			HashMap<String, Integer> closet = new HashMap<>();

			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken()); //케이스 별 의상 종류

			for (int j = 0; j < n; j++) {
				
				st = new StringTokenizer(br.readLine(), " ");
				
				st.nextToken(); //값 무시
				
				String name = st.nextToken(); //키 읽기
				
				if(closet.containsKey(name)) { //키가 존재한다면
					int plus = closet.get(name)+1; // 키 값 +1 
					closet.replace(name, plus); //키 값 갱신
				} else {
					closet.put(name, 1); // 신규 키 삽입
				}

			} // end of case
			
			ans = 1;
			for(int cnt : closet.values()) { //키별 값+1 곱
				ans *= cnt+1;
			}
			ans -= 1; // 전부 공백인 경우 제외
			
			sb.append(ans).append("\n");

		} // end of testCase
		
		System.out.println(sb.toString()); 
		
	}// end of main

}// end of class