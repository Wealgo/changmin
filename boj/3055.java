import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 시뮬레이션의 향연.
 */
public class Main {
	public static int r,c, answer = 0;
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
    	// 입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		char[][] map = new char[r][c];
		int y = 0, x = 0;
		for (int i = 0; i < map.length; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == 'S') {
					y = i;
					x = j;
				}
			}
		}
		bfs(map, y, x);
		if (answer == 0) {
			System.out.println("KAKTUS");
			return;
		} 
		System.out.println(answer);
	}
	
	public static void bfs(char[][] map, int y, int x) {
		Map tmp = new Map();
		tmp.map = map;
		tmp.cnt = 0;
		tmp.gy = y;
		tmp.gx = x;
		LinkedList<Map> list = new LinkedList<>();
		list.add(tmp);
		boolean[][] visited = new boolean[r][c];
		while (!list.isEmpty()) {
			Map p = list.poll();
			visited[p.gy][p.gx] = true;
			p.map = water(p.map);
			for (int i = 0; i < 4; i++) {
				int ny = p.gy + dy[i];
				int nx = p.gx + dx[i];
				if (ny >= r || nx >= c || ny < 0 || nx < 0) continue;
				if (p.map[ny][nx] == 'X') continue;
				if (p.map[ny][nx] == '*') continue;
				if (visited[ny][nx]) continue;
				if (p.map[ny][nx] == 'D') {
					answer = p.cnt+1;
					return;
				}
				Map np = new Map();
				np.map = p.map.clone();
				np.gy = ny;
				np.gx = nx;
				np.map[ny][nx] = 'S';
				np.map[p.gy][p.gx] = '.';
				np.cnt = p.cnt + 1;
				visited[ny][nx] = true;
				list.add(np);
			}
		}
	}
	public static char[][] water(char[][] map) {
		char[][] rmap = new char[r][c];
		boolean[][] nw = new boolean[r][c];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == '*') {
					int y = i, x = j;
					for (int k = 0; k < 4; k++) {
						int ny = y + dy[k];
						int nx = x + dx[k];
						if (ny >= r || nx >= c || ny < 0 || nx < 0) continue;
						if (map[ny][nx] == 'X') continue;
						if (map[ny][nx] == 'D') continue;
						nw[ny][nx] = true;
					}
				}
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (nw[i][j]) {
					rmap[i][j] = '*';
				} else {
					rmap[i][j] = map[i][j];
				}
			}
		}
		return rmap;
	}
	public static void printmap(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
class Map {
	char[][] map;
	int cnt;
	int gy, gx;
}
