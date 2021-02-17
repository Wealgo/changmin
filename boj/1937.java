import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Ez
 * @author quadcore
 */
class Main {
	public static int n, output = 1;
	public static int[][] map, dp;
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		find();
		System.out.println(output);
	}
	public static void find() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				output = Math.max(output, dfs(new Pair(i, j)));
			}
		}
	}
	public static int dfs(Pair p) {
		if (dp[p.y][p.x] != 0) return dp[p.y][p.x];
		int tmp = 0;
		for (int i = 0; i < 4; i++) {
			int nx = p.x + dx[i];
			int ny = p.y + dy[i];
			if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
			if (map[ny][nx] <= map[p.y][p.x]) continue;
			tmp = Math.max(tmp, dfs(new Pair(ny, nx)));
		}
		dp[p.y][p.x] = tmp+1;
		return dp[p.y][p.x];
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