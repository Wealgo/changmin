import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static int size;
	public static int[][] map;
	public static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			size = Integer.parseInt(br.readLine());
			map = new int[size][size];
			visited = new boolean[size][size];
			StringTokenizer st = new StringTokenizer(br.readLine());
			Pair now = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			Pair dest = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			System.out.println(bfs(now, dest));
		}
	}
	public static int[] dx = {-2, -2, -1, 1, 2, 2, -1, 1};
	public static int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};
	public static int bfs(Pair now, Pair dest) {
		if (now.x == dest.x && now.y == dest.y) return 0;
		
		LinkedList<Pair> list = new LinkedList<>();
		list.add(now);
		int n = 1;
		while (!list.isEmpty()) {
			int cnt = list.size();
			for (int i = 0; i < cnt; i++) {
				Pair tmp = list.poll();
				int y = tmp.y;
				int x = tmp.x;
				for (int j = 0; j < dx.length; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];
					if (ny == dest.y && nx == dest.x) return n;
					if (ny >= size || nx >= size || ny < 0 || nx < 0) continue;
					if (visited[ny][nx]) continue;
					visited[ny][nx] = true;
					list.add(new Pair(ny, nx));
				}
			}
			n++;
		}
		return n;
	}
	
}
class Pair {
	int x, y;
	public Pair(int y, int x) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}