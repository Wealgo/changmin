import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * EZ
 * @author quadcore
 *
 */
public class Main {
	public static int total;
	public static int person1;
	public static int person2;
	public static int num;
	public static boolean isChonsu[][];
	public static boolean visited[];
	public static void main(String[] args) throws IOException {
		// 입력받고
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		total = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		person1 = Integer.parseInt(st.nextToken())-1;
		person2 = Integer.parseInt(st.nextToken())-1;
		num = Integer.parseInt(br.readLine());
		isChonsu = new boolean[total][total];
		visited = new boolean[total];
		int x,y;
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			isChonsu[y][x] = true;
			isChonsu[x][y] = true;
		}
		System.out.println(bfs(person1));
		
	}
	public static int bfs(int idx) {
		LinkedList<Pair> list = new LinkedList<Pair>();
		Pair p = new Pair(idx, 0);
		list.add(p);
		while (!list.isEmpty()) {
			Pair tmp = list.pollFirst();
			if (tmp.idx == person2) return tmp.chonsu;
			visited[tmp.idx] = true;
			for (int i = 0; i < total; i++) {
				if (visited[i]) continue;
				if (!isChonsu[tmp.idx][i]) continue;
				Pair np = new Pair(i, tmp.chonsu+1);
				list.add(np);
			}
		}
		return -1;
	}
}
class Pair {
	int idx;
	int chonsu;
	public Pair(int idx, int chonsu) {
		// TODO Auto-generated constructor stub
		this.idx = idx;
		this.chonsu = chonsu;
	}
}
