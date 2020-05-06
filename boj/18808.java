import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 찬찬히 풀면 된다.
 * 시뮬레이션.
 */
public class Main {
	public static int n,m,k;
	public static int stickerIdx = 0;
	public static boolean[][] notebook;
	public static LinkedList<Map> stickers = new LinkedList<>();
	public static void main(String[] args) throws Exception {
    	// 입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		notebook = new boolean[n][m];
		for (int t = 0; t < k; t++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			boolean[][] map = new boolean[r][c];
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[0].length; j++) {
					String tmp = st.nextToken();
					if (tmp.equals("1")) map[i][j] = true;
					else map[i][j] = false;
				}
			}
			
			for (int i = 0; i < 4; i++) {
				Map m = new Map(map);
				stickers.add(m);
				map = wheel(map);
			}
		}

		recursive();
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (notebook[i][j]) answer++;
			}
		}
		System.out.println(answer);
		/**/
	}
	public static void recursive() {
		for (int s = 0; s < k; s++) {
			POINT : for (int w = 0; w < 4; w++) {
				for (int i = 0; i < n*m; i++) {
					int y = i/m;
					int x = i%m;
					if (!isAttach(y, x, stickers.get((s*4)+w).map)) continue;
					attach(y, x, stickers.get((s*4)+w).map);
					break POINT;
				}
			}
		}
	}
	public static void attach(int y, int x, boolean[][] sticker) {
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				if (!sticker[i][j]) continue;
				int ny = y + i;
				int nx = x + j;
				notebook[ny][nx] = true;
			}
		}
	}
	public static boolean isAttach(int y, int x, boolean[][] sticker) {
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				if (!sticker[i][j]) continue;
				int ny = y + i;
				int nx = x + j;
				if (ny >= n || nx >= m || ny < 0 || nx < 0) return false;
				if (sticker[i][j] && notebook[ny][nx]) return false;
			}
		}
		return true;
	}
	public static boolean[][] wheel(boolean[][] map) {
		boolean[][] nm = new boolean[map[0].length][map.length];
		for (int i = 0; i < map.length; i++) {
			boolean[] tmp = map[i].clone();
			for (int j = 0; j < map[0].length; j++) {
				nm[j][map.length - i - 1] = tmp[j];
			}
		}
		return nm;
	}
}
class Map {
	boolean[][] map;
	public Map(boolean[][] map) {
		// TODO Auto-generated constructor stub
		this.map = map;
	}
}