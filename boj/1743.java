import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static boolean[][] visited, map;
	public static int garo, sero, n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		visited = new boolean[sero][garo];
		map = new boolean[sero][garo];
		n = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken())-1;
			map[n][m] = true;
		}
		
		System.out.println(find());
	}
	public static int find() {
		int cnt = 0;
		
		for (int i = 0; i < sero; i++) {
			for (int j = 0; j < garo; j++) {
				if (visited[i][j]) continue;
				if (!map[i][j]) continue;
				cnt = Math.max(cnt, bfs(i, j));
			}
		}
		
		return cnt;
	}
	public static int[] dy = {1, -1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	public static int bfs(int y, int x) {
		int cnt = 1;
		LinkedList<Pair> list = new LinkedList<>();
		list.add(new Pair(y, x));
		while (!list.isEmpty()) {
			Pair p = list.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (ny >= sero || nx >= garo || ny < 0 || nx < 0) continue;
				if (!map[ny][nx]) continue;
				if (visited[ny][nx]) continue;
				visited[ny][nx] = true;
				list.add(new Pair(ny, nx));
				cnt++;
			}
		}
		return cnt-1;
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