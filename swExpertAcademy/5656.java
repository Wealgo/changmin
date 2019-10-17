import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * 시간단축을 목표로 정진하자.
 * @author quadcore
 *
 */
class Solution {
	public static int n,w,h;	//w garo, h sero;
	public static int map[][];	
	public static int cmap[][];	
	public static int output;
	public static int[] sunseo;	//공을 떨어트리는 순서를 만들 배열.
	public static boolean destroyed[][];	//파괴된 좌표를 만들어주자.
	public static void main(String[] args) {
		//입력받고~
		Scanner sc = new Scanner(System.in);
		int testcase = Integer.parseInt(sc.nextLine());
		for (int t = 0; t < testcase; t++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			sunseo = new int[n];
			map = new int[h][w];
			cmap = new int[h][w];
			output = 9999999;
			destroyed = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(sc.nextLine());
				for (int j = 0; j < w; j++) {
					int v = Integer.parseInt(st.nextToken());
					map[i][j] = v;
					cmap[i][j] = v;
				}
			}
			//공을 떨어트리는 조합
			back(0);
			System.out.println("#"+(t+1)+" "+output);
		}
	}
	//백트레킹으로 공을 떨어트리는 순서를 만들자.
	public static void back(int cnt) {
		//기저조건.
		if (cnt == n) {
			//공을 떨어트리는 순서의 조합마다 처음 입력받은 대로 맵을 새로 초기화해주자.
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					cmap[i][j] = map[i][j];
				}
			}
			//공 떨구자!
			for (int i = 0; i < sunseo.length; i++) {
				fall(sunseo[i]);
			}
			//공을 다 떨군 상태이니 남아있는 벽돌을 카운트해보자.
			count();
			return;
		}
		//중복인 조합이니 0부터 시작이다.
		for (int i = 0; i < w; i++) {
			sunseo[cnt] = i;
			back(cnt+1);
		}
	}
	//공을 떨궈서 파괴하는 함수.
	public static void fall(int idx) {
		destroyed = new boolean[h][w];
		//before y
		int by = -1;
		//공이 떨어지는데 벽돌에 맞는지 확인하자.
		for (int i = 0; i < h; i++) {
			if (cmap[i][idx] != 0) {
				by = i;
				break;
			}
		}
		//공이 떨어졌는데 벽돌에 맞지 않는 경우는 걸러주자.
		if (by == -1) return;
		//탐색 리스트 선언
		LinkedList<Pair> list = new LinkedList<>();
		list.add(new Pair(by, idx, cmap[by][idx]));
		destroyed[by][idx] = true;
		//bfs처럼 돌자.
		while (!list.isEmpty()) {
			Pair tmp = list.remove();
			int y = tmp.y;
			int x = tmp.x;
			int v = tmp.v;
			destroyed[y][x] = true;
			//폭발 범위만큼 오른쪽으로 가즈아~
			for (int i = 1; i < v; i++) {
				int nx = x + i;
				//만약 맵의 끝까지 간 상태 && 맵이 이미 파괴된 상태
				if (nx < w && !destroyed[y][nx]) {
				destroyed[y][nx] = true;
				//다시 돌아야하니 탐색리스트에 넣어주자.
				list.add(new Pair(y, nx, cmap[y][nx]));
				}
			}
			//폭발범위만큼 왼쪽으로 가즈아~
			for (int i = 1; i < v; i++) {
				int nx = x - i;
				if (nx >= 0 && !destroyed[y][nx]) {
				destroyed[y][nx] = true;
					list.add(new Pair(y, nx, cmap[y][nx]));
				}
			}
			//아래쪽으로~
			for (int i = 1; i < v; i++) {
				int ny = y + i;
				if (ny < h && !destroyed[ny][x]) {
					destroyed[ny][x] = true;
					list.add(new Pair(ny, x, cmap[ny][x]));
				}
			}
			//위쪽으로~
			for (int i = 1; i < v; i++) {
				int ny = y - i;
				if (ny >= 0 && !destroyed[ny][x]) {
					destroyed[ny][x] = true;
					list.add(new Pair(ny, x, cmap[ny][x]));				
				}
			}
		}
		//폭발로 제거표시한 좌표를 제거해주자.
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (destroyed[i][j]) {
					cmap[i][j] = 0;
				}
			}
		}
		//붕 떠있는 맵을 당겨주자.
		fulldown();
	}
	public static void fulldown() {
		int[][] newmap = new int[h][w];
		LinkedList<Integer> list;
		//맵을 돌면서
		for (int i = 0; i < w; i++) {
			list = new LinkedList<>();
			for (int j = 0; j < h; j++) {
				//0이 아닌것들을 리스트에 담고
				if (cmap[j][i] != 0) {
					list.add(cmap[j][i]);
				}
			}
			//리스트의 끝까지 맵 아래에서 채워주자
			for (int j = h-1; j >= 0; j--) {
				if (list.isEmpty()) {
					break;
				}
				newmap[j][i] = list.pollLast();
			}
		}
		//전역변수 맵에 할당해주자.
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				cmap[i][j] = newmap[i][j];
			}
		}
	}
	//폭발을 끝낸 맵에서 남아있는 벽돌을 카운트하는 함수.
	public static void count() {
		int cnt = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (cmap[i][j] != 0) {
					cnt = cnt + 1;
				}
			}
		}
		//만약 최소값이라면,
		if (output > cnt) {
			//할ㅋ당ㅋ
			output = cnt;
		}
	}
}
class Pair {
	int x,y,v;
	public Pair(int y, int x, int v) {
		this.x = x;
		this.y = y;
		this.v = v;
	}
}