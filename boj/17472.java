import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 와 이거 어케풀었누?
 */
public class Main {
	public static int sero, garo;
	public static boolean[][] map;
	public static int[][] rm;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	sero = Integer.parseInt(st.nextToken());
    	garo = Integer.parseInt(st.nextToken());
    	map = new boolean[sero][garo];
    	rm = new int[sero][garo];
    	visited = new boolean[sero][garo];
    	for (int i = 0; i < sero; i++) {
    		st = new StringTokenizer(br.readLine());
			for (int j = 0; j < garo; j++) {
				if (st.nextToken().equals("1")) {
					map[i][j] = true;
				}
			}
		}
    	
    	find();
    	findStart();
    	greedy(1);
    	for (int i = 1; i < visitedG.length; i++) {
			if (!visitedG[i]) {
				System.out.println(-1);
				return;
			}
		}
    	if (totalIsland <= 2) {
			System.out.println(-1);
			return;
		}
    	System.out.println(answer);
    	/**/
    }
    public static void findBridge(Pair p) {
    	int root = rm[p.y][p.x];
    	int ny = p.y;
    	for (int i = 0; i < sero; i++) {
			ny += dy[0];
			if (ny < 0) break;
			if (rm[ny][p.x] == root) break;
			if (rm[ny][p.x] == 0 || rm[ny][p.x] == 9999) continue;
			if (radix[ root ][ rm[ny][p.x] ] > i) {
				if (i < 2) break;
				radix[ root ][ rm[ny][p.x] ] = i;
			}
			break;
		}
    	
    	//down
    	ny = p.y;
    	for (int i = 0; i < sero; i++) {
			ny += dy[1];
			if (ny >= sero) break;
			if (rm[ny][p.x] == rm[p.y][p.x]) break;
			if (rm[ny][p.x] == 0 || rm[ny][p.x] == 9999) continue;
			if (radix[ root ][ rm[ny][p.x] ] > i) {
				if (i < 2) break;
				radix[ root ][ rm[ny][p.x] ] = i;
			}
			break;
		}
    	
    	//left
    	int nx = p.x;
    	for (int i = 0; i < garo; i++) {
			nx += dx[2];
			if (nx < 0) break;
			if (rm[p.y][nx] == rm[p.y][p.x]) break;
			if (rm[p.y][nx] == 0 || rm[p.y][nx] == 9999) continue;
			
			if (radix[ root ][ rm[p.y][nx] ] > i) {
				if (i < 2) break;
				radix[ root ][ rm[p.y][nx] ] = i;
			}
			break;
		}
    	
    	nx = p.x;
    	for (int i = 0; i < garo; i++) {
			nx += dx[3];
			if (nx >= garo) break;
			if (rm[p.y][nx] == rm[p.y][p.x]) break;
			if (rm[p.y][nx] == 0 || rm[p.y][nx] == 9999) continue;
			
			if (radix[ root ][ rm[p.y][nx] ] > i) {
				if (i < 2) break;
				radix[ root ][ rm[p.y][nx] ] = i;
			}
			break;
		}
		/**/
    }
    ///////
    public static boolean[] visitedG;
    public static int answer = 0;
    public static boolean[][] visiteds;
    public static void greedy(int idx) {
    	visitedG[idx] = true;
    	PriorityQueue<Pair> list = new PriorityQueue<>();
    	for (int i = 0; i < totalIsland; i++) {
			if (radix[idx][i] == 9999) continue;
			Pair tmp = (new Pair(idx, i));
			tmp.v = radix[idx][i];
			list.add(tmp);
		}
    	
    	while (!list.isEmpty()) {
			 Pair p = list.poll();
			 if (visitedG[p.x]) continue;
			 visitedG[p.x] = true;
			 answer = answer + p.v;
			 for (int i = 0; i < totalIsland; i++) {
				if (radix[p.x][i] == 9999) continue;
				Pair np = new Pair(i, i);
				np.v = radix[p.x][i];
				list.add(np);
			}
		}
    }
    public static void findStart() {
    	radix = new int[totalIsland][totalIsland];
    	visitedG = new boolean[totalIsland];
    	visitedG[0] = true;
    	visiteds = new boolean[totalIsland][totalIsland];
    	for (int i = 0; i < radix.length; i++) {
			for (int j = 0; j < radix.length; j++) {
				radix[i][j] = 9999;
			}
		}
    	
    	for (int i = 0; i < sero; i++) {
			for (int j = 0; j < garo; j++) {
				if (!map[i][j]) continue;
				Pair p = new Pair(i, j);
				findBridge(p);
			}
		}
		/**/
    }
    public static int[][] radix;
    
    
    
    public static void print() {
    	for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
    }
    public static void printradix() {
    	for (int i = 0; i < radix.length; i++) {
			for (int j = 0; j < radix.length; j++) {
				if (radix[i][j] == 9999) System.out.print(0+" ");
				else 
					System.out.print(radix[i][j] + " ");
			}
			System.out.println();
		}
    	System.out.println();
    }
    public static void printrm() {
    	for (int i = 0; i < sero; i++) {
			for (int j = 0; j < garo; j++) {
				System.out.print(rm[i][j] + " ");
			}
			System.out.println();
		}
    	System.out.println();
    }
    public static int totalIsland;
    public static boolean[][] visited;
    public static void find() {
    	int cnt = 1;
    	for (int i = 0; i < sero; i++) {
			for (int j = 0; j < garo; j++) {
				if (!map[i][j]) continue;
				if (visited[i][j]) continue;
				bfs(i, j, cnt);
				cnt++;
			}
		}
    	totalIsland = cnt;
    }
    
    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};
    public static void bfs(int y, int x, int cnt) {
    	Pair tmp = new Pair(y, x);
    	visited[y][x] = true;
    	rm[y][x] = cnt;
    	LinkedList<Pair> list = new LinkedList<>();
    	list.add(tmp);
    	while (!list.isEmpty()) {
			Pair p = list.pollFirst();
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= sero || nx >= garo) continue;
				if (!map[ny][nx]) continue;
				if (visited[ny][nx]) continue;
				Pair np = new Pair(ny, nx);
				list.add(np);
				rm[ny][nx] = cnt;
				visited[ny][nx] = true;
			}
		}
    }
}
class Pair implements Comparable<Pair>{
	int y, x;
	int v;
	public Pair(int y, int x) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return this.v - o.v;
	}
}
