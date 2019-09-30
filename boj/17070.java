import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 파이프의 머리와 꼬리 좌표를 가지고 있을 필요는 없다는 것을 생각하면 쉽게 풀릴것.
 * @author quadcore
 *
 */
public class Main{
	public static boolean[][] map;
	public static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new boolean[n][n];
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				if (st.nextToken().equals("0")) {
					map[i][j] = true;
				} else {
					map[i][j] = false;
				}
			}
		}
		bfs();
		System.out.println(output);
	}
	public static int output = 0;
	public static int[] dx = {1,1,0};
	public static int[] dy = {0,1,1};
	public static void bfs() {
		Pair p = new Pair(0, 1, 0);
		ArrayList<Pair> list = new ArrayList<>();
		list.add(p);
		while (!list.isEmpty()) {
			Pair sibal = list.remove(list.size()-1);
			if (sibal.x == n-1 && sibal.y == n-1) {
				output = output + 1;
				continue;
			}
			int nx = sibal.x + 1;
			int ny = sibal.y + 1;
			switch (sibal.status) {
			case 0:
				if (nx < n) {
					if (map[sibal.y][nx]) {
						Pair tmp = new Pair(sibal.y, nx, 0);
						list.add(tmp);
					}
				}
				if (nx < n && ny < n) {
					if (map[sibal.y][nx] && map[ny][sibal.x] && map[ny][nx]) {
						Pair tmp = new Pair(ny, nx, 1);
						list.add(tmp);
					}
				}
				break;
			case 1:
				if (nx < n) {
					if (map[sibal.y][nx]) {
						Pair tmp = new Pair(sibal.y, nx, 0);
						list.add(tmp);
					}
				}
				if (ny < n) {
					if (map[ny][sibal.x]) {
						Pair tmp = new Pair(ny, sibal.x, 2);
						list.add(tmp);
					}
				}
				if (ny < n && nx < n) {
					if (map[sibal.y][nx] && map[ny][sibal.x] && map[ny][nx]) {
						Pair tmp = new Pair(ny, nx, 1);
						list.add(tmp);
					}
				}
				break;
			case 2:
				if (ny < n) {
					if (map[ny][sibal.x]) {
						Pair tmp = new Pair(ny, sibal.x, 2);
						list.add(tmp);
					}
				}
				if (nx < n && ny < n) {
					if (map[sibal.y][nx] && map[ny][sibal.x] && map[ny][nx]) {
						Pair tmp = new Pair(ny, nx, 1);
						list.add(tmp);
					}
				}
				break;
			}
		}
	}
}
class Pair {
	int y,x;
	int status;		//0 garo, 1 diagon, 2 sero
	public Pair(int y, int x, int status) {
		// TODO Auto-generated constructor stub
		this.y = y;
		this.x = x;
		this.status = status;
	}
}