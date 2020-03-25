import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int garo, sero;
	public static char map[][];
	public static boolean visited[][];
	public static int totalSheep, totalWolf;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		map = new char[sero][garo];
		visited = new boolean[sero][garo];
		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		findSheepAndWolf();
		System.out.println(totalSheep+" "+totalWolf);
	}
	public static void findSheepAndWolf() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == '#') continue;
				if (visited[i][j]) continue;
				bfs(i, j);
			}
		}
	}
	public static int dy[] = {-1,1,0,0};
	public static int dx[] = {0,0,-1,1};
	public static void bfs(int y, int x) {
		int sheep = 0;
		int wolf = 0;
		visited[y][x] = true;
		Pair p = new Pair(y, x);
		LinkedList<Pair> list = new LinkedList<Pair>();
		list.add(p);
		while (!list.isEmpty()) {
			Pair tmp = list.pollFirst();
			if (map[tmp.y][tmp.x] == 'v') wolf++;
			if (map[tmp.y][tmp.x] == 'k') sheep++;
			for (int i = 0; i < 4; i++) {
				int ny = tmp.y + dy[i];
				int nx = tmp.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= sero || nx >= garo) continue;
				if (visited[ny][nx]) continue;
				if (map[ny][nx] == '#') continue;
				visited[ny][nx] = true;
				Pair np = new Pair(ny, nx);
				list.add(np);
			}
		}
		if (sheep > wolf) {
			totalSheep+=sheep;
		} else {
			totalWolf+=wolf;
		}
	}
}

class Pair {
	int y, x;
	public Pair(int y, int x) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}