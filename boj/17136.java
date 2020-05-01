import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백트레킹의 향연
 */
public class Main {
	public static int[] papers = {0,5,5,5,5,4};
	public static boolean[][] map;
	public static int answer = 9999;
	public static void main(String[] args) throws Exception {
    	// 입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	map = new boolean[10][10];
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				if (st.nextToken().equals("1")) map[i][j] = true;
			}
		}
		if (isClear()) {
			System.out.println(0);
			return;
		}
		back(0, 0);
		if (answer == 9999) {
			System.out.println(-1);
			return;
		}
    	System.out.println(answer);
	}
	
	public static void back(int idx, int cnt) {
		System.out.println(idx+":"+cnt);
		if (answer != 9999) return;
		if (isClear()) {
			answer = Math.min(cnt, answer);
			return;
		}
		for (int i = idx; i < 100; i++) {
			int y = i / 10;
			int x = i % 10;
			if (!map[y][x]) continue;
			for (int k = 5; k >= 1; k--) {
				if (papers[k] < 1) continue;
				if (!isAttach(y, x, k)) continue;
				papers[k]--;
				attach(y, x, k, false);
				back(i+1, cnt+1);
				papers[k]++;
				attach(y, x, k, true);
			}
		}
	}
	
	public static boolean isAttach(int y, int x, int cnt) {
		for (int i = y; i < y + cnt; i++) {
			for (int j = x; j < x + cnt; j++) {
				if (i >= 10 || j >= 10) return false;
				if (!map[i][j]) return false;
			}
		}
		return true;
	}
	
	public static void attach(int y, int x, int cnt, boolean b) {
		for (int i = y; i < y + cnt; i++) {
			for (int j = x; j < x + cnt; j++) {
				map[i][j] = b;
			}
		}
	}
	public static boolean isClear() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j]) return false;
			}
		}
		return true;
	}
	public static void printP() {
		for (int i = 0; i < papers.length; i++) {
			System.out.print(papers[i]);
		}
		System.out.println();
	}
	public static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
//				System.out.print(map[i][j] + " ");
				if (map[i][j]) System.out.print(1 + " ");
				else System.out.print(0 + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
