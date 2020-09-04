import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static int n;
	public static int blue, white;
	public static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		blue = 0; white = 0;
		n = Integer.parseInt(br.readLine());
		map = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				if (st.nextToken().equals("1")) map[i][j] = true;
			}
		}
		devide(0, 0, n);
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static void devide(int y, int x, int len) {
		if (len == 1) {
			if (map[y][x]) blue++;
			else white++;
			return;
		}
		if (check(y, x, len)) {
			if (map[y][x]) blue++;
			else white++;
			return;
		} else {
			devide(y, x, len/2);
			devide(y+(len/2), x, len/2);
			devide(y, x+(len/2), len/2);
			devide(y+(len/2), x+(len/2), len/2);
		}
	}
	public static boolean check(int y, int x, int len) {
		boolean flag = map[y][x];
		for (int i = y; i < y+len; i++) {
			for (int j = x; j < x+len; j++) {
				if (map[i][j] != flag) return false;
			}
		}
		return true;
	}
}