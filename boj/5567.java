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
	public static int n, m;
	public static boolean[] visited;
	public static boolean[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		visited = new boolean[n+1];
		visited[1] = true;
		
		map = new boolean[n+1][n+1];
		
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[y][x] = true;
			map[x][y] = true;
		}
		
		System.out.println(bfs());
	}
	public static int bfs() {
		int output = 0;
		LinkedList<Integer> list = new LinkedList<>();
		
		for (int i = 0; i <= n; i++) if (map[1][i]) {
			list.add(i);
			visited[i] = true;
		}
		
		output = list.size();
		
		int size = list.size();
		for (int i = 0; i < size; i++) {
			int tmp = list.poll();
			for (int j = 0; j <= n; j++) {
				if (visited[j]) continue;
				if (map[tmp][j]) {
					visited[j] = true;
					list.add(j);
				}
			}
		}
		
		output += list.size();
		
		return output;
	}
}