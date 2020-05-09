import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author quadcore
 */
class Main {
	public static int n, L;
	public static int[][] map, visited;
	public static int answer = 0;
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visited = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		visited[0][3] = 4;
//		visited[0][2] = 4;
//		visited[1][2] = 3;
//		visited[1][3] = 3;
//		backtracking(0);
		print(visited);
		roadCheck();
		System.out.println("ans:"+answer);
	}
	public static void roadCheck() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int check = map[i][0];
			int total = 0;
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == 0) {
					if (map[i][j] == check) total++;
					if (Math.abs(map[i][j] - check) > 1) break;
				}
				if (visited[i][j] == 1 || visited[i][j] == 2) break;
				if (visited[i][j] == 3) {
					total++;
					check = map[i][j] + 1;
				}
				if (visited[i][j] == 4) {
					total++;
					check = map[i][j];
				}
			}
			if (total == n) cnt++;
			System.out.println("to:"+total);
		}
		for (int i = 0; i < n; i++) {
			int check = map[i][0];
			int total = 0;
			for (int j = 0; j < n; j++) {
				if (visited[j][i] == 0) {
					if (map[j][i] == check) total++;
					if (Math.abs(map[j][i] - check) > 1) break;
				}
				if (visited[j][i] == 3 || visited[j][i] == 4) break;
				if (visited[j][i] == 3) {
					total++;
					check = map[j][i] + 1;
				}
				if (visited[j][i] == 4) {
					total++;
					check = map[j][i];
				}
			}
			if (total == n) cnt++;
			System.out.println("to:"+total);
		}
		
		if (cnt > answer) answer = cnt;
	}
	
	public static void backtracking(int idx) {
		for (int i = idx; i < n*n; i++) {
			int y = i / n;
			int x = i % n;
			if (visited[y][x] != 0) continue;
			POINT : for (int d = 0; d < 4; d++) {
				for (int l = 1; l <= L; l++) {
					int ny = y + dy[d]*l;
					int nx = x + dx[d]*l;
					if (ny >= n || nx >= n || ny < 0 || nx < 0) continue POINT;
					if (visited[ny][nx] != 0) continue POINT;
					if (map[y + (dy[d]*l)][x + (dx[d]*l)] != map[y][x]-1) continue POINT;
				}
				for (int l = 1; l <= L; l++) {
					visited[y+dy[d]*l][x+dx[d]*l] = d+1;
				}
				backtracking(i+1);
				print(visited);
				for (int l = 1; l <= L; l++) {
					visited[y+dy[d]*l][x+dx[d]*l] = 0;
				}
			}
		}
	}
	
	public static void print(int[][] var) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(var[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}