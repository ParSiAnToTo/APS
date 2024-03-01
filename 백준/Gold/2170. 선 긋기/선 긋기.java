import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static class Line implements Comparable<Line>{
		int start;
		int end;
		
		public Line(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Line o) {
			if(this.start == o.start) {
				return this.end = o.end;
			}
			return this.start - o.start;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Line> list = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Line line = new Line(a, b);
			list.add(line);
		}
		Collections.sort(list);
		
		int length = 0;
		int srt = Integer.MIN_VALUE;
		int end = Integer.MIN_VALUE;
		for (int i = 0; i <N; i++) {
			if(list.get(i).start > end) {
				length += end - srt;
				srt = list.get(i).start;
				end = list.get(i).end;
			} else {
				if(end < list.get(i).end) {
					end = list.get(i).end;					
				}
			}						
		}
		length += end - srt;
		
		bw.write(String.valueOf(length));
		bw.flush();
		bw.close();
		br.close();

	} // end of main

} // end of class