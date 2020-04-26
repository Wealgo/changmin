import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * 하나의 함수는 하나의 일만 하도록 만들자.
 * 하나의 함수가 잘 돌아가는지 테스트해보자.
 * 알고리즘에도 TDD를!
 * 침착하게 찬찬히 풀면 쉽다!
 */
public class Main {
	public static int dy[] = {-1,1,0,0};
	public static int dx[] = {0,0,-1,1};
	public static int sero = 12, garo = 6;
	public static boolean[][] visited = new boolean[12][6];
	public static char[][] map = new char[12][6];
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	for (int i = 0; i < sero; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < garo; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
    	if (!check()) {
			System.out.println(0);
			return;
		}
    	down();
    	boolean ise = true;
    	int answer = 1;
    	while (ise) {
    		visited = new boolean[12][6];
			ise = check();
			down();
			answer++;
		}
    	System.out.println(answer-1);
    	/**/
	}
	public static boolean check() {
		boolean ise = false;
		for (int i = 0; i < sero; i++) {
			for (int j = 0; j < garo; j++) {
				if (map[i][j] == '.') continue;
				if (visited[i][j]) continue;
				if (remove(i, j)) ise = true;
			}
		}
		return ise;
	}
	public static boolean remove(int y, int x) {
		boolean ise = false;
		Pair tmp = new Pair(y, x, map[y][x]);
		LinkedList<Pair> list = new LinkedList<>();
		LinkedList<Pair> clus = new LinkedList<>();
		list.add(tmp);	 clus.add(tmp);
		int cnt = 1;
		while (!list.isEmpty()) {
			Pair p = list.pollFirst();
			visited[p.y][p.x] = true;
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (ny >= sero || ny < 0 || nx >= garo || nx < 0) continue;
				if (visited[ny][nx]) continue;
				if (map[ny][nx] != p.v) continue;
				cnt++;
				visited[ny][nx] = true;
				list.add(new Pair(ny, nx, p.v));
				clus.add(new Pair(ny, nx));
			}
		}
		if (cnt >= 4) {
			for (int i = 0; i < clus.size(); i++) {
				map[clus.get(i).y][clus.get(i).x] = '.';
			}
			ise = true;
		}
		return ise;
	}
	public static void down() {
		for (int i = sero-1; i >= 0; i--) {
			for (int j = 0; j < garo; j++) {
				if (map[i][j] == '.') continue;
				int cnt = 0;
				for (int k = 1; k < sero; k++) {
					if (i+k >= 12) break;
					if (map[i+k][j] != '.') break;
					cnt++;
				}
				if (cnt == 0) continue;
				map[i+cnt][j] = map[i][j];
				map[i][j] = '.';
			}
		}
	}
	public static void print() {
		for (int i = 0; i < sero; i++) {
			for (int j = 0; j < garo; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
class Pair {
	int y, x;
	char v;
	public Pair(int y, int x) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	public Pair(int y, int x, char v) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.v = v;
	}
}