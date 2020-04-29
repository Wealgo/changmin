import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 비트마스킹 적용
 * 침착하게 찬찬히 풀면 쉽다!
 */
public class Main {
	public static int[] values;
	public static boolean[][] map;
	public static int total;
	public static int garry;
	public static void main(String[] args) throws Exception {
    	// 입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	total = Integer.parseInt(br.readLine());
    	values = new int[total];
    	map = new boolean[total][total];
    	garry = 0;
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < total; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}
    	for (int i = 0; i < total; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][tmp-1] = true;
			}
		}
    	back(0);
    	if (answer == 9999) {
			System.out.println(-1);
		} else System.out.println(answer);
	}
	public static int answer = 9999;
	public static void back(int idx) {
		int cnt = 0;
		for (int i = 0; i < total; i++) {
			if ((garry & (1 << i)) != 0) cnt++;
		}
		if (cnt != 0 && cnt != total) {
			int t = 0, f = 0;
			int tcnt = 0, fcnt = 0;
			for (int i = 0; i < total; i++) {
				if ((garry & (1 << i)) != 0) {t = i; tcnt++;}
				else {f = i; fcnt++;}
			}
			boolean t1 = bfsf(f, fcnt);
			boolean t2 = bfst(t, tcnt);
			if (t2 && t1) {
				int vt =0, vf = 0;
				for (int i = 0; i < total; i++) {
					if ((garry & (1 << i)) != 0) vt = vt + values[i];
					else vf = vf + values[i];
				}
				answer = Math.min(answer, Math.abs(vt-vf));
			}
		}
		for (int i = idx; i < total; i++) {
			garry = garry | (1 << i);
			back(i+1);
			garry = garry - (1 << i);
		}
	}
	public static boolean bfst(int start, int gn) {
		visited = new boolean[total];
		LinkedList<Integer> list = new LinkedList<>();
		list.add(start);
		int cnt = 0;
		while (!list.isEmpty()) {
			int n = list.poll();
			cnt = cnt + 1;
			for (int i = 0; i < total; i++) {
				if (!map[n][i]) continue;
				if ((garry & (1 << i)) == 0) continue;
				if (visited[i]) continue;
				visited[i] = true;
				list.add(i);
			}
		}
		if (gn == 1) {
			if (cnt == gn) return true;
			else return false;
		} else {
			if (cnt-1 == gn) return true;
			else return false;
		}
	}
	public static boolean[] visited;
	public static boolean bfsf(int start, int gn) {
		visited = new boolean[total];
		LinkedList<Integer> list = new LinkedList<>();
		list.add(start);
		int cnt = 0;
		while (!list.isEmpty()) {
			int n = list.poll();
			cnt = cnt + 1;
			for (int i = 0; i < total; i++) {
				if (!map[n][i]) continue;
				if ((garry & (1 << i)) != 0) continue;
				if (visited[i]) continue;
				visited[i] = true;
				list.add(i);
			}
		}
		if (gn == 1) {
			if (cnt == gn) return true;
			else return false;
		} else {
			if (cnt-1 == gn) return true;
			else return false;
		}
	}
}
class Pair {
	int y, x, cnt;
	int bit;
	public Pair(int y, int x, int cnt) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}