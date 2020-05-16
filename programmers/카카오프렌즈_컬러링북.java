import java.io.IOException;
import java.util.LinkedList;

/**
 * max와 total을 초기화해줘야함;;
 * @author quadcore
 */
class Main {
	public static int sero, garo;
	public static int max = 0, total = 0;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		int[][] map = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[] arr = solution(6,4, map);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static int[] solution(int m, int n, int[][] picture) {
        map = picture.clone();
		garo = n;
		sero = m;
		total = 0;
		max = 0;
		visited = new boolean[sero][garo];
		find();
        int[] answer = new int[2];
        answer[0] = total;
        answer[1] = max;
        return answer;
    }
	public static void find() {
		LinkedList<Pair> list = new LinkedList<>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (visited[i][j]) continue;
				if (map[i][j] == 0) continue;
				++total;
				Pair p = new Pair(i, j, map[i][j]);
				bfs(p);
			}
		}
	}
	public static void bfs(Pair tmp) {
		LinkedList<Pair> list = new LinkedList<>();
		list.add(tmp);
		int cnt = 1;
		while (!list.isEmpty()) {
			Pair p = list.poll();
			visited[p.y][p.x] = true;
			for (int d = 0; d < 4; d++) {
				int ny = p.y + dy[d];
				int nx = p.x + dx[d];
				if (ny >= sero || nx >= garo || ny < 0 || nx < 0) continue;
				if (visited[ny][nx]) continue;
				if (map[ny][nx] != p.v) continue;
				list.add(new Pair(ny, nx, p.v));
				++cnt;
				visited[ny][nx] = true;
			}
		}
		max = Math.max(max, cnt);
	}
}
class Pair {
	int y, x;
	int v;
	public Pair(int y, int x, int v) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.v = v;
	}
}