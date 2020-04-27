import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 비트마스크 적용!
 * 침착하게 찬찬히 풀면 쉽다!
 */
public class Main {
	public static int dy[] = {-1,1,0,0};
	public static int dx[] = {0,0,-1,1};
	public static int sero, garo;
	public static char[][] map;
	public static int[][][] visited;
	public static int answer = 9999;
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	sero = Integer.parseInt(st.nextToken());
    	garo = Integer.parseInt(st.nextToken());
    	map = new char[sero][garo];
    	visited = new int[sero][garo][65];
    	int y = 0 , x = 0;
    	for (int i = 0; i < sero; i++) {
    		String tmp = br.readLine();
			for (int j = 0; j < garo; j++) {
				char t = tmp.charAt(j);
				map[i][j] = t;
				if (t == '0') {
					y = i; x = j;
				}
			}
		}
    	bfs(y, x);
    	if (answer == 9999) {
			System.out.println(-1);
			return;
		} else { 
			System.out.println(answer+1);
		}
	}
	public static void bfs(int y, int x) {
		Pair tmp = new Pair(y, x, 0);
		tmp.bit = 0;
		Queue<Pair> list = new LinkedList<>();
		list.add(tmp);
		while (!list.isEmpty()) {
			Pair p = list.poll();
			visited[p.y][p.x][p.bit] = 1;
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (ny >= sero || nx >= garo || ny < 0 || nx < 0) continue;
				if (visited[ny][nx][p.bit] != 0) continue;
				if (map[ny][nx] == '#') continue;
				
				if (map[ny][nx] == 'A' || map[ny][nx] == 'B' || map[ny][nx] == 'C' || map[ny][nx] == 'D' || map[ny][nx] == 'E' || map[ny][nx] == 'F') {
					if ((p.bit & (1 << (int)map[ny][nx] - 65)) == 0) continue;
					Pair np = new Pair(ny, nx, p.cnt + 1);
					np.bit = p.bit + 0;
					visited[ny][nx][np.bit] = 1;
					list.add(np);
					continue;
				}
				if (map[ny][nx] == 'a' || map[ny][nx] == 'b' || map[ny][nx] == 'c' || map[ny][nx] == 'd' || map[ny][nx] == 'e' || map[ny][nx] == 'f') {
					int nb = p.bit | (1 << ((int)map[ny][nx] - 97));
					
					Pair np = new Pair(ny, nx, p.cnt+1);
					np.bit = nb;
					visited[ny][nx][nb] = 1;
					list.add(np);
					continue;
				}
				if (map[ny][nx] == '1') {
					if (answer > p.cnt) {
						answer = p.cnt;
					}
					continue;
				}
				Pair np = new Pair(ny, nx, p.cnt + 1);
				np.bit = p.bit;
				visited[ny][nx][np.bit] = 1;
				list.add(np);
			}
		}
	}
	public static void print(char[][] map) {
		for (int i = 0; i < sero; i++) {
			for (int j = 0; j < garo; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
class Pair {
	int y, x, cnt;
	int bit;
	public Pair(int y, int x, int cnt) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}