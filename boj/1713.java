import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Student> list = new ArrayList<Student>();
		for(int i=0; i<n; i++) list.add(new Student(0, 0));
		
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(m-->0) {
			int rec = Integer.parseInt(st.nextToken());
			boolean isSt = false;
			for(int i=0; i<list.size(); i++)
				if(list.get(i).no == rec) {
					list.get(i).recommend++;
					isSt = true;
				}
			if(isSt) continue;
			list.add(new Student(rec, 1));
			int min = 1001;
			for(int i=0; i<list.size() - 1; i++)
				if(list.get(i).recommend < min)
					min = list.get(i).recommend;
			for(int i=0; i<list.size() - 1; i++)
				if(list.get(i).recommend == min) {
					list.remove(i);
					break;
				}
		}
		Collections.sort(list);
		for(int i=0; i<list.size(); i++)
			if(list.get(i).no == 0) continue;
			else System.out.print(list.get(i).no + " ");

	}

	static class Student implements Comparable<Student> {
		int no;
		int recommend;
		
		Student(int no, int recommend) {
			this.no = no;
			this.recommend = recommend;
		}
		
		@Override
		public int compareTo(Student s) {
			if(this.no > s.no)
				return 1;
			return -1;
		}
	}

}