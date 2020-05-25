import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author quadcore
 */
class Main {
	public static boolean[][] map, visited;
	public static int m, n;
	public static int[] dy = {1,-1,0,0};
	public static int[] dx = {0,0,-1,1};
	public static boolean isUnderTheSea;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new boolean[m][n];
		visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < n; j++) {
				if (tmp.charAt(j) == '0') map[i][j] = true;
			}
		}
		for (int i = 0; i < n; i++) {
			if (isUnderTheSea) break;
			if (visited[0][i]) continue;
			if (!map[0][i]) continue;
			bfs(0, i);
		}
		if (isUnderTheSea) System.out.println("YES");
		else System.out.println("NO");
	}
	public static void bfs(int y, int x) {
		Pair tmp = new Pair(y, x);
		visited[y][x] = true;
		Queue<Pair> list = new LinkedList<Pair>();
		list.add(tmp);
		while (!list.isEmpty()) {
			Pair p = list.poll();
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (ny >= m || nx >= n || ny < 0 || nx < 0) continue;
				if (visited[ny][nx]) continue;
				if (!map[ny][nx]) continue;
				visited[ny][nx] = true;
				list.add(new Pair(ny, nx));
				if (ny == m-1) {
					isUnderTheSea = true;
					return;
				}
			}
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