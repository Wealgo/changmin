import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * bfs의 특성을 이해하면 쉽게 풀 수 있다.
 * 탐색이 길어질수록 땅 사이의 최장거리를 알 수 있기 때문.
 * bfs탐색하면서 탐색의 깊이를 체크해두자.
 * @author quadcore
 *
 */
public class Main{
	public static int sero,garo;
	public static boolean[][] map;
	public static boolean[][] visited;
	public static int output = 0;
	public static LinkedList<Pair> lands = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		map = new boolean[sero][garo];
		//입력받자~
		for (int i = 0; i < map.length; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < map[0].length; j++) {
				if (tmp.charAt(j) == 'L') {
					map[i][j] = true;
					//땅은 리스트로 저장해두자.
					Pair p = new Pair(i, j, 0);
					lands.add(p);
				}
			}
		}
		//리스트에 저장해둔 땅의 좌표를 꺼내서 bfs돌자~
		for (int i = 0; i < lands.size(); i++) {
			bfs(lands.get(i));
		}
		System.out.println(output);
	}
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	//땅의 좌표를 기준으로 bfs탐색을 하자. 
	public static void bfs(Pair p) {
		visited = new boolean[sero][garo];
		Queue<Pair> list = new LinkedList<>();
		list.add(p);
		visited[p.y][p.x] = true;
		while (!list.isEmpty()) {
			Pair tmp = list.remove();
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (ny >= 0 && ny < sero && nx >= 0 && nx < garo) {
					if (map[ny][nx] == true && visited[ny][nx] == false) {
						//최장거리를 구하기 위해 처음 땅의 좌표로부터 멀어지는 값을 계속 체크해두자.
						int distance = tmp.distance + 1;
						if (output < distance) {
							output = distance;
						}
						//방문했다 해주고~
						visited[ny][nx] = true;
						list.add(new Pair(ny, nx, distance));
					}
				}
			}
		}
	}
}
class Pair {
	int x,y;
	int distance = 0;
	public Pair(int y, int x, int distance) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
}