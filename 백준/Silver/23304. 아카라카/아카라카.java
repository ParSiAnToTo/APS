import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean isPalin(String s) {

		int len = s.length();

		if (len == 1)
			return true;

		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - 1 - i)) {
				return false;
			}
		}

		String akarakaChk = s.substring(0, len / 2);
		if (!isPalin(akarakaChk)) {
			return false;
		} else {
			return true;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		if (!isPalin(s)) {
			System.out.println("IPSELENTI");
		} else {
			System.out.println("AKARAKA");
		}
	} // main

}// class
