import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int ln = S.length();
		sc.close();

		
		int cnt = 0;
		for(int i = 0; i<ln-1;i++) {
			switch(S.substring(i,i+2)) {
			case "c=": case "c-": case "d-": case "lj" : case "nj" : case "s=": case "z=":
				cnt++;
				break;
			default: break;
			}
			
			if(i >0 && S.substring(i-1,i+2).equals("dz="))
				cnt++;
			
			}
		
		System.out.println(ln-cnt);
			
			
			
			
			
		}
		
		
	}