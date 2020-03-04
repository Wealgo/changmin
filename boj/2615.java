import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 덜렁대지말자!
 * @author quadcore
 *
 */
public class Main {
	public static int whoWin = 0;
	public static int px = 0;
	public static int py = 0;
	public static boolean isWrited = false;
	public static int[][] map;
	public static int size = 6;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[size][size];
		StringTokenizer st;
		
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		getPoint();
		System.out.println(whoWin);
		if (whoWin != 0) {
			System.out.println((py+1) + " " + (px+1));
		}
	}
	public static void getPoint() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] != 0) {
					nimi(i, j);
				}
			}
		}
	}
	
	public static void nimi(int y, int x) {
		garo(y, x);
		sero(y, x);
		upRight(y, x);
		upLeft(y, x);
	}
	public static void garo(int y, int x) {
		int cnt = 1;
		for (int i = 1; i <= 5; i++) {
			int nx = x + i;
			if (nx >= size) {
				break;
			}
			if (map[y][nx] != map[y][x]) {
				break;
			}
			cnt++;
		}
		for (int i = 1; i <= 5; i++) {
			int nx = x - i;
			if (nx < 0 || map[y][nx] != map[y][x]) {
				break;
			}
			cnt++;
		}
		if (cnt == 5) {
			if (!isWrited) {
				px = x;
				py = y;
				isWrited = true;
			}
			whoWin = map[y][x];
		}
	}
	
	public static void sero(int y, int x) {
		int cnt = 1;
		for (int i = 1; i <= 5; i++) {
			int ny = y + i;
			if (ny >= size || map[ny][x] != map[y][x]) {
				break;
			}
			cnt++;
		}
		for (int i = 1; i <= 5; i++) {
			int ny = y - i;
			if (ny < 0 || map[ny][x] != map[y][x]) {
				break;
			}
			cnt++;
		}
		if (cnt == 5) {
			if (!isWrited) {
				px = x;
				py = y;
				isWrited = true;
			}
			whoWin = map[y][x];
		}
	}
	public static void upRight(int y, int x) {
		int cnt = 1;
		for (int i = 1; i <= 5; i++) {
			int nx = x + i;
			int ny = y - i;
			
			if (nx >= size || ny < 0 || map[ny][nx] != map[y][x]) {
				break;
			}
			cnt++;
		}
		for (int i = 1; i <= 5; i++) {
			int nx = x - i;
			int ny = y + i;
			if (nx < 0 || ny >= size || map[ny][nx] != map[y][x]) {
				break;
			}
			cnt++;
		}
		if (cnt == 5) {
			if (!isWrited) {
				px = x-4;
				py = y+4;
				isWrited = true;
			}
			whoWin = map[y][x];
		}
	}
	public static void upLeft(int y, int x) {
		int cnt = 1;
		for (int i = 1; i <= 5; i++) {
			int nx = x + i;
			int ny = y + i;
			if (nx >= size || ny >= size || map[ny][nx] != map[y][x]) {
				break;
			}
			cnt++;
		}
		for (int i = 1; i <= 5; i++) {
			int nx = x - i;
			int ny = y - i;
			
			if (nx < 0 || ny < 0 || map[ny][nx] != map[y][x]) {
				break;
			}
			cnt++;
		}
		if (cnt == 5) {
			if (!isWrited) {
				px = x;
				py = y;
				isWrited = true;
			}
			whoWin = map[y][x];
		}
	}
}
