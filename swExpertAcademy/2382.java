import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
	public static int n,m,k;	//셀의 개수 n, 격리시간m, 미생물군집갯수 k;
	public static boolean visited[][];
	public static int output = 0;
	public static LinkedList<Cell> list = new LinkedList<>();
	public static void main(String[] args) {
		//입력받고~
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		int testcase = Integer.parseInt(sc.nextLine());
		for (int t = 0; t < testcase; t++) {
			st = new StringTokenizer(sc.nextLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			list = new LinkedList<>();
			output = 0;
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(sc.nextLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				Cell c =new Cell(y, x, v, dir);
				list.add(c);
			}
			for (int i = 0; i < m; i++) {
				move();
				drug();
				hap();
			}
			for (int i = 0; i < list.size(); i++) {
				output = output + list.get(i).v;
			}
			System.out.println("#"+(t+1)+" "+output);
		}
	}
	public static void move() {
		LinkedList<Cell> newList = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			Cell c = list.get(i);
			int x = c.x, y = c.y, v = c.v, dir = c.dir;
			if (dir == 1) {
				y = y - 1;
			} else if (dir == 2) {
				y = y + 1;
			} else if (dir == 3) {
				x = x - 1;
			} else if (dir == 4) {
				x = x + 1;
			}
			newList.add(new Cell(y, x, v, dir));
		}
		list = new LinkedList<>();
		list.addAll(newList);
	}
	public static void drug() {
		LinkedList<Cell> newList = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			Cell c = list.get(i);
			int x = c.x, y = c.y, dir = c.dir, v = c.v;
			if (x==0||x==n-1||y==0||y==n-1) {
				if (v%2 == 1) v = v - 1;
				v = v / 2;
				if (dir == 1) {
					dir = 2;
				} else if (dir == 2) {
					dir = 1;
				} else if (dir == 3) {
					dir = 4;
				} else if (dir == 4) {
					dir = 3;
				}
			}
			newList.add(new Cell(y, x, v, dir));
		}
		list = new LinkedList<>();
		list.addAll(newList);
	}
	public static void hap() {
		boolean check[][] = new boolean[n][n];
		LinkedList<Pair> plist = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			Cell c = list.get(i);
			int x = c.x, y = c.y;
			if (check[y][x]) {
				plist.add(new Pair(y, x));
			}
			check[y][x] = true;
		}
		for (int i = 0; i < plist.size(); i++) {
			Pair p = plist.get(i);
			int y = p.y, x = p.x;
			LinkedList<Cell> hlist = new LinkedList<>();
			for (int j = 0; j < list.size(); j++) {
				Cell c = list.get(j);
				int mx = c.x, my = c.y;
				if (x == mx && y == my) {
					hlist.add(list.remove(j));
					j--;
				}
			}
			Collections.sort(hlist);
			int dir = hlist.getFirst().dir;
			int v = 0;
			for (int j = 0; j < hlist.size(); j++) {
				v = v + hlist.get(j).v;
			}
			list.add(new Cell(hlist.getFirst().y, hlist.getFirst().x, v, dir));
		}
	}
}
class Cell implements Comparable<Cell>{
	int y,x,v,dir;
	public Cell(int y, int x, int v, int dir) {
		// TODO Auto-generated constructor stub
		this.y = y; this.x = x; this.v = v; this.dir = dir;
	}
	@Override
	public int compareTo(Cell o) {
		// TODO Auto-generated method stub
		return o.v - this.v;
	}
}
class Pair {
	int y, x;
	public Pair(int y, int x) {
		// TODO Auto-generated constructor stub
		this.x = x; this.y = y;
	}
}