import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 백트레킹.
 */
public class Main {
	public static int h,w;
	public static int answer;
	public static boolean[][] map;
	public static int cblock;
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,-1,1};
	public static int[][][] blocks = {
			{{0,0},{0,1},{1,0}},
			{{0,0},{1,0},{1,-1}},
			{{0,0},{0,1},{1,1}},
			{{0,0},{1,0},{1,1}}
			};
	public static void main(String[] args) throws Exception {
    	// 입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testcase; t++) {
			answer = 0;
			cblock = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new boolean[h][w];
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < w; j++) {
					if (tmp.charAt(j) == '#') map[i][j] = false;
					else {
						cnt++;
						map[i][j] = true;
					}
				}
			}
			if (cnt % 3 != 0) {
				System.out.println(0);
				continue;
			}
			search(0);
			System.out.println(answer);
			/**/
		}
	}
	
	public static void search(int idx) {
		if (check()) {
			++answer;
			return;
		}
		for (int i = idx; i < h*w; i++) {
			int y = i/w;
			int x = i%w;
			if (!map[y][x]) continue;
			for (int j = 0; j < 4; j++) {
				if (!cover(y, x, j, false)) continue;
				search(i+1);
				cover(y, x, j, true);
			}
			return;
		}
	}
	public static boolean check() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j]) return false;
			}
		}
		return true;
	}
	
	public static boolean cover(int y, int x, int dir, boolean b) {	
		for (int i = 0; i < 3; i++) {
			int ny = y + blocks[dir][i][0];
			int nx = x + blocks[dir][i][1];
			if (ny >= h || nx >= w || ny < 0 || nx < 0) return false;
			if (b == map[ny][nx]) return false;
		}

		for (int i = 0; i < 3; i++) {
			int ny = y + blocks[dir][i][0];
			int nx = x + blocks[dir][i][1];
			map[ny][nx] = b;
		}
		return true;
	}
}