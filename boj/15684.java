import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2차원 배열에서의 백트레킹 기법 적용.
 * 최소값이 뜨면 더 이상 탐색하지 않게 하기!
 * 침착하게 찬찬히 풀면 쉽다!
 */
public class Main {
	public static int n, m;
	public static int h;
	public static boolean[][] map;
	public static int answer = 9999;
	public static void main(String[] args) throws Exception {
    	// 입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	h = Integer.parseInt(st.nextToken());
    	map = new boolean[h][(n*2)-1];
    	for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][(b*2)] = true;
			map[a][b*2+1] = true;
			map[a][(b+1)*2] = true;
		}
    	
    	bulid();
    	if (answer == 9999) {
			System.out.println(-1);
			return;
		}
    	System.out.println(answer);
	}
	public static int[] dx = {1,-1};
	public static boolean move() {
		for (int i = 0; i < map[0].length; i+=2) {
			int idx = i;
			for (int j = 0; j < map.length; j++) {
				if (!map[j][idx]) continue;
				for (int k = 0; k < dx.length; k++) {
					int nx = idx + dx[k];
					if (nx >= map[0].length || nx < 0) continue;
					if (!map[j][nx]) continue;
					idx = idx + dx[k] + dx[k];
					break;
				}
			}
			if (idx != i) {
				return false;
			}
		}
		return true;
	}
	public static void bulid() {
		for (int i = 0; i < 4; i++) {
			back(0, 0, i);
			if (answer != 9999) return;
		}
	}
	public static void back(int cnt, int idx, int standard) {
		if (standard == cnt) {
			if (move()) {
				answer = Math.min(answer, standard);
			}
			return;
		}
		for (int i = idx; i < map.length * map[0].length; i++) {
			int y = i / map[0].length;
			int x = i % map[0].length;
			if ((x % 2) == 1) continue;
			if (map[y][x]) continue;
			int nx = x + 2;
			if (nx >= map[0].length || nx < 0) continue;
			if (map[y][nx]) continue;
			map[y][x] = true;
			map[y][x+1] = true;
			map[y][nx] = true;
			back(cnt+1, i, standard);
			map[y][x] = false;
			map[y][x+1] = false;
			map[y][nx] = false;
		}
	}
	public static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j]) System.out.print(1 + " ");
				else System.out.print(0 + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}