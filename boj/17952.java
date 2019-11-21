import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Stack을 활용하라고 낸 문제.
 * 그러나 Stack보다 LinkedList가 빠름.
 * @author quadcore
 *
 */
public class Main {
	public static LinkedList<Work> list = new LinkedList<>();
	public static int output = 0;
	public static void main(String[] args) throws IOException {
		//입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			//과제가 없는 경우.
			if (n == 0) {
				//과제하자.
				homework();
			} else {
			//과제가 있는 경우.
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				//먼저해야할 과제로 두고.
				list.addFirst(new Work(score, time));
				homework();
			}
		}
		System.out.println(output);
	}
	//과제하는 함수.
	public static void homework() {
		//만약 해야할 과제가 없다면 pass.
		if (list.isEmpty()) return;
		//list에서 앞에해야할꺼 빼주고.
		Work work = list.pollFirst();
		int time = work.time;
		//시간 빼주고.
		time = time - 1;
		//숙제를 마치면.
		if (time == 0) {
			//점수를 추가해주자.
			output = output + work.score; 
		} else {
			//끝마치지 못하였다면 다시 넣어주자.
			list.addFirst(new Work(work.score, time));
		}
	}
}
class Work {
	int time, score;
	public Work(int score, int time) {
		// TODO Auto-generated constructor stub
		this.time = time;
		this.score = score;
	}
}