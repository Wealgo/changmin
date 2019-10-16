import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int n,m;
	public static boolean map[][];
	public static boolean visited[][][];
	//최대값을 구하는 문제이니 나올수 없는 큰 수를 할당해주자.
	public static int output = 99999;
	public static void main(String[] args) throws IOException {
		//입력 받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		visited = new boolean[n][m][2];
		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < m; j++) {
				if (tmp.charAt(j) == '0') {
					map[i][j] = true;
				} else {
					map[i][j] = false;
				}
			}
		}
		//탐색 돌자.
		bfs();
		if (output == 99999) {
			System.out.println(-1);
		} else {
			System.out.println(output + 1);
		}
	}
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static void bfs() {
		LinkedList<Pair> list = new LinkedList<>();
		//처음엔 0,0 부터 시작됨.
		Pair start = new Pair(0, 0, 0);
		list.add(start);
		//방문 표시 해주고
		visited[0][0][0] = true;
		//탐색 가즈아.
		while (!list.isEmpty()) {
			Pair tmp = list.poll();
			int y = tmp.y;
			int x = tmp.x;
			int v = tmp.v;
			boolean isCrush = tmp.isCrushed;
			//기저조건. 
			//리스트에서 꺼냈는데 보니까 도착점까지 왔어
			if (y == n-1 && x == m-1) {
				//최소값 비교해주고 설정해주자.
				if (output > v) {
					output = v;
				}
				return;
			}
			//상하좌우 보면서.
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
					//벽을 부수고 온 경우.
					if (isCrush) {
						if (map[ny][nx] && !visited[ny][nx][1]) {
							Pair p = new Pair(ny, nx, v+1);
							p.isCrushed = true;
							visited[ny][nx][1] = true;
							list.add(p);
						}
					//벽을 부수지 않은 경우.
					} else {
						//길이 있고 방문하지 않은 경우.
						if (map[ny][nx] && !visited[ny][nx][0]) {
							Pair p = new Pair(ny, nx, v+1);
							visited[ny][nx][0] = true;
							list.add(p);
						}
						//벽을 부수고 가려는 경우.
						if (!map[ny][nx] && !visited[ny][nx][0]) {
							Pair p = new Pair(ny, nx, v+1);
							visited[ny][nx][1] = true;
							p.isCrushed = true;
							list.add(p);
						}
					}
				}
			}
		}
	}
	
}

class Pair {
	int y,x;
	int v;
	boolean isCrushed = false;
	public Pair(int y, int x, int v) {
		this.x = x;
		this.y = y;
		this.v = v;
	}
}