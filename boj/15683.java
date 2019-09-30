import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main{
	public static int n,m;
	public static int[][] map;
	public static int output = 9999;
	public static LinkedList<Pair> list = new LinkedList<>();;
	public static void main(String[] args) throws IOException {
		//입력받고~
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < m; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (1 <= tmp && tmp < 6) {
					Pair pair = new Pair(i, j, tmp);
					list.add(pair);
				}
				map[i][j] = tmp;
			}
		}
		rec(map, 0, 0);
		System.out.println(output);
	}
	public static void rec(int[][] map, int idx, int dir) {
		if (idx >= list.size()) {
			check0(map);
			return;
		}
		Pair p = list.get(idx);
		for (int i = 0; i < 4; i++) {
			int[][] newmap = new int[n][m];
			for (int k = 0; k < newmap.length; k++) {
				for (int j = 0; j < newmap[0].length; j++) {
					newmap[k][j] = map[k][j];
				}
			}
			draw(newmap, i, p);
			rec(newmap, idx+1, 0);
		}
	}
	//dir 1-up 2-right 3-down 0-left
	public static int[][] draw(int[][] map, int dir, Pair pair) {
		if (pair.kind == 1) {
			switch (dir) {
			case 0:
				for (int i = pair.x-1; i >= 0; i--) {
					if (map[pair.y][i] == 6) break;
					map[pair.y][i] = 7;
				}
				return map;
			case 1:
				for (int i = pair.y-1; i >= 0; i--) {
					if (map[i][pair.x] == 6) break;
					map[i][pair.x] = 7;
				}
				return map;
			case 2:
				for (int i = pair.x+1; i < m; i++) {
					if (map[pair.y][i] == 6) break;
					map[pair.y][i] = 7;
				}
				return map;
			case 3:
				for (int i = pair.y+1; i < n; i++) {
					if (map[i][pair.x] == 6) break;
					map[i][pair.x] = 7;
				}
				return map;
			default:
				return map;
			}
		} 
		//0 <-> 1 up down
		if (pair.kind == 2) {
			switch (dir) {
			case 0:
				for (int i = pair.x+1; i < m; i++) {
					if (map[pair.y][i] == 6) break;
					map[pair.y][i] = 7;
				}
				for (int i = pair.x-1; i >= 0; i--) {
					if (map[pair.y][i] == 6) break;
					map[pair.y][i] = 7;
				}
				return map;
				
			case 1:
				for (int i = pair.y+1; i < n; i++) {
					if (map[i][pair.x] == 6) break;
					map[i][pair.x] = 7;
				}
				for (int i = pair.y-1; i >= 0; i--) {
					if (map[i][pair.x] == 6) break;
					map[i][pair.x] = 7;
				}
				return map;
			case 2:
				for (int i = pair.y+1; i < n; i++) {
					if (map[i][pair.x] == 6) break;
					map[i][pair.x] = 7;
				}
				for (int i = pair.y-1; i >= 0; i--) {
					if (map[i][pair.x] == 6) break;
					map[i][pair.x] = 7;
				}
				return map;
			case 3:
				for (int i = pair.x+1; i < m; i++) {
					if (map[pair.y][i] == 6) break;
					map[pair.y][i] = 7;
				}
				for (int i = pair.x-1; i >= 0; i--) {
					if (map[pair.y][i] == 6) break;
					map[pair.y][i] = 7;
				}
				return map;
				
			default:
				break;
			}
		} else if (pair.kind == 3) {
			switch (dir) {
			case 0:
				for (int i = pair.y+1; i < n; i++) {
					if (map[i][pair.x] == 6) break;
					map[i][pair.x] = 7;
				}
				for (int i = pair.x+1; i < m; i++) {
					if (map[pair.y][i] == 6) break;
					map[pair.y][i] = 7;
				}
				break;
			case 1:
				for (int i = pair.y+1; i < map.length; i++) {
					if (map[i][pair.x] == 6) break;
					map[i][pair.x] = 7;
				}
				for (int i = pair.x-1; i >= 0; i--) {
					if (map[pair.y][i] == 6) break;
					map[pair.y][i] = 7;
				}
				break;
			case 2:
				for (int i = pair.x-1; i >= 0; i--) {
					if (map[pair.y][i] == 6) break;
					map[pair.y][i] = 7;
				}
				for (int i = pair.y-1; i >= 0; i--) {
					if (map[i][pair.x] == 6) break;
					map[i][pair.x] = 7;
				}
				break;
			case 3:
				for (int i = pair.y-1; i >= 0; i--) {
					if (map[i][pair.x] == 6) break;
					map[i][pair.x] = 7;
				}
				for (int i = pair.x+1; i < m; i++) {
					if (map[pair.y][i] == 6) break;
					map[pair.y][i] = 7;
				}
				break;
			default:
				return map;
			}
		} else if (pair.kind == 4) {
			switch (dir) {
			case 0:
				for (int i = pair.x+1; i < m; i++) {
					if (map[pair.y][i] == 6) break;
					map[pair.y][i] = 7;
				}
				for (int i = pair.y+1; i < n; i++) {
					if (map[i][pair.x] == 6) break;
					map[i][pair.x] = 7;
				}
				for (int i = pair.x-1; i >= 0; i--) {
					if (map[pair.y][i] == 6) break;
					map[pair.y][i] = 7;
				}
				break;
			case 1:
				for (int i = pair.y-1; i >= 0; i--) {
					if (map[i][pair.x] == 6) break;
					map[i][pair.x] = 7;
				}
				for (int i = pair.y+1; i < n; i++) {
					if (map[i][pair.x] == 6) break;
					map[i][pair.x] = 7;
				}
				for (int i = pair.x-1; i >= 0; i--) {
					if (map[pair.y][i] == 6) break;
					map[pair.y][i] = 7;
				}
				break;
			case 2:
				for (int i = pair.y-1; i >= 0; i--) {
					if (map[i][pair.x] == 6) break;
					map[i][pair.x] = 7;
				}
				for (int i = pair.x+1; i < m; i++) {
					if (map[pair.y][i] == 6) break;
					map[pair.y][i] = 7;
				}
				for (int i = pair.x-1; i >= 0; i--) {
					if (map[pair.y][i] == 6) break;
					map[pair.y][i] = 7;
				}
				break;
			case 3:
				for (int i = pair.y-1; i >= 0; i--) {
					if (map[i][pair.x] == 6) break;
					map[i][pair.x] = 7;
				}
				for (int i = pair.x+1; i < m; i++) {
					if (map[pair.y][i] == 6) break;
					map[pair.y][i] = 7;
				}
				for (int i = pair.y+1; i < n; i++) {
					if (map[i][pair.x] == 6) break;
					map[i][pair.x] = 7;
				}
				break;
			default:
				break;
			}
		} else if (pair.kind == 5) {
			for (int i = pair.y-1; i >= 0; i--) {
				if (map[i][pair.x] == 6) break;
				map[i][pair.x] = 7;
			}
			for (int i = pair.x+1; i < m; i++) {
				if (map[pair.y][i] == 6) break;
				map[pair.y][i] = 7;
			}
			for (int i = pair.y+1; i < n; i++) {
				if (map[i][pair.x] == 6) break;
				map[i][pair.x] = 7;
			}
			for (int i = pair.x-1; i >= 0; i--) {
				if (map[pair.y][i] == 6) break;
				map[pair.y][i] = 7;
			}
		}
		return map;
	}
	public static void check0(int[][] map) {
		int tmp = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					tmp = tmp + 1;
				}
			}
		}
		if (tmp < output) {
			output = tmp;
		}
	}
}
class Pair {
	int x, y, kind;
	public Pair(int y, int x, int kind) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.kind = kind;
	}
}