import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static LinkedList<Work> list = new LinkedList<>();
	public static int output = 0;
	public static void main(String[] args) throws IOException {
		//입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		//과제수만큼 돌자.
		for (int i = 0; i < testcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//과제가 있는지 없는지 확인.
			boolean isWork = st.nextToken().equals("1");
			//주어진 과제가 없다면.
			if (!isWork) {
				//숙제하자.
				homework();
			} else {
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				list.addFirst(new Work(score, time));
				homework();
			}
		}
		System.out.println(output);
	}
	//과제 처리하는 함수.
	public static void homework() {
		if (list.isEmpty()) return;
		Work work = list.pollFirst();
		int time = work.time;
		time = time - 1;
		if (time == 0) {
			output = output + work.score; 
		} else {
			list.addFirst(new Work(work.score, time));
		}
	}
	//과제 구조체.
	public static class Work {
		int time, score;
		public Work(int score, int time) {
			// TODO Auto-generated constructor stub
			this.time = time;
			this.score = score;
		}
	}
}
