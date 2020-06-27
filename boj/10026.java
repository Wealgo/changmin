import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Main {	
	public static int n;
	public static char[][] map;
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,-1,1};
	public static boolean[][] visited, wmap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		wmap = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'B') wmap[i][j] = true;
				else wmap[i][j] = false;
			}
		}
		visited = new boolean[n][n];
		int nomal = nomal();
		visited = new boolean[n][n];
		int weak = weak();
		System.out.println(nomal + " "+ weak);
	}
	
	public static int nomal() {
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) continue;
				char find = map[i][j];
				bfs(i, j, find);
				answer++;
			}
		}
		return answer;
	}
	public static void bfs(int y, int x, char c) {
		LinkedList<Pair> list = new LinkedList<>();
		Pair start = new Pair(y, x);
		list.add(start);
		while (!list.isEmpty()) {
			Pair p = list.poll();
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (ny >= n || nx >= n || ny < 0 || nx < 0) continue;
				if (visited[ny][nx]) continue;
				if (map[ny][nx] != c) continue;
				visited[ny][nx] = true;
				list.add(new Pair(ny, nx));
			}
		}
	}
	public static int weak() {
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) continue;
				dfs(i, j, wmap[i][j]);
				answer++;
			}
		}
		return answer;
	}
	public static void dfs(int y, int x, boolean bool) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= n || nx >= n || ny < 0 || nx < 0) continue;
			if (visited[ny][nx]) continue;
			if (wmap[ny][nx] != bool) continue;
			visited[ny][nx] = true;
			dfs(ny, nx, bool);
		}
	}
}
class Pair {
	int y, x;
	public Pair(int y, int x) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}