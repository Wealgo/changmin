import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main{
	public static int n;
	public static int l,r;
	public static int output = 0;
	public static int[][] map;
	public static int[] dy = {0,0,1,-1};
	public static int[] dx = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		//입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int [n][n];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		while (united()) {}
		System.out.println(output);
	}
	//나라의 연합과 인구이동을 진행하는 함수.
	public static boolean united() {
		//방문표시할 배열.
		boolean[][] visited = new boolean[n][n];
		//새로운 맵.
		int[][] nmap = new int[n][n];
		//인구이동을 더이상 할 수 있는지 체크할 변수.
		int check = 0;
		//전체 맵을 돌면서,
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited.length; j++) {
				//bfs를 사용하기 위해 큐 선언.
				Queue<Pair> list = new LinkedList<>();
				//방문 안한 나라들만 방분해주자.
				if (!visited[i][j]) {
					check = check + 1;
					//나라연합을 확인하기 위한 리스트 선언.
					LinkedList<Pair> sunited = new LinkedList<>();
					Pair pair = new Pair(i, j);
					list.add(pair);
					while (!list.isEmpty()) {
						Pair p = list.poll();
						sunited.add(p);
						int x = p.x;
						int y = p.y;
						visited[y][x] = true;
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							//맵의 경계에 닿지 않고,
							if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
								//방문되지 않은 나라와 인구수의 차이가 L과 R 사이라면,
								if (!visited[ny][nx] && l <= Math.abs(map[ny][nx] - map[y][x]) && Math.abs(map[ny][nx] - map[y][x]) <= r) {
									//큐에 넣어주자.
									Pair tmp = new Pair(ny, nx);
									//방문표시는 바로바로 해주자. 방문된 나라가 큐에 들어오는 실수를 범함.
									visited[ny][nx] = true;	//해당라인을 표기하지 않아 3시간 잡아먹음.
									list.add(tmp);
								}
							}
						}
					}
					int hap = 0;
					for (int k = 0; k < sunited.size(); k++) {
						hap = hap + map[sunited.get(k).y][sunited.get(k).x];
					}
					//연합의 맵 크기와 인구수의 평균.
					int value = hap/sunited.size();
					for (int k = 0; k < sunited.size(); k++) {
						nmap[sunited.get(k).y][sunited.get(k).x] = value;
					}
				}
			}
		}
		//인구이동을 끝낸 맵으로 변경.
		map = nmap;
		//모든 나라가 경계를 내리지 않을 경우, 즉 인구이동이 없는 경우.
		if (check > (n*n)-1) {
			return false;
		}
		//인구이동 횟수 추가.
		output = output + 1;
		return true;
	}
}
class Pair {
	int y,x;
	public Pair(int y, int x) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}