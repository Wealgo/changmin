import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 
 */
public class Main {
	public static LinkedList<Integer> hot = new LinkedList<>();
	public static LinkedList<Integer> eat = new LinkedList<>();
	public static LinkedList<Lunchbox> sibal = new LinkedList<>();
	public static int time = 0;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		for (int k = 0; k < testcase; k++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				hot.add(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				eat.add(Integer.parseInt(st.nextToken()));
			}
			for (int i = 0; i < n; i++) {
				Lunchbox lun = new Lunchbox(hot.get(i), eat.get(i));
				sibal.add(lun);
			}
			//정렬.
			Collections.sort(sibal);
			System.out.println(time());
			//초기화.
			hot = new LinkedList<>();
			eat = new LinkedList<>();
			sibal = new LinkedList<>();
			time = 0;
		}
		br.close();
	}
	public static int time() {
		LinkedList<Integer> list = new LinkedList<>();
		int tmp = 0;
		for (int i = 0; i < hot.size(); i++) {
			tmp = tmp + sibal.get(i).hot;
			list.add(tmp + sibal.get(i).eat);
		}
		Collections.sort(list);
		return list.getLast();
	}
}
class Lunchbox implements Comparable<Lunchbox> {
	int hot;
	int eat;
	public Lunchbox(int hot, int eat) {
		// TODO Auto-generated constructor stub
		this.hot = hot;
		this.eat = eat;
	}
	public int gethot() {
		return hot;
	}
	@Override
	public int compareTo(Lunchbox o) {
		// TODO Auto-generated method stub
		if (this.eat < o.eat) {
			return 1;
		} else if (this.eat > o.eat) {
			return -1;
		}
		return 0;
	}
}