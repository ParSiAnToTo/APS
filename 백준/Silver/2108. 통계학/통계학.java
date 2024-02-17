import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[8001];
		int max = -4001;
		int min = 4001;
		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(br.readLine()); // data input
			arr[val+4000]++;
			if(max < val) { //max tracking
				max = val;
			}
			
			if(min > val) { //min tracking
				min = val;
			}
			
		}
		
		int ari = 0;
		int med = 0;
		int mod = 0;
		int ans2 = 0; // median
		int ans3 = 0; // mode
		boolean chk = false;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=0) {
				ari += (i-4000)*arr[i];
				if(med< (N+1)/2) {
					med += arr[i];
					ans2 = i-4000;
				}
				
				if(mod < arr[i]) {
					mod = arr[i];
					ans3 = i-4000;
					chk = true; // mode find check
				} else if (mod == arr[i] && chk) {
					ans3 = i - 4000; // second mode
					chk = false;
				}
				
			}
			
			
		}
		
		int ans1 = (int) Math.round((double) ari / N);
		System.out.println(ans1); //arithmetic mean
		System.out.println(ans2); //median
		System.out.println(ans3); // mode
		System.out.println(max - min); //range

	} // end of main

} // end of class
