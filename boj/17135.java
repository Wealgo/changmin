import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * 구현에 꽤나 시간걸렸던 문제.
 * 처음에 설계한 로직은 맞았지만 중간중간 전역변수와 지역변수의 미스매치때문에 디버깅 시간이 오래걸림.
 * 차근히 디버깅하는 습관을 들이면 시간을 더 절약할 수 있을듯.
 * @author quadcore
 *
 */
public class Main{
	public static int[][] map;
	public static int n, m, d, output;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n+1][m];
		visited = new boolean[m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		position(0, 0);
		System.out.println(output);
	}
	public static int[][] kill(ArrayList<Pair> dead, int[][] map) {
		int[][] newmap = new int[n+1][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newmap[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < dead.size(); i++) {
            //같은 적을 공격하는 경우를 제외.
			if (newmap[dead.get(i).y][dead.get(i).x] == 1) {
				newmap[dead.get(i).y][dead.get(i).x] = 0;
				result = result + 1;
			}
		}
		return newmap;
	}
	public static ArrayList<Integer> archers = new ArrayList<>();
	public static boolean visited[];
	public static void position(int cnt, int idx) {
		if (cnt == 3) {
			archers = new ArrayList<>();
			result = 0;
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					archers.add(i);
				}
			}
			play();
			return;
		}
		for (int i = idx; i < m; i++) {
			visited[i] = true;
			position(cnt+1, i+1);
			visited[i] = false;
		}
	}
	public static void play() {
		int[][] newmap = new int[n+1][m];
		for (int i = 0; i < newmap.length; i++) {
			for (int j = 0; j < newmap[0].length; j++) {
				newmap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			ArrayList<Pair> dead = attack(newmap);
			newmap = kill(dead, newmap);
			newmap = go(newmap);
		}
		if (output < result) {
			output = result;
		}
	}
	//왼쪽부터 탐색하기 위해 dy,dx 배열의 순서를 신경썼음.
	public static int[] dx = {-1,0,1};
	public static int[] dy = {0,-1,0};
	public static ArrayList<Pair> attack(int[][] map) {
		ArrayList<Pair> dead = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Pair start = new Pair(n, archers.get(i), 0);
			Pair tmp = bfs(start, map);
			if (tmp != null) {
				dead.add(tmp);
			}
		}
		return dead;
	}
	public static Pair bfs(Pair start, int[][] newmap) {
		LinkedList<Pair> list = new LinkedList<>();
		list.add(start);
		while (!list.isEmpty()) {
			Pair p = list.poll();
			if (p.distnc > d-1) continue;	// 초기값이 0이니 -1을 해줘야 거리를 계산할 수 있음.
			for (int j = 0; j < 3; j++) {
				int nx = p.x + dx[j];
				int ny = p.y + dy[j];
				if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
					if (newmap[ny][nx] == 1) {	// map to newmap
						return new Pair(ny, nx, p.distnc+1);
					}
					list.add(new Pair(ny, nx, p.distnc+1));
				}
			}
		}
		return null;
	}
	public static int result = 0;
	public static int[][] go(int[][] map) {
		int[][] newmap = new int[n+1][m];
		for (int i = 1; i < n+1; i++) {
			newmap[i] = map[i-1];
		}
		return newmap;
	}
}
class Pair {
	int y,x;
	int distnc;
	public Pair(int y, int x, int distnc) {
		// TODO Auto-generated constructor stub
		this.y = y;
		this.x = x;
		this.distnc = distnc;
	}
}