import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static class Student implements Comparable<Student>{
		String Name;
		int day;
		int month;
		int year;
		public Student(String Name, int day, int month, int year) {
			this.Name = Name;
			this.day = day;
			this.month = month;
			this.year = year;
		}
		@Override
		public int compareTo(Student o) {
		    if (this.year != o.year) {
		        return Integer.compare(this.year, o.year);
		    } else if (this.month != o.month) {
		        return Integer.compare(this.month, o.month);
		    } else {
		        return Integer.compare(this.day, o.day);
		    }
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		
		LinkedList<Student> stu = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int days = Integer.parseInt(st.nextToken());
			int months = Integer.parseInt(st.nextToken());
			int years = Integer.parseInt(st.nextToken());
			
			stu.offer(new Student(name, days, months, years));
		}
		
		Collections.sort(stu);
		
		System.out.println(stu.peekLast().Name);
		System.out.println(stu.peekFirst().Name);
		
	} // end of main

} // end of class
