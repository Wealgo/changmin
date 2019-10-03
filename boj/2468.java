import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 탐색으로 해결하면 크게 어렵지 않은 문제.
 * @author quadcore
 *
 */
public class Main {
	public static int n, max = 0;
	public static int[][] map;
	public static int output = 0;
	public static boolean visited[][];
	public static void main(String[] args) throws IOException {
		// 입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				//지형의 최대 높이를 체크해주자.
				if (max < tmp) {
					max = tmp;
				}
				map[i][j] = tmp;
			}
		}
		boolean[][] fmap;
		//입력받은 지형의 최대 높이만큼 돌자.
		//0은 비가 안온거나 마찬가지니 1부터 시작하자.
		for (int t = 1; t < max+1; t++) {	
			fmap = new boolean[n][n];
			//홍수에 잠긴 맵을 만들어주자.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] < t) {
						fmap[i][j] = true;
					}
				}
			}
			//홍수에 잠긴 맵으로 bfs탐색 가즈아.
			int tmp = bfs(fmap);
			//안전영역의 최대값을 갱신.
			if (tmp > output) {
				output = tmp;
			}
		}
		System.out.println(output);
	}
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int bfs(boolean fmap[][]) {
		int sibal = 0;
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				//맵을 돌면서 잠기지 않은 영역과 미방문 지역부터 탐색.
				if (!visited[i][j] && !fmap[i][j]) {
					Queue<Pair> queue = new LinkedList<>();
					queue.add(new Pair(i, j));
					visited[i][j] = true;	//방문했다고 체크하고.
					while (!queue.isEmpty()) {
						Pair tmp = queue.poll();
						int x = tmp.x;
						int y = tmp.y;
						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
								if (!visited[ny][nx] && !fmap[ny][nx]) {
									//중복탐색을 방지하기 위해 여기서 방문 체크해주자.
									visited[ny][nx] = true;
									queue.add(new Pair(ny, nx));
								}
							}
						}
					}
					sibal = sibal + 1;
				}	
			}
		}
		return sibal;
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