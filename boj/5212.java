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
		for (int i = 0; i < sero; i++) {
			for (int j = 0; j < garo; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		after50Years();
		System.out.println("=======");
		for (int i = 0; i < sero; i++) {
			for (int j = 0; j < garo; j++) {
				System.out.print(newmap[i][j]);
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
}
