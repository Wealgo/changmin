import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int garo, sero;
	
	public static void main(String[] args) throws IOException {
		char map[][];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		map = new char[sero][garo];
		for (int i = 0; i < sero; i++) {
			String str = br.readLine();
			for (int j = 0; j < garo; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		bfs(map);
	}
	
	public static int bfs(char[][] map) {
		Struct s = new Struct(map, 0);
		LinkedList<Struct> list = new LinkedList<>();
		list.addLast(s);
		int output = -1;
		while (!list.isEmpty()) {
			s = list.pollFirst();
			if (list.size() > 500) {
				break;
			}
			Struct tmp = up(s);
			if (!tmp.isMang) {
				if (tmp.isGoal) {
					return tmp.time;
				} else {
					list.addLast(tmp);
				}
			}
				
			tmp = down(s);
			if (!tmp.isMang) {
				if (tmp.isGoal) {
					return tmp.time;
				} else {
					list.addLast(tmp);
				}
			}
			
			tmp = right(s);
			if (!tmp.isMang) {
				if (tmp.isGoal) {
					return tmp.time;
				} else {
					list.addLast(tmp);
				}
			}
			
			tmp = left(s);
			if (!tmp.isMang) {
				if (tmp.isGoal) {
					return tmp.time;
				} else {
					list.addLast(tmp);
				}
			}
		}
		return output;
	}
	public static Struct up(Struct s) {
		
		char[][] map = s.map;
		int time = s.time;
		Struct output = new Struct();
		LinkedList<Integer> Ball = findB(map);
		LinkedList<Integer> Rall = findR(map);
		map[Ball.get(0)][Ball.get(1)] = '.';
		map[Rall.get(0)][Rall.get(1)] = '.';
		if (Ball.get(0) > Rall.get(0)) {
			//R먼저.
			for (int i = 0; i < sero; i++) {
				if (map[Rall.get(0)-i][Rall.get(1)] == 'O') {
					output.isGoal = true;
					break;
				}
				if (map[Rall.get(0)-i][Rall.get(1)] == '#') {
					map[Rall.get(0)-i+1][Rall.get(1)] = 'R';
					break;
				}
			}
			
			for (int i = 0; i < sero; i++) {
				if (map[Ball.get(0)-i][Ball.get(1)] == 'O') {
					output.isMang = true;
					break;
				}
				if (map[Ball.get(0)-i][Ball.get(1)] == '#') {
					map[Ball.get(0)-i+1][Ball.get(1)] = 'B';
					break;
				}
				if (map[Ball.get(0)-i][Ball.get(1)] == 'R') {
					map[Ball.get(0)-i+1][Ball.get(1)] = 'B';
					break;
				}
			}
		} else {
			//B먼저.
			for (int i = 0; i < sero; i++) {
				if (map[Ball.get(0)-i][Ball.get(1)] == 'O') {
					output.isMang = true;
					break;
				}
				if (map[Ball.get(0)-i][Ball.get(1)] == '#') {
					map[Ball.get(0)-i+1][Ball.get(1)] = 'B';
					break;
				}
			}
			for (int i = 0; i < sero; i++) {
				if (map[Rall.get(0)-i][Rall.get(1)] == 'O') {
					output.isGoal = true;
					break;
				}
				if (map[Rall.get(0)-i][Rall.get(1)] == '#') {
					map[Rall.get(0)-i+1][Rall.get(1)] = 'R';
					break;
				}
				if (map[Rall.get(0)-i][Rall.get(1)] == 'B') {
					map[Rall.get(0)-i+1][Rall.get(1)] = 'R';
					break;
				}
			}
		}
		output.map = map;
		output.time = time + 1;
		System.out.println("up");
		System.out.println(output.time);
		printmap(output.map);
		return output;
	}
	public static Struct down(Struct s) {
		char[][] map = s.map;
		int time = s.time;
		Struct output = new Struct();
		LinkedList<Integer> Ball = findB(map);
		LinkedList<Integer> Rall = findR(map);
		map[Ball.get(0)][Ball.get(1)] = '.';
		map[Rall.get(0)][Rall.get(1)] = '.';
		if (Ball.get(0) < Rall.get(0)) {
			//R먼저.
			for (int i = 0; i < sero; i++) {
				if (map[Rall.get(0)+i][Rall.get(1)] == 'O') {
					output.isGoal = true;
					break;
				}
				if (map[Rall.get(0)+i][Rall.get(1)] == '#') {
					map[Rall.get(0)+i-1][Rall.get(1)] = 'R';
					break;
				}
			}
			
			for (int i = 0; i < sero; i++) {
				if (map[Ball.get(0)+i][Ball.get(1)] == 'O') {
					output.isMang = true;
					break;
				}
				if (map[Ball.get(0)+i][Ball.get(1)] == '#') {
					map[Ball.get(0)+i-1][Ball.get(1)] = 'B';
					break;
				}
				if (map[Ball.get(0)+i][Ball.get(1)] == 'R') {
					map[Ball.get(0)+i-1][Ball.get(1)] = 'B';
					break;
				}
			}
		} else {
			//B먼저.
			for (int i = 0; i < sero; i++) {
				if (map[Ball.get(0)+i][Ball.get(1)] == 'O') {
					output.isMang = true;
					break;
				}
				if (map[Ball.get(0)+i][Ball.get(1)] == '#') {
					map[Ball.get(0)+i-1][Ball.get(1)] = 'B';
					break;
				}
			}
			for (int i = 0; i < sero; i++) {
				if (map[Rall.get(0)+i][Rall.get(1)] == 'O') {
					output.isGoal = true;
					break;
				}
				if (map[Rall.get(0)+i][Rall.get(1)] == '#') {
					map[Rall.get(0)+i-1][Rall.get(1)] = 'R';
					break;
				}
				if (map[Rall.get(0)+i][Rall.get(1)] == 'B') {
					map[Rall.get(0)+i-1][Rall.get(1)] = 'R';
					break;
				}
			}
		}
		output.map = map;
		output.time = time + 1;
		System.out.println("down");
		System.out.println(output.time);
		printmap(output.map);
		return output;
	}
	public static Struct right(Struct s) {
		char[][] map = s.map;
		int time = s.time;
		Struct output = new Struct();
		LinkedList<Integer> Ball = findB(map);
		LinkedList<Integer> Rall = findR(map);
		map[Ball.get(0)][Ball.get(1)] = '.';
		map[Rall.get(0)][Rall.get(1)] = '.';
		if (Ball.get(1) < Rall.get(1)) {
			//R먼저.
			for (int i = 0; i < sero; i++) {
				if (map[Rall.get(0)][Rall.get(1)+i] == 'O') {
					output.isGoal = true;
					break;
				}
				if (map[Rall.get(0)][Rall.get(1)+i] == '#') {
					map[Rall.get(0)][Rall.get(1)+i-1] = 'R';
					break;
				}
			}
			
			for (int i = 0; i < sero; i++) {
				if (map[Ball.get(0)][Ball.get(1)+i] == 'O') {
					output.isMang = true;
					break;
				}
				if (map[Ball.get(0)][Ball.get(1)+i] == '#') {
					map[Ball.get(0)][Ball.get(1)+i-1] = 'B';
					break;
				}
				if (map[Ball.get(0)][Ball.get(1)+i] == 'R') {
					map[Ball.get(0)][Ball.get(1)+i-1] = 'B';
					break;
				}
			}
		} else {
			//B먼저.
			for (int i = 0; i < sero; i++) {
				if (map[Ball.get(0)][Ball.get(1)+i] == 'O') {
					output.isMang = true;
					break;
				}
				if (map[Ball.get(0)][Ball.get(1)+i] == '#') {
					map[Ball.get(0)][Ball.get(1)+i-1] = 'B';
					break;
				}
			}
			for (int i = 0; i < sero; i++) {
				if (map[Rall.get(0)][Rall.get(1)+i] == 'O') {
					output.isGoal = true;
					break;
				}
				if (map[Rall.get(0)][Rall.get(1)+i] == '#') {
					map[Rall.get(0)][Rall.get(1)+i-1] = 'R';
					break;
				}
				if (map[Rall.get(0)][Rall.get(1)+i] == 'B') {
					map[Rall.get(0)][Rall.get(1)+i-1] = 'R';
					break;
				}
			}
		}
		output.map = map;
		output.time = time + 1;
		System.out.println("right");
		System.out.println(output.time);
		printmap(output.map);
		return output;
	}
	public static Struct left(Struct s) {
		char[][] map = s.map;
		int time = s.time;
		Struct output = new Struct();
		LinkedList<Integer> Ball = findB(map);
		LinkedList<Integer> Rall = findR(map);
		map[Ball.get(0)][Ball.get(1)] = '.';
		map[Rall.get(0)][Rall.get(1)] = '.';
		if (Ball.get(1) > Rall.get(1)) {
			//R먼저.
			for (int i = 0; i < sero; i++) {
				if (map[Rall.get(0)][Rall.get(1)-i] == 'O') {
					output.isGoal = true;
					break;
				}
				if (map[Rall.get(0)][Rall.get(1)-i] == '#') {
					map[Rall.get(0)][Rall.get(1)-i+1] = 'R';
					break;
				}
			}
			
			for (int i = 0; i < sero; i++) {
				if (map[Ball.get(0)][Ball.get(1)-i] == 'O') {
					output.isMang = true;
					break;
				}
				if (map[Ball.get(0)][Ball.get(1)-i] == '#') {
					map[Ball.get(0)][Ball.get(1)-i+1] = 'B';
					break;
				}
				if (map[Ball.get(0)][Ball.get(1)-i] == 'R') {
					map[Ball.get(0)][Ball.get(1)-i+1] = 'B';
					break;
				}
			}
		} else {
			//B먼저.
			for (int i = 0; i < sero; i++) {
				if (map[Ball.get(0)][Ball.get(1)-i] == 'O') {
					output.isMang = true;
					break;
				}
				if (map[Ball.get(0)][Ball.get(1)-i] == '#') {
					map[Ball.get(0)][Ball.get(1)-i+1] = 'B';
					break;
				}
			}
			for (int i = 0; i < sero; i++) {
				if (map[Rall.get(0)][Rall.get(1)-i] == 'O') {
					output.isGoal = true;
					break;
				}
				if (map[Rall.get(0)][Rall.get(1)-i] == '#') {
					map[Rall.get(0)][Rall.get(1)-i+1] = 'R';
					break;
				}
				if (map[Rall.get(0)][Rall.get(1)-i] == 'B') {
					map[Rall.get(0)][Rall.get(1)-i+1] = 'R';
					break;
				}
			}
		}
		output.map = map;
		output.time = time + 1;
		System.out.println("left");
		System.out.println(output.time);
		printmap(output.map);
		return output;
	}
	public static LinkedList<Integer> findB(char[][] map) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 'B') {
					list.add(i);
					list.add(j);
					return list;
				}
			}
		}
		return list;
	}
	public static LinkedList<Integer> findR(char[][] map) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 'R') {
					list.add(i);
					list.add(j);
					return list;
				}
			}
		}
		return list;
	}
	public static void printmap(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}

class Struct {
	char[][] map;
	int time;
	boolean isGoal = false;
	boolean isMang = false;
	public Struct() {
		// TODO Auto-generated constructor stub
	}
	public Struct(char[][] map, int time) {
		// TODO Auto-generated constructor stub
		this.map = map;
		this.time = time;
	}
	public Struct(char[][] map, int time, boolean isGoal, boolean isMang) {
		// TODO Auto-generated constructor stub
		this.map = map;
		this.time = time;
		this.isGoal = isGoal;
		this.isMang = isMang;
	}
}