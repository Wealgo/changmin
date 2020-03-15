import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 제발 가즈아~!
 * @author quadcore
 *
 */
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
		System.out.println(bfs(map));
	}
	public static int bfs(char[][] map) {
		Struct first = new Struct(map, map, 0);
		LinkedList<Struct> list = new LinkedList<>();
		list.add(first);
		while (!list.isEmpty()) {
			Struct tmp = list.pollFirst();

			LinkedList<Integer> Rwhich = findR(tmp.map);
			LinkedList<Integer> Bwhich = findB(tmp.map);
			if (Bwhich.size() < 1) {
				continue;
			} else {
				if (Rwhich.size() < 1) {
					return tmp.time;
				}
			}
			//up
			Struct s = new Struct();
			if (Rwhich.get(0) > Bwhich.get(0)) {
				s = moveBall(Bwhich.get(0), Bwhich.get(1), 0, 'B', tmp);
				s = moveBall(Rwhich.get(0), Rwhich.get(1), 0, 'R', s);
			} else {
				s = moveBall(Rwhich.get(0), Rwhich.get(1), 0, 'R', tmp);
				s = moveBall(Bwhich.get(0), Bwhich.get(1), 0, 'B', s);
			}
			//visited check
			char[][] visited = cVisited(tmp.visited);
			s.visited = visited;
			s.setRB();
			if (s.ry != -1 && s.by != -1) {
				if (s.map[s.ry][s.rx] == visited[s.ry][s.rx] && s.map[s.by][s.bx] == visited[s.by][s.bx]) {
					
				} else {
					s.visited[s.ry][s.rx] = 'R';
					s.visited[s.by][s.bx] = 'B';
					list.add(s);
				}
			}
			
			s = new Struct();
			if (Rwhich.get(0) > Bwhich.get(0)) {
				s = moveBall(Bwhich.get(0), Bwhich.get(1), 0, 'B', tmp);
				s = moveBall(Rwhich.get(0), Rwhich.get(1), 0, 'R', s);
			} else {
				s = moveBall(Rwhich.get(0), Rwhich.get(1), 0, 'R', tmp);
				s = moveBall(Bwhich.get(0), Bwhich.get(1), 0, 'B', s);
			}
			//visited check
			visited = new char[sero][garo];
			visited = cVisited(tmp.visited);
			s.visited = visited;
			s.setRB();
			if (s.ry != -1 && s.by != -1) {
				if (s.map[s.ry][s.rx] == visited[s.ry][s.rx] && s.map[s.by][s.bx] == visited[s.by][s.bx]) {
					
				} else {
					s.visited[s.ry][s.rx] = 'R';
					s.visited[s.by][s.bx] = 'B';
					list.add(s);
				}
			}
			
			s = new Struct();
			if (Rwhich.get(0) > Bwhich.get(0)) {
				s = moveBall(Bwhich.get(0), Bwhich.get(1), 0, 'B', tmp);
				s = moveBall(Rwhich.get(0), Rwhich.get(1), 0, 'R', s);
			} else {
				s = moveBall(Rwhich.get(0), Rwhich.get(1), 0, 'R', tmp);
				s = moveBall(Bwhich.get(0), Bwhich.get(1), 0, 'B', s);
			}
			//visited check
			visited = new char[sero][garo];
			visited = cVisited(tmp.visited);
			s.visited = visited;
			s.setRB();
			if (s.ry != -1 && s.by != -1) {
				if (s.map[s.ry][s.rx] == visited[s.ry][s.rx] && s.map[s.by][s.bx] == visited[s.by][s.bx]) {
					
				} else {
					s.visited[s.ry][s.rx] = 'R';
					s.visited[s.by][s.bx] = 'B';
					list.add(s);
				}
			}
			
			s = new Struct();
			if (Rwhich.get(0) > Bwhich.get(0)) {
				s = moveBall(Bwhich.get(0), Bwhich.get(1), 0, 'B', tmp);
				s = moveBall(Rwhich.get(0), Rwhich.get(1), 0, 'R', s);
			} else {
				s = moveBall(Rwhich.get(0), Rwhich.get(1), 0, 'R', tmp);
				s = moveBall(Bwhich.get(0), Bwhich.get(1), 0, 'B', s);
			}
			//visited check
			visited = new char[sero][garo];
			visited = cVisited(tmp.visited);
			s.visited = visited;
			s.setRB();
			if (s.ry != -1 && s.by != -1) {
				if (s.map[s.ry][s.rx] == visited[s.ry][s.rx] && s.map[s.by][s.bx] == visited[s.by][s.bx]) {
					
				} else {
					s.visited[s.ry][s.rx] = 'R';
					s.visited[s.by][s.bx] = 'B';
					list.add(s);
				}
			}
		}
		return -1;
	}
	public static char[][] cVisited(char[][] visited) {
		char[][] nvisited = new char[sero][garo];
		for (int i = 0; i < nvisited.length; i++) {
			for (int j = 0; j < nvisited[0].length; j++) {
				nvisited[i][j] = visited[i][j];
			}
		}
		return nvisited;
	}
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,-1,1};
	public static Struct moveBall(int y, int x, int dir, char color, Struct s) {
		char[][] map = new char[sero][garo];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (s.map[i][j] == color) {
					map[i][j] = '.';
					continue;
				}
				map[i][j] = s.map[i][j];
			}
		}
		int ny = y;
		int nx = x;
		for (int i = 0; i < 10; i++) {
			ny = ny + dy[dir]; nx = nx + dx[dir];
			if (map[ny][nx] == '#' || map[ny][nx] == 'R' || map[ny][nx] == 'B') {
				map[ny - dy[dir]][nx - dx[dir]] = color;
				break;
			}
			if (map[ny][nx] == 'O') {
				break;
			}
		}
		Struct nStruct = new Struct();
		nStruct.map = map;
		++nStruct.time;
		return nStruct;
	}
	public static LinkedList<Integer> findR(char[][] map) {
		LinkedList<Integer> output = new LinkedList<>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 'R') {
					output.addFirst(i);
					output.addFirst(j);
				}
			}
		}
		return output;
	}
	public static LinkedList<Integer> findB(char[][] map) {
		LinkedList<Integer> output = new LinkedList<>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 'B') {
					output.addFirst(i);
					output.addFirst(j);
				}
			}
		}
		return output;	
	}
}

class Struct {
	public Struct() {
		// TODO Auto-generated constructor stub
	}
	public Struct(char[][] map, int time) {
		
	}
	public Struct(char[][] map, char[][] visited, int time) {
		// TODO Auto-generated constructor stub
		this.map = map;
		this.visited = visited;
		this.time = time;
	}
	char[][] map;
	char[][] visited;
	int time;
	int ry = -1, rx = -1, by = -1, bx = -1;
	public void setRB() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 'R') {
					ry = i; rx = j;
				}
				if (map[i][j] == 'B') {
					by = i; bx = j;
				}
			}
		}
	}
	
}
