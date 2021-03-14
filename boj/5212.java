import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Ez
 * @author quadcore
 */
class Main {
	public static int garo, sero;
	public static boolean[][] map, newmap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		map = new boolean[sero][garo];
		newmap = new boolean[sero][garo];
		for (int i = 0; i < sero; i++) {
			String input = br.readLine();
			for (int j = 0; j < garo; j++) {
				if (input.charAt(j) == '.') continue;
				map[i][j] = true;
				newmap[i][j] = true;
			}
		}
		after50Years();
		for (int i = up; i < sero-down; i++) {
			for (int j = right; j < garo-left; j++) {
				if (newmap[i][j]) {
					System.out.print("X");
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void after50Years() {
		for (int i = 0; i < sero; i++) {
			for (int j = 0; j < garo; j++) {
				if (!map[i][j]) continue;
				warm(i, j);
			}
		}
		cut();
	}
	public static void warm(int y, int x) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (ny < 0 || nx < 0 || ny >= sero || nx >= garo) {
				cnt++;
				continue;
			}
			if (!map[ny][nx]) cnt++;
		}
		if (cnt >= 3) {
			newmap[y][x] = false;
		}
	}
	public static int up, down, right, left;
	public static void cut() {
		goup();
		godown();
		goright();
		goleft();
	}
	public static void goup() {
		up = 0;
		for (int i = 0; i < sero; i++) {
			for (int j = 0; j < garo; j++) if (newmap[i][j]) return;
			up++;
		}
	}
	public static void godown() {
		down = 0;
		for (int i = sero-1; i >= 0; i--) {
			for (int j = 0; j < garo; j++) if (newmap[i][j]) return;
			down++;
		}
	}
	public static void goright() {
		right = 0;
		for (int i = 0; i < garo; i++) {
			for (int j = 0; j < sero; j++) {
				if (newmap[j][i]) return;
			}
			right++;
		}
	}
	public static void goleft() {
		left = 0;
		for (int i = garo-1; i >= 0; i--) {
			for (int j = sero-1; j >= 0; j--) {
				if (newmap[j][i]) return;
			}
			left++;
		}
	}
}
