import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static int answer = 0;
	public static int[][][] bcMap;
	public static int m, a;	//m은 이동거리, a는 bc의 갯수;
	public static int[] mv1, mv2;
	public static Pair p1, p2;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int testcase = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < testcase; i++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			mv1 = new int[m];
			mv2 = new int[m];
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < m; j++) {
				mv1[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < mv1.length; j++) {
				mv2[j] = Integer.parseInt(st.nextToken());
			}
			bcMap = new int[a][10][10];
			for (int j = 0; j < a; j++) {
				st = new StringTokenizer(sc.nextLine());
				draw(j, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			p1 = new Pair(0, 0);
			p2 = new Pair(9, 9);
			answer = max(p1, p2);
			for (int j = 0; j < mv1.length; j++) {
				p1 = move(mv1[j], p1);
				p2 = move(mv2[j], p2);
				int max = max(p1, p2);
				answer += max;
			}
			System.out.println("#"+(i+1)+" "+answer);
		}
	}
	public static Pair move(int dir, Pair p) {
		if (dir == 0) return p;
		Pair np = new Pair(p.y + dy[dir - 1], p.x + dx[dir - 1], p.v);
		return np;
	}
	public static int max(Pair p1, Pair p2) {
		int max = 0;
		int v1 = 0;
		for (int i = 0; i < a; i++) {
			v1 = bcMap[i][p1.y][p1.x];
			int v2 = 0;
			for (int j = 0; j < a; j++) {
				if (i == j) v2 = 0;
				else v2 = bcMap[j][p2.y][p2.x];
				if (v1 + v2 > max) {
					p1.v = i;
					p2.v = j;
					max = v1 + v2;
				}
			}
		}
		return max;
	}
	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};
	public static boolean[][] visited;
	public static void draw(int bcn, int x, int y, int c, int p) {
		visited = new boolean[10][10];
		LinkedList<Pair> list = new LinkedList<>();
		Pair np = new Pair(y, x, c);
		list.add(np);
		bcMap[bcn][y][x] = p;
		visited[y][x] = true;
		while (!list.isEmpty()) {
			Pair tmp = list.pollFirst();
			if (tmp.v == 0) continue;
			for (int i = 0; i < 4; i++) {
				int ny = tmp.y + dy[i];
				int nx = tmp.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= 10 || nx >= 10) continue;
				if (visited[ny][nx]) continue;
				visited[ny][nx] = true;
				bcMap[bcn][ny][nx] = p;
				list.add(new Pair(ny, nx, tmp.v-1));
			}
		}
	}
}

class Pair {
	int y, x;
	int v;
	public Pair(int y, int x) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	public Pair(int y, int x, int v) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.v = v;
	}
}