import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * 제한시간 1초
 * 맵은 300이하 -> 300x300 크기의 맵.
 * 
 */
public class Main{
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1,-1,0,0};
	public static int garo;
	public static int sero;
	public static int year = 0;
	public static int[][] map;
	public static int[][] check;
	public static boolean[][] check2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sero = sc.nextInt();
		garo = sc.nextInt();
		map = new int[sero][garo];
		
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		
		while (check() == -1) {
			decrease();
			check();
		}
		System.out.println(check());
		/**/
	}
	public static int check() {
		LinkedList<Integer> list = new LinkedList<>();
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[0].length; x++) {
				if (map[y][x] > 0) {
					list.add(y);
					list.add(x);
				}
			}
		}
		if (list.isEmpty()) {
			return 0;
		}
		check2 = new boolean[sero][garo];
		dfs(list.getFirst(), list.get(1));
		//삥삥 다돌앗는데 1덩이야!
		//그러면 -1;
		//두덩이야!
		//그러면 year;
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[0].length; x++) {
				if (check2[y][x] == false && map[y][x] > 0) {
					return year;
				}
			}
		}
		return -1;
	}
	public static void dfs(int y, int x) {
		check2[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < sero && ny >= 0 && nx < garo && nx >= 0) {
				if (map[ny][nx] > 0 && check2[ny][nx] == false) {
					dfs(ny, nx);
				}
			}
		}
	}
	public static void decrease() {
		check = new int[sero][garo];
		for (int y = 0; y < check.length; y++) {
			for (int x = 0; x < check[0].length; x++) {
				if (map[y][x] > 0) {
					for (int i = 0; i < 4; i++) {
						int ny = y + dy[i];
						int nx = x + dx[i];
						if (ny < sero && ny >= 0 && nx < garo && nx >= 0) {
							if (map[ny][nx] == 0) {
								check[y][x]++;
							}
						}
					}
				}	
			}
		}
		for (int y = 0; y < check.length; y++) {
			for (int x = 0; x < check[0].length; x++) {
				if (map[y][x] - check[y][x] < 0) {
					map[y][x] = 0;
				} else {
					map[y][x] = map[y][x] - check[y][x];
				}
			}
		}
		year++;
	}
}

