import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean[] chk;
	
	static void cantorSet(int st, int ed, int depth) {
		if (depth != 0) {
			
		

		int midSt = ed / 3 + st;
		int midEd = midSt + ed / 3;

		for (int i = midSt; i < midEd; i++) {
			chk[i] = true;
		}

		cantorSet(st, (int) Math.pow(3, depth - 1), depth - 1);
		cantorSet(midEd, (int) Math.pow(3, depth - 1), depth - 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuilder sb= new StringBuilder();	
		while ((line = br.readLine()) != null && !line.isEmpty()) {
			int N = Integer.parseInt(line);
			int len = (int) Math.pow(3, N);
			chk = new boolean[len];

			cantorSet(0, len, N);

			
			for (int i = 0; i < chk.length; i++) {
				if (!chk[i]) {
					sb.append("-");
				} else {
					sb.append(" ");
				}

			}

			sb.append("\n");

		}
		
		System.out.println(sb.toString());

	} // main

}// class