import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int r,c,k;
	public static int answer;
	public static boolean[][] map;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	r = Integer.parseInt(st.nextToken());
    	c = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	map = new boolean[r][c];
    	for (int i = 0; i < r; i++) {
			String tmp = br.readLine();
    		for (int j = 0; j < c; j++) {
				if (tmp.charAt(j) == '.') map[i][j] = true;	
			}
		}
    	bfs();
    	System.out.println(answer);
    }
    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};
    public static void bfs() {
    	LinkedList<Pair> list = new LinkedList<>();
    	Pair tmp = (new Pair(r-1, 0, 1));
    	tmp.visited[r-1][0] = true;
    	list.add(tmp);
    	while (!list.isEmpty()) {
			Pair p = list.poll();
			if (p.y == 0 && p.x == c-1 && p.v == k) {
				answer++;
				continue;
			}
			if (p.v > k) continue;
			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if (!map[ny][nx]) continue;
				if (p.visited[ny][nx]) continue;
				Pair t = (new Pair(ny, nx, p.v + 1));
				for (int j = 0; j < t.visited.length; j++) {
					for (int j2 = 0; j2 < t.visited[0].length; j2++) {
						t.visited[j][j2] = p.visited[j][j2];
					}
				}
				t.visited[ny][nx] = true;
				list.add(t);
			}
		}
    }
    public static class Pair {
    	int y,x;
    	int v;
    	boolean[][] visited;
    	public Pair(int y, int x, int v) {
    		// TODO Auto-generated constructor stub
    		this.y = y;
    		this.x = x;
    		this.v = v;
    		visited = new boolean[r][c];
    	}
    }
    public static void print(boolean[][] visited) {
    	System.out.println("bial");
    	for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
    }
}
