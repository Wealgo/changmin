import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 맵 탐색할때 끝부분 처리 잘해줄것
 * ex) x > 0 -> x >= 0 등등.
 * @author quadcore
 *
 */
public class Main{
	public static int max = 0;
	public static int sero;
	public static int garo;
	public static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		map = new int[sero][garo];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				jjick(i, j);
				not(i, j);
				jumuk(i, j);
				fuck(i, j);
				thund(i, j);
				thund2(i, j);
			}
		}
		System.out.println(max);
	}
	public static void jjick(int y, int x) {
		if (y+3 < sero) {
			int tmp = 0;
			for (int i = 0; i < 4; i++) {
				tmp = map[y+i][x] + tmp;
			}
			if (max < tmp) {
				max = tmp;
			}
		}
		if (y-3 > 0) {
			int tmp = 0;
			for (int i = 0; i < 4; i++) {
				tmp = tmp + map[y-i][x];
			}
			if (max < tmp) {
				max = tmp;
			}
		}
		if (x+3 < garo) {

			int tmp  = 0;
			for (int i = 0; i < 4; i++) {
				tmp = tmp + map[y][x+i];
			}
			if (max < tmp) {
				max = tmp;
			}
		}
		if (x-3 > 0) {
			int tmp = 0;
			for (int i = 0; i < 4; i++) {
				tmp = tmp + map[y][x-i];
			}
			if (max < tmp) {
				max = tmp;
			}
		}
	}
	public static void not(int y, int x) {
		if (y + 2 < sero && x + 1 < garo) {
			int tmp = 0;
			for (int i = 0; i < 3; i++) {
				tmp = tmp + map[y+i][x];
			}
			tmp = tmp + map[y+2][x+1];
			if (max < tmp) {
				max = tmp;
			}
		}
		if (y + 2 < sero && x - 1 >= 0) {
			int tmp = 0;
			for (int i = 0; i < 3; i++) {
				tmp = tmp + map[y+i][x];
			}
			tmp = tmp + map[y+2][x-1];
			if (max < tmp) {
				max = tmp;
			}
		}
		if (y - 2 >= 0 && x + 1 < garo) {
			int tmp = 0;
			for (int i = 0; i < 3; i++) {
				tmp = tmp + map[y-i][x];
			}
			tmp = tmp + map[y-2][x+1];
			if (max < tmp) {
				max = tmp;
			}
		}
		if (y - 2 >= 0 && x - 1 >= 0) {
			int tmp = 0;
			for (int i = 0; i < 3; i++) {
				tmp = tmp + map[y-i][x];
			}
			tmp = tmp + map[y-2][x-1];
			if (max < tmp) {
				max = tmp;
			}
		}
		if (x + 2 < garo && y + 1 < sero) {
			int tmp = 0;
			for (int i = 0; i < 3; i++) {
				tmp = tmp + map[y][x+i];
			}
			tmp = tmp + map[y+1][x+2];
			if (max < tmp) {
				max = tmp;
			}
		}
		if (x + 2 < garo && y - 1 >= 0) {
			int tmp = 0;
			for (int i = 0; i < 3; i++) {
				tmp = tmp + map[y][x+i];
			}
			tmp = tmp + map[y-1][x+2];
			if (max < tmp) {
				max = tmp;
			}
		}
		if (x - 2 >= 0 && y + 1 < sero) {
			int tmp = 0;
			for (int i = 0; i < 3; i++) {
				tmp = tmp + map[y][x-i];
			}
			tmp = tmp + map[y+1][x-2];
			if (max<tmp) {
				max = tmp;
			}
		}
		if (x - 2 >= 0 && y - 1 >= 0) {
			int tmp = 0;
			for (int i = 0; i < 3; i++) {
				tmp = tmp + map[y][x-i];
			}
			tmp = tmp + map[y-1][x-2];
			if (max<tmp) {
				max = tmp;
			}
		}
	}
	public static void jumuk(int y, int x) {
		if (x + 1 < garo && y + 1 < sero) {
			int tmp = 0;
			tmp = map[y][x] + map[y+1][x] + map[y][x+1] + map[y+1][x+1];
			if (max < tmp) {
				max = tmp;
			}
		}
		if (x + 1 < garo && y - 1 >= 0) {
			int tmp = 0;
			tmp = map[y][x] + map[y-1][x] + map[y][x+1] + map[y-1][x+1];
			if (max < tmp) {
				max = tmp;
			}
		}
		if (x - 1 >= 0 && y + 1 < sero) {
			int tmp = 0;
			tmp = map[y][x] + map[y+1][x] + map[y][x-1] + map[y+1][x-1];
			if (max < tmp) {
				max = tmp;
			}
		}
		if (x - 1 >= 0 && y - 1 >= 0) {
			int tmp = 0;
			tmp = map[y][x] + map[y-1][x] + map[y][x-1] + map[y-1][x-1];
			if (max < tmp) {
				max = tmp;
			}
		}
	}
	public static void fuck(int y, int x) {
		//4개만하면되.
		if (y - 1 >= 0 && x - 1 >= 0 && x + 1 < garo) {
			int tmp = 0;
			tmp = map[y][x] + map[y-1][x] + map[y-1][x-1] + map[y-1][x+1];
			if (max < tmp) {
				max = tmp;
			}
		}
		if (y + 1 < sero && x - 1 >= 0 && x + 1 < garo) {
			int tmp = 0;
			tmp = map[y][x] + map[y+1][x] + map[y+1][x-1] + map[y+1][x+1];
			if (max < tmp) {
				max = tmp;
			}
		}
		if (x + 1 < garo && y + 1 < sero && y - 1 >= 0) {
			int tmp = 0;
			tmp = map[y][x] + map[y][x+1] + map[y-1][x+1] + map[y+1][x+1];
			if (max < tmp) {
				max = tmp;
			}
		}
		if (x - 1 >= 0 && y + 1 < sero && y - 1 >= 0) {
			int tmp = 0;
			tmp = map[y][x] + map[y][x-1] + map[y+1][x-1] + map[y-1][x-1];
			if (max < tmp) {
				max = tmp;
			}
		}
	}
	public static void thund(int y, int x) {
		//8개ㅠ
		if (y - 2 >= 0) {
			if (x + 1 < garo) {
				int tmp = 0;
				tmp = map[y][x] + map[y-1][x] + map[y-1][x+1] + map[y-2][x+1];
				if (max < tmp) {
					max = tmp;
				}
			}
			if (x - 1 >= 0) {
				int tmp = 0;
				tmp = map[y][x] + map[y-1][x] + map[y-1][x-1] + map[y-2][x-1];
				if (max < tmp) {
					max = tmp;
				}
			}
		}
		if (y + 2 < sero) {
			if (x + 1 < garo) {
				int tmp = 0;
				tmp = map[y][x] + map[y+1][x] + map[y+1][x+1] + map[y+2][x+1];
				if (max < tmp) {
					max = tmp;
				}
			}
			if (x - 1 >= 0) {
				int tmp = 0;
				tmp = map[y][x] + map[y+1][x] + map[y+1][x-1] + map[y+2][x-1];
				if (max < tmp) {
					max = tmp;
				}
			}
		}
		if (x +2 < garo) {
			if (y + 1 < sero) {
				int tmp = 0;
				tmp = map[y][x] + map[y][x+1] + map[y+1][x+1] + map[y+1][x+2];
				if (max < tmp) {
					max = tmp;
				}
			}
			if (y - 1 >= 0) {
				int tmp = 0;
				tmp = map[y][x] + map[y][x+1] + map[y-1][x+1] + map[y-1][x+2];
				if (max < tmp) {
					max = tmp;
				}
			}
		}
		if (x - 2 >= 0) {
			if (y + 1 < sero) {
				int tmp = 0;
				tmp = map[y][x] + map[y][x-1] + map[y+1][x-1] + map[y+1][x-2];
				if (max < tmp) {
					max = tmp;
				}
			}
			if (y - 1 >= 0) {
				int tmp = 0;
				tmp = map[y][x] + map[y][x-1] + map[y-1][x-1] + map[y-1][x-2];
				if (max < tmp) {
					max = tmp;
				}
			}
		}
	}
	public static void thund2(int y, int x) {
		if (y - 3 > 0) {
			if (x - 1 >= 0) {
				int tmp = 0;
				tmp = map[y][x] + map[y][x-1] + map[y-1][x-1] + map[y-2][x-1];
				if (max < tmp) {
					max = tmp;
				}
			}
			if (x + 1 < garo) {
				int tmp = 0;
				tmp = map[y][x] + map[y][x+1] + map[y-1][x+1] + map[y-2][x+1];
				if (max < tmp) {
					max = tmp;
				}
			}
		}
		//하.
		if (y + 3 < sero && x - 1 >= 0) {
			int tmp = 0;
			tmp = map[y][x] + map[y][x-1] + map[y+1][x-1] + map[y+2][x-1];
			if (max < tmp) {
				max = tmp;
			}
		}
		if (y + 3 < sero && x + 1 < garo) {
			int tmp = 0;
			tmp = map[y][x] + map[y][x+1] + map[y+1][x+1] + map[y+2][x+1];
			if (max < tmp) {
				max = tmp;
			}
		}
		if (x - 3 >= 0) {
			if (y - 1 >= 0) {
				int tmp = 0;
				tmp = map[y][x] + map[y-1][x] + map[y-1][x-1] + map[y-1][x-2];
				if (max < tmp) {
					max = tmp;
				}
			}
			if (y + 1 < sero) {
				int tmp = 0;
				tmp = map[y][x] + map[y+1][x] + map[y+1][x-1] + map[y+1][x-2];
				if (max < tmp) {
					max = tmp;
				}
			}
			
		}
		if (x + 3 < garo) {
			if (y - 1 >= 0) {
				int tmp = 0;
				tmp = map[y][x] + map[y-1][x] + map[y-1][x+1] + map[y-1][x+2];
				if (max < tmp) {
					max = tmp;
				}
			}
			if (y + 1 < sero) {
				int tmp = 0;
				tmp = map[y][x] + map[y+1][x] + map[y+1][x+1] + map[y+1][x+2];
				if (max < tmp) {
					max = tmp;
				}
			}
		}
	}
}
