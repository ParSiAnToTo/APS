import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String sentence = br.readLine();
		int[] arr = new int[26];
		for (int i = 0; i < sentence.length(); i++) {
			arr[sentence.charAt(i) - 'a']++;
		}
		for (int i = 0; i < arr.length; i++) {
			bw.write(arr[i] + " ");
		}
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class