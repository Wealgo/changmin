import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 시뮬레이션의 향연.
 * 기능별로 나누고 해보자.
 * @author quadcore
 *
 */
class Main {
	public static int n;
	public static int y,x;
	public static int d1, d2;
	public static int[][] garry;
	public static int[][] map;
	public static int answer = 9999;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		garry = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		section();
		System.out.println(answer);
	}
	
	public static void garry() {
		int cnt = 0;
		for (int i = 0; i < y + d1; i++) {
			if (i >= y) cnt++;
			for (int j = 0; j < x - cnt + 1; j++) {
				garry[i][j] = 1;
			}
		}
		cnt = 0;
		for (int i = 0; i < y + d2+1; i++) {
			if (i > y) cnt++;
			for (int j = x+cnt+1; j < n; j++) {
				garry[i][j] = 2;
			}
		}
		cnt = 0;
		for (int i = n-1; i > y + d1-1; i--) {
			if (y+d1+d2 > i) cnt++;
			for (int j = 0; j < x -(d1 - d2) - cnt; j++) {
				garry[i][j] = 3;
			}
		}
		cnt = 0;
		for (int i = n -1; i > y + d2; i--) {
			if (i <= y+d1+d2) cnt++;
			for (int j = x + (d2- d1)+ cnt; j < n; j++) {
				garry[i][j] = 4;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (garry[i][j] == 0) garry[i][j] = 5;
			}
		}
		cnt();
	}
	public static void section() {
		for (int i = 0; i < n-2; i++) {
			for (int j = 1; j < n-1; j++) {
				y = i;
				x = j;
				findJ();
			}
		}
	}
	public static void findJ() {
		for (int i = 1; i < x+1; i++) {
			for (int j = 1; j < n-x; j++) {
				d1 = i;
				d2 = j;
				if (d2 >= n-y) continue;
				if (d1 >= n-y) continue;
				garry = new int[n][n];
				garry();		
			}
		}
	}

	public static void cnt() {
		int[] arr = new int[5];
		for (int i = 0; i < garry.length; i++) {
			for (int j = 0; j < garry.length; j++) {
				if (garry[i][j] == 1) arr[0]+= map[i][j];
				if (garry[i][j] == 2) arr[1]+= map[i][j];
				if (garry[i][j] == 3) arr[2]+= map[i][j];
				if (garry[i][j] == 4) arr[3]+= map[i][j];
				if (garry[i][j] == 5) arr[4]+= map[i][j];
			}
		}
		Arrays.sort(arr);
		int cnt = arr[4] - arr[0];
		answer = Math.min(answer, cnt);
	}
}