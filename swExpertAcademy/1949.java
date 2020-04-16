import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 문제 지문이 어색했다.
 * "출발점은 항상 초기맵의 가장 높은 봉우리어야 한다"라는 지문이 추가되었어야 했다.
 * 이것때문에 시간을 잡아 먹었다.
 * @author quadcore
 *
 */
public class Main {
	public static int n, k;
	public static int[][] map;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testcase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			answer = 0;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			startPoint = find();
			start();
			System.out.println("#"+(t+1)+" "+answer);
		}
	}
	public static LinkedList<Pair> startPoint;
	public static int answer = 0;
	public static void start() {
		for (int t = 0; t <= k; t++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					//깎고
					map[i][j] = map[i][j] - t;
					//가장 높은 봉우리 찾고
					//탐색하고.
					for (int k = 0; k < startPoint.size(); k++) {
						bfs(startPoint.get(k).y, startPoint.get(k).x);
					}
					//다시 매꾸고.
					map[i][j] = map[i][j] + t;
				}
			}
		}
	}
	
	public static LinkedList<Pair> find() {
		int max = 0;
		LinkedList<Pair> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == max) {
					list.add(new Pair(i, j));
					continue;
				}
				if (map[i][j] > max) {
					max = map[i][j];
					list = new LinkedList<>();
					list.add(new Pair(i, j));
				}
			}
		}
		return list;
	}
	
	public static int[] dy = {-1,1,0,0};
	public static int[] dx = {0,0,-1,1};
	public static void bfs(int y, int x) {
		Pair tmp = new Pair(y, x);
		tmp.v = 1;
		LinkedList<Pair> list = new LinkedList<>();
		list.add(tmp);
		while (!list.isEmpty()) {
			Pair p = list.poll();
			if (answer < p.v) answer = p.v;
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
				if (map[ny][nx] >= map[p.y][p.x]) continue;
				Pair np = new Pair(ny, nx);
				np.v = 1 + p.v;
				list.add(np);
			}
		}
	}
}
class Pair {
	int y,x;
	int v;
	public Pair(int y, int x) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}