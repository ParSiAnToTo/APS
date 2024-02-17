import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int ln = S.length();

		int[] ascii = new int[26];
		
		for (int i = 0; i<ln; i++) {
			
			if( 'A'<= S.charAt(i) && S.charAt(i)<='Z')
				ascii[S.charAt(i)-'A']++;
			else {ascii[S.charAt(i)-'a']++;}
			
		}
		
		int max = -1;
		char dup = '?';
		for(int i = 0; i<26; i++) {
			if(max<ascii[i]) {
				max = ascii[i];
				dup = (char)(i+65); }
			else if  (ascii[i] == max) 
				dup = '?';
			
		}
		
		System.out.println(dup);
			
			
	

		
		
		
		
	}
	
}
	