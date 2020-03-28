import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 침착하자.
 * @author quadcore
 *
 */
public class Main {
	public static int n,m;
	public static boolean map[][];
	public static int picture = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				if (input.charAt(j) == '.') map[i][j] = true;
			}
		}
		up();
		down();
		left();
		right();
		System.out.println(picture);
	}
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,-1,1};
	public static void up() {
		for (int i = 1; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < m; j++) {
				if (!map[i][j] || map[i+dy[0]][j+dx[0]]) {
					cnt = 0; 
					continue;
				}
				++cnt;
				
				if (cnt == 2) {
					picture++;
					cnt = 0;
				}
			}
		}
	}
	public static void down() {
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < m-1; j++) {
				if (!map[i][j] || map[i+dy[1]][j+dx[1]]) {
					cnt = 0;
					continue;
				}
				++cnt;
				if (cnt == 2) {
					++picture;
					cnt = 0;
				}
			}
		}
	}
	public static void right() {
		for (int i = 0; i < m-1; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (!map[j][i] || map[j+dy[2]][i+dx[2]]) {
					cnt = 0;
					continue;
				}
				++cnt;
				if (cnt == 2) {
					++picture;
					cnt = 0;
				}
			}
		}
	}
	public static void left() {
		for (int i = 1; i < m; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (!map[j][i] || map[j+dy[3]][i+dx[3]]) {
					cnt = 0;
					continue;
				}
				++cnt;
				if (cnt == 2) {
					picture++;
					cnt = 0;
				}
			}
		}
	}
}