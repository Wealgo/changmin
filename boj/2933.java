import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 침착하게 찬찬히 풀면 쉽다!
 */
public class Main {
    public static int garo, sero;
    public static boolean[][] visited;
    public static char[][] map;
    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	sero = Integer.parseInt(st.nextToken());
    	garo = Integer.parseInt(st.nextToken());
    	visited = new boolean[sero][garo];
    	map = new char[sero][garo];
    	for (int i = 0; i < sero; i++) {
    		String tmp = br.readLine();
			for (int j = 0; j < garo; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
    	
    	int n = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < n; i++) {
    		visited = new boolean[sero][garo];
			if (i%2 == 0) {
				leftShoot(sero-Integer.parseInt(st.nextToken()));
			} else {
				rightShoot(sero-Integer.parseInt(st.nextToken()));
			}
			bot();
	    	air();
		}
    	printMap();
    }
	public static void air() {
		for (int i = 0; i < sero; i++) {
			for (int j = 0; j < garo; j++) {
				if (visited[i][j]) continue;
				if (map[i][j] == '.') continue;
				airCluster(i, j);
				return;
			}
		}
	}
	public static void airCluster(int y, int x) {
		LinkedList<Pair> list = new LinkedList<>();
		LinkedList<Pair> clus = new LinkedList<>();
		list.add(new Pair(y, x)); clus.add(new Pair(y, x));
		boolean[][] nvisited = new boolean[sero][garo];
		
		while (!list.isEmpty()) {
			Pair p = list.pollFirst();
			nvisited[p.y][p.x] = true;
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (ny >= sero || ny < 0 || nx >= garo || nx < 0) continue;
				if (nvisited[ny][nx]) continue;
				if (map[ny][nx] == '.') continue;
				nvisited[ny][nx] = true;
				list.add(new Pair(ny, nx));
				clus.add(new Pair(ny, nx));
			}
		}
		check(clus);
	}
	public static void check(LinkedList<Pair> list) {
		int size = list.size();
		for (int i = 0; i < sero; i++) {
			for (int j = 0; j < list.size(); j++) {
				Pair p = list.get(j);
				if (p.y+1 >= sero) return;
				if (visited[p.y+1][p.x]) return;
			}
			for (int j = 0; j < size; j++) {
				Pair p = list.get(j);
				map[p.y][p.x] = '.';
			}
			for (int j = 0; j < size; j++) {
				Pair p = list.pollFirst();
				map[p.y+1][p.x] = 'x';
				list.add(new Pair(p.y+1, p.x));
			}
		}
	}
	public static void bot() {
		for (int i = 0; i < garo; i++) {
			if (visited[sero-1][i]) continue;
			if (map[sero-1][i] == '.') continue;
			botBfs(sero-1, i);
		}
	}
	
	public static void botBfs(int y, int x) {
		Pair tmp = new Pair(y, x);
		LinkedList<Pair> list = new LinkedList<>();
		list.add(tmp);
		visited[y][x] = true;
		while (!list.isEmpty()) {
			Pair p = list.pollFirst();
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (ny >= sero || ny < 0 || nx >= garo || nx < 0) continue;
				if (visited[ny][nx]) continue;
				if (map[ny][nx] == '.') continue;
				visited[ny][nx] = true;
				list.add(new Pair(ny, nx));
			}
		}
	}
	public static void leftShoot(int idx) {
		for (int i = 0; i < garo; i++) {
			if (map[idx][i] == '.') continue;
			map[idx][i] = '.';
			return;
		}
	}
	public static void rightShoot(int idx) {
		for (int i = garo-1; i >= 0; i--) {
			if (map[idx][i] == '.') continue;
			map[idx][i] = '.';
			return;
		}
	}
	
	public static void printMap() {
		for (int i = 0; i < sero; i++) {
			for (int j = 0; j < garo; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}

class Pair implements Comparable<Pair>{
	int y, x;
	public Pair(int y, int x) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return this.y = o.y;
	}
}