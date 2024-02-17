import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 4; tc++) {

			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();

			if (p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1) { // 서로 벗어남
				System.out.println("d");
			} else if ((p1 == x2 && q1 == y2) || (y1 == q2 && p1 == x2) || (x1 == p2 && y1 == q2)
					|| (q1 == y2 && x1 == p2)) { // 꼭지점만 접촉함
				System.out.println("c");
			} else if (p1 == x2 || y1 == q2 || x1 == p2 || q1 == y2) { //한 선분에서 만남
				System.out.println("b");
			} else { //그 외
				System.out.println("a");
			}

		}

	}

}
