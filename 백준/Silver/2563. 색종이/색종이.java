import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;




public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int[][] white = new int[100][100];
		for(int i = 0; i<T; i++) {
			String line = br.readLine();
			int Cols = Integer.parseInt(line.split(" ")[0]);
			int Rows = Integer.parseInt(line.split(" ")[1]);
			for(int a = Rows; a<Rows+10; a++) {
				for(int b = Cols; b<Cols+10; b++) {
					white[a][b]=1;
				}
			}
		}
		br.close();
			int sum = 0;
			for(int x = 0; x<100; x++) {
				for(int y = 0; y<100; y++) {
					if(white[x][y]==1)
						sum++;
				}
			}
			
			System.out.println(sum);
		
			
			
		}
			

	}

