import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Thx to weedy7955
 * @author quadcore
 */
class Main {
	public static int n,m, result;
	public static boolean[][] map;
	public static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
	public static int[] dx = {0, 0, -1, 1, 1, -1, 1, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		result = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				if (st.nextToken().equals("1")) map[i][j] = true;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!map[i][j]) continue;
				bfs(i, j);
			}
		}
		System.out.println(result);
	}
	
	public static void bfs(int y, int x) {
		Queue<int[]> list = new LinkedList<>();
		list.add(new int[]{y, x});
		while (!list.isEmpty()) {
			int[] tmp = list.remove();
			for (int i = 0; i < 8; i++) {
				int ny = tmp[0] + dy[i];
				int nx = tmp[1] + dx[i];
				if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
				if (!map[ny][nx]) continue;
				map[ny][nx] = false;
				list.add(new int[]{ny, nx});
			}
		}
		result++;
	}
}