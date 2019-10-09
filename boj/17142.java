import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 전형적인 백트레킹 + 탐색 문제.
 * 비활성 바이러스의 처리를 잘 생각하지 못해 시간이 오래걸림.
 * @author quadcore
 *
 */
public class Main {
	public static int[][] map;
	public static int n,m;
	public static boolean[] sv;
	public static ArrayList<Integer> outputs = new ArrayList<>();;
	public static ArrayList<Pair> viruses = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// 입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		//모든 맵이 바이러스일 수 있다.
		sv = new boolean[n*n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 2) {
					Pair virus = new Pair(i, j, 0);
					viruses.add(virus);
				}
				map[i][j] = tmp;
			}
		}
		//바이러스 위치 선택.
		selctVrs(0, 0);
		//최소값을 구하기 위해 터무니없는 값을 넣어주자.
		int output = 9999999;
		//만약 리스트가 텅 비었다면,
		if (outputs.isEmpty()) {
			System.out.println(-1);
			return;
		}
		//최소값 탐색~
		for (int i = 0; i < outputs.size(); i++) {
			if (output > outputs.get(i)) {
				output = outputs.get(i);
			}
		}
		System.out.println(output);
	}
	//백트레킹으로 바이러스 선정.
	public static void selctVrs(int idx, int cnt) {
		if (cnt >= m) {
			//바이러스가 선정되었다면 탐색.
			spreadVrs();
			return;
		}
		for (int i = idx; i < viruses.size(); i++) {
			if (!sv[i]) {
				sv[i] = true;
				selctVrs(i+1, cnt+1);
				sv[i] = false;
			}
		}
	}
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {-1,1,0,0};
	//bfs로 바이러스 퍼트리는 함수.
	public static void spreadVrs() {
		Queue<Pair> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		int[][] time = new int[n][n];
		//선정된 바이러스는 방문했다고 표시해주자.
		for (int i = 0; i < sv.length; i++) {
			if (sv[i]) {
				visited[viruses.get(i).y][viruses.get(i).x] = true;
				queue.add(viruses.get(i));
			}
		}
		//큐 돌면서~
		while (!queue.isEmpty()) {
			Pair tmp = queue.remove();
			int x = tmp.x;
			int y = tmp.y;
			int v = tmp.v;
			//상하좌우 돌면서~
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					//벽이면 pass
					if (map[ny][nx] == 1) continue;
					//방문했다면 pass
					if (visited[ny][nx]) continue;
					visited[ny][nx] = true;
					time[ny][nx] = v+1;
					queue.add(new Pair(ny, nx, v+1));
				}
			}
		}
		int output = 0;
		boolean empty = false;
		//탐색시간이 최대인 좌표를 찾자.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				//바이러스가 퍼지지 않는 공간이 있는지 체크.
				if (map[i][j] == 0 && !visited[i][j]) {
					empty = true;
				}
				/**
				 * 질문게시판을 뒤져보지 않았다면 반례를 찾기 어려웠을듯.
				 * 시간증가를 해두지만, 비활성바이러스에는 pass할 수 있게 해줘야한다.
				 */
				if (map[i][j] == 2) {
					continue;
				}
				//최대값 선정.
				if (output < time[i][j]) {
					output = time[i][j];
				}
			}
		}
		//만약 바이러스가 퍼지지 않은 공간이 없다면 리스트에 넣어주자.
		if (!empty) {
			outputs.add(output);
		}
	}
}
class Pair {
	int y,x;
	int v;
	public Pair(int y, int x, int v) {
		// TODO Auto-generated constructor stub
		this.y = y;
		this.x = x;
		this.v = v;
	}
}