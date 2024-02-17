import java.util.Scanner;

public class Main {
	public static int N;
	public static int cnt;
	public static int[] arr;

	public static void nQueen(int queenNum) {

		if (queenNum == N) { // N개의 퀸을 배치하는데 성공했다면
			cnt++; //배치 성공 카운트를 추가한다
			return;
		}

		for (int i = 0; i < N; i++) { //퀸의 배치 검증. (queenNum+1)번째 퀸을 queenNum행의 i열에 배치합니다.
			arr[queenNum] = i;

			if (promissing(queenNum)) { //검증 통과한다면

				nQueen(queenNum + 1); //다음 퀸 배치의 검증을 시작한다
			}

		}

	} // nQueen

	public static boolean promissing(int queenNum) {
		for (int i = 0; i < queenNum; i++) {
			if (arr[queenNum] == arr[i]) {//동일 선상에 존재시
				return false; //false로 퀸을 옆으로 이동시킨다
			} else if (Math.abs(queenNum - i) == Math.abs(arr[queenNum] - arr[i])) { 
				//동일 대각선상에 배치되었을 경우
				return false; //false로 퀸을 옆으로 이동시킨다
			}
		}
		return true; //첫번째 퀸은 반드시 배치
	} // promissing

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

			N = sc.nextInt();
			arr = new int[N];
			cnt = 0;
			nQueen(0);
			System.out.println(cnt);
		
	}

}
