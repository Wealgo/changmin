import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		int[][] land = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
		int[][] land1 = {{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}};
		int[][] land2 = {{3,3,9,3,3},{3,3,9,3,3},{9,9,9,9,9},{3,3,9,3,3},{3,3,9,3,3}};
		int height = 3;
		m.solution(land, height);
		System.out.println(m.answer);
	}
	public int[][] map;
	public int height, n, answer;
	public boolean[][] visited;
	public int solution(int[][] land, int height) {
        this.height = height;
        this.map = land;
        n = land.length;
        visited = new boolean[n][n];
		bfs(new Pair(0, 0));
		installBridge(0, 0);
        return answer;
    }
	public int[] dy = {-1,1,0,0};
	public int[] dx = {0,0,-1,1};
	public void bfs(Pair p) {
		LinkedList<Pair> list = new LinkedList<>();
		list.add(p);
		visited[p.y][p.x] = true;
		while (!list.isEmpty()) {
			Pair tmp = list.poll();
			for (int i = 0; i < 4; i++) {
				int ny = tmp.y + dy[i];
				int nx = tmp.x + dx[i];
				if (ny >= n || nx >= n || ny < 0 || nx < 0) continue;
				if (visited[ny][nx]) continue;
				if (Math.abs(map[ny][nx] - map[tmp.y][tmp.x]) > height) continue;
				visited[ny][nx] = true;
				list.add(new Pair(ny, nx));
			}
		}
	}
	public void installBridge(int y, int x) {
		int diff = 99999;
		Pair p = null;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) continue;
				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					if (ny >= n || nx >= n || ny < 0 || nx < 0) continue;
					if (visited[ny][nx]) continue;
					if (Math.abs(map[i][j] - map[ny][nx]) <= height) continue;
					if (Math.abs(map[i][j] - map[ny][nx]) < diff) {
						y = i;
						x = j;
						diff = Math.abs(map[i][j] - map[ny][nx]);
						p = new Pair(ny, nx);
					}
				}
			}
		}
		
		if (diff == 9999 || p == null) {
			return;
		} else {
			answer = answer + diff;
			bfs(p);
			installBridge(y, x);
		}
	}
}
class Pair {
	int y, x;
	public Pair(int y, int x) {
		// TODO Auto-generated constructor stub
		this.y = y;
		this.x = x;
	}
}