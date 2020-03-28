import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 침착하자.
 * @author quadcore
 *
 */
public class Main {
	public static int output = 9999999;
	public static int size;
	public static int map[][];
	public static boolean oldMap[][];
	public static boolean visited[][];
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		map = new int[size][size];
		oldMap = new boolean[size][size];
		visited = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				if (st.nextToken().equals("1")) oldMap[i][j] = true;
			}
		}
		makeMap();
		visited = new boolean[size][size];
		findShortRoute();
		System.out.println(output);
	}
	public static void bfs(Pair p) {
		LinkedList<Pair> list = new LinkedList<>();
		p.cnt = 0;
		list.add(p);
		while (!list.isEmpty()) {
			Pair tmp = list.pollFirst();
			int cnt = tmp.cnt;
			for (int i = 0; i < 4; i++) {
				int ny = tmp.y + dy[i];
				int nx = tmp.x + dx[i];
				if (ny >= size || nx >= size || ny < 0 || nx < 0) continue;
				if (map[ny][nx] == tmp.color) continue;
				if (map[ny][nx] == 0) {
					if (visited[ny][nx]) continue;
					Pair np = new Pair(ny, nx, tmp.color, cnt+1);
					visited[ny][nx] = true;
					list.add(np);
				} else {
					if (output > tmp.cnt) {
						output = tmp.cnt;
					}
					return;
				}
			}
		}
	}
	public static void findShortRoute() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 0) continue;
				Pair p = new Pair(i, j, map[i][j]);
				bfs(p);
				visited = new boolean[size][size];
			}
		}
	}
	
	public static void makeMap() {
		int color = 1;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!oldMap[i][j]) continue;
				if (visited[i][j]) continue;
				bfs(i, j, color);
				color++;
			}
		}
	}
	public static void bfs(int y, int x, int color) {
		LinkedList<Pair> list = new LinkedList<>();
		list.add(new Pair(y, x, color));
		map[y][x] = color;
		while (!list.isEmpty()) {
			Pair p = list.pollFirst();
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (ny >= size || nx >= size || ny < 0 || nx < 0) continue;
				if (!oldMap[ny][nx]) continue;
				if (visited[ny][nx]) continue;
				visited[ny][nx] = true;
				map[ny][nx] = color;
				list.add(new Pair(ny, nx, color));
			}
		}
	}
}

class Pair {
	int y, x;
	int color;
	int cnt;
	public Pair(int y, int x, int color) {
		// TODO Auto-generated constructor stub
		this.color = color;
		this.x = x;
		this.y = y;
	}
	public Pair(int y, int x, int color, int cnt) {
		// TODO Auto-generated constructor stub
		this.color = color;
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}