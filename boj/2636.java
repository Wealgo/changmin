import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
    let's go go
**/
public class Main {
	public static int garo;
	public static int sero;
	public static int[][] map;
	public static boolean[][] visited;
	public static boolean[][] check;
	public static int cheeseNum;
	public static int time = 0;
	public static int[] dx = {0,1,-1,0};
	public static int[] dy = {1,0,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		map = new int[sero][garo];
		visited = new boolean[sero][garo];
		check = new boolean[sero][garo];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cheeseNum = count();
		dodo();
		System.out.println(time);
		System.out.println(cheeseNum);
	}
	public static void dodo() {
		while (true) {
			bfs();
			remove();
			if (count() != 0) {
				cheeseNum = count();
			}
			
			time = time + 1;
			visited = new boolean[sero][garo];
			if (isempty()) {
				return;
			}
		}
	}
	public static void remove() {
		for (int i = 0; i < check.length; i++) {
			for (int j = 0; j < check[0].length; j++) {
				if (check[i][j] == true) {
					map[i][j] = 0;
				}
			}
		}
	}
	public static int count() {
		int n = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 1) {
					n = n + 1;
				}
			}
		}
		return n;
	}
	public static void bfs() {
		LinkedList<Pair> list = new LinkedList<>();
		list.add(new Pair(0, 0));
		while (!list.isEmpty()) {
			Pair p = list.poll();
			int x = p.x;
			int y = p.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (ny >= 0 && ny < sero && nx >= 0 && nx < garo) {
					if (map[ny][nx] == 1) {
						check[ny][nx] = true;
					}
					if (map[ny][nx] == 0 && !visited[ny][nx]) {
						Pair tmp = new Pair(ny, nx);
						list.add(tmp);
						visited[ny][nx] = true;
					}
				}
			}
		}
	}
	public static boolean isempty() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
class Pair {
	int x;
	int y;
	public Pair(int y, int x) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}
