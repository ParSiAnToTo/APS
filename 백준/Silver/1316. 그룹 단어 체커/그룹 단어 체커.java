import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); 
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			boolean[] checker = new boolean[26]; // spell split checker
			String sentence = br.readLine(); // next sentence
			int chk = -1; // prev spell checker
			boolean flag = false; // condition checker
			
			for (int j = 0; j < sentence.length(); j++) { // spell check
				int now = sentence.charAt(j)-'a'; // j th spell
				if (chk != now) { // if not continuous
					if(!checker[now]) { // if not checked
						checker[now]=true;
					} else { // checked spell
						flag = true; // condition fail
						break; 
					}
					chk = now; // prev spell updated
				} else { // continuous spell 
					continue; 
				}	
				
				
			}
			
			if(!flag) { // condition check
				ans++;
			}
		}

		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class