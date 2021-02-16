import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Ez
 * @author quadcore
 */
class Main {
	public static int n;
	public static int[][] map, dp;
	public static boolean[][] visited;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		find();
	}
	public static void find() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited = new boolean[n][n];
				dfs(new Pair(i, j, map[i][j]));
			}
		}
	}
	public static void dfs(Pair p) {
		for (int i = 0; i < 4; i++) {
			int nx = p.x + dx[i];
			int ny = p.y + dy[i];
			if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
			if (map[ny][nx] <= map[p.y][p.x]) continue;
			if (visited[ny][nx]) continue;
			if (dp[ny][nx] < ) {
				
			}
		}
	}
}
class Pair {
	int y, x, v;
	public Pair(int y, int x, int v) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.v = v;
	}
}