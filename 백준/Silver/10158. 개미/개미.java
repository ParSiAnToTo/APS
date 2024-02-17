import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		int t = sc.nextInt();
		int chkX = t - w + p;
		int chkY = t - h + q;

//X값 체크
		if (chkX < 0)
			p = p + t;
		else if (chkX < w)
			p = w - chkX;
		else if ((chkX / w) % 2 == 0)
			p = w - (chkX % w);
		else if ((chkX / w) % 2 == 1)
			p = chkX % w;

//Y값 체크
		if (chkY < 0)
			q = q + t;
		else if (chkY < h)
			q = h - chkY;
		else if ((chkY / h) % 2 == 0)
			q = h - (chkY % h);
		else if ((chkY / h) % 2 == 1)
			q = chkY % h;
		
		
		System.out.println(p+" "+q);

		
	}

}