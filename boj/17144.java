import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 지문의 양때문에 쫄았지만 차분히 읽어보면 어렵지 않은 문제.
 * 디버깅 시간이 꽤나 걸렸다.
 * 시간단축을 목표로 해보자.
 * @author quadcore
 *
 */
public class Main {
	public static int map[][];
	public static int n,m,t;
	public static ArrayList<Pair> machine = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// 입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == -1) {
					machine.add(new Pair(i,j,tmp));
				}
				map[i][j] = tmp;
			}
		}
		//입력된 시간만큼 돌리자~.
		for (int k = 0; k < t; k++) {
			spread();
			airFresh();
		}
		System.out.println(count());
	}
	//공기청정기 작동 함수.
	public static void airFresh() {
		//up
		int[][] newmap = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		int x = machine.get(0).x;
		int y = machine.get(0).y;
		//공기청정기 심어주자.
		newmap[y][x] = -1;
		//공기청정기 방문했다고 해주자.
		visited[y][x+1] = true;
		//왼쪽으로~
		for (int i = 2; i < m; i++) {
			newmap[y][i] = map[y][i-1];
			visited[y][i] = true;
		}
		//위~
		for (int i = 1; i <= y; i++) {
			newmap[y-i][m-1] = map[y-i+1][m-1];
			visited[y-i][m-1] = true;
		}
		//오른쪽~
		for (int i = 1; i < m; i++) {
			newmap[0][m-i-1] = map[0][m-i];
			visited[0][m-i-1] = true;
		}
		//아래~
		for (int i = 1; i < y; i++) {
			newmap[i][0] = map[i-1][0];
			visited[i][0] = true;
		}
		//아래의 공기청정기의 위치 새로 설정해주고.
		x = machine.get(1).x;
		y = machine.get(1).y;
		//아래 공기청정기도 방문했다고 해주자.
		visited[y][x+1] = true;
		//공기청정기 심어주자.
		newmap[y][x] = -1;
		for (int i = 2; i < m; i++) {
			newmap[y][i] = map[y][i-1];
			visited[y][i] = true;
		}
		for (int i = y+1; i < n; i++) {
			newmap[i][m-1] = map[i-1][m-1];
			visited[i][m-1] = true;
		}
		for (int i = 1; i < m; i++) {
			newmap[n-1][m-i-1] = map[n-1][m-i];
			visited[n-1][m-i-1] = true;
		}
		for (int i = 1; i < n-y-1; i++) {
			newmap[n-i-1][0] = map[n-i][0];
			visited[n-i-1][0] = true;
		}
		//새로 선언한 맵으로 할당해주자.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					newmap[i][j] = map[i][j];
				}
			}
		}
		map = newmap;
	}
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,-1,1};
	//미세먼지가 퍼지는 함수.
	public static void spread() {
		int newmap[][] = new int[n][m];
		newmap[machine.get(0).y][machine.get(0).x] = -1;
		newmap[machine.get(1).y][machine.get(1).x] = -1;
		ArrayList<Pair> list = new ArrayList<>();
		//배열을 돌면서 미세먼지가 있는 칸은 리스트에 담아주자.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) continue;
				if (map[i][j] == -1) continue;
				Pair tmp = new Pair(i, j, map[i][j]);
				list.add(tmp);
			}
		}
		//미세먼지가 있는 칸을 돌면서 확산시켜주자.
		for (int i = 0; i < list.size(); i++) {
			Pair p = list.get(i);
			int x = p.x;
			int y = p.y;
			int v = p.v/5;
			//상하좌우로 퍼질 수 있는 칸을 체크.
			int count = 0;
			//상하좌우 보면서.
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
					//공기청정기의 위치는 패스해주자.
					if (map[ny][nx] == -1) continue;
					//퍼질 수 있는 칸을 체크.
					count = count + 1;
					//해당 값을 새로운 위치에 ++;
					newmap[ny][nx] = newmap[ny][nx] + v;
				}
			}
			//미세먼지 퍼지고 남은 값을 새로운 맵에 ++;
			newmap[y][x] = newmap[y][x] + (p.v - (v * count));
		}
		map = newmap;
	}
	//미세먼지의 수를 세는 함수.
	public static int count() {
		int output = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				output = output + map[i][j];
			}
		}
		//공기청정기는 -1로 표시되어 있으니 +2 해주자.
		return output+2;
	}
}
class Pair {
	int y, x;
	int v;
	public Pair(int y, int x, int v) {
		// TODO Auto-generated constructor stub
		this.y = y;
		this.x = x;
		this.v = v;
	}
}