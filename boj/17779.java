import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
	public static int n;
	public static int y,x;
	public static int d1, d2;
	public static int[][] garry;
	public static int[][] map;
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
//		y = 1; x = 4; d1 = 3; d2 = 2;
		y = 3; x = 2; d1 = 1; d2 = 1;
		garry();
		print(garry);
	}
	public static void garry() {
		//1
		int cnt = 0;
		for (int i = 0; i < y + Math.max(d1, d2); i++) {
			if (y <= i) cnt++;
			for (int j = 0; j <= x - cnt; j++) {
				garry[i][j] = 1;
			}
		}
		//2
		cnt = 0;
		for (int i = 0; i < y + Math.max(d1, d2)+1; i++) {
			for (int j = x + cnt+1; j < n; j++) {
				garry[i][j] = 2;
			}
			if (y <= i) cnt++;
		}
		//3
		cnt = 0;
		for (int i = y + Math.max(d1, d2); i < n; i++) {
			if (y < i) cnt++;
			for (int j = 0; j < x-d1 + cnt; j++) {
				garry[i][j] = 3;
			}
		}
	}
	public static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void section() {
		for (int i = 0; i < n-1; i++) {
			for (int j = 1; j < n-1; j++) {
				y = i;
				x = j;
				findJ();
			}
		}
	}
	public static void findJ() {
		for (int i = x-1; i > 0; i--) {
			for (int j = x+1; j <= n; j++) {
				d1 = i;
				d2 = j;
				garry = new int[n][n];
				garry();
			}
		}
	}
	
}