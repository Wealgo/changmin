import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * 테스트케이스마다 리스트를 초기화하지 않아서 시간많이 잡아먹음.
 * 차분히 쓰면서 풀면 충분히 풀 수 있는 문제.
 * 꼼꼼히 문제를 읽자.
 * 시간단축을 위해 정진하자.
 * @author quadcore
 *
 */
class Solution {
	public static int n,m,k;
	public static int map[][];
	public static boolean visited[][];
	public static LinkedList<Cell> list = new LinkedList<>();
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {1,-1,0,0};
	public static int output = 0;
	public static void main(String[] args) {
		//입력받고~
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		int testcase = Integer.parseInt(sc.nextLine());
		//테스트케이스만큼 가즈아~
		for (int t = 0; t < testcase; t++) {
			st = new StringTokenizer(sc.nextLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			/*
			 * 주어지는 맵의 최대크기가 50x50, 
			 * 최대 시간크기가 300인것을 고려하면
			 * 최악의 맵 크기는 750x750 사이즈인걸 알 수 있다.
			 * 넉넉하게 800으로 해주었다.
			 */
			map = new int[800][800];
			visited = new boolean[800][800];
			list = new LinkedList<>();	//초기화를 안해주어서 시간을 많이 잡아먹었다.
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(sc.nextLine());
				for (int j = 0; j < m; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if (tmp == 0) continue;
					//중간부터 세포를 넣어주기 위해 320++
					list.add(new Cell(i+320, j+320, tmp));
					visited[i+320][j+320] = true;				
				}
			}
			//배양 가즈아~
			sex();
			output = 0;
			for (int i = 0; i < list.size(); i++) {
				//죽은세포는 걸러주자.
				if (list.get(i).status == 2) continue;
				output = output + 1;
			}
			System.out.println("#" + (t+1) + " "+output);
		}
	}
	//세포 배양하는 함수.
	public static void sex() {
		LinkedList<Cell> newList = new LinkedList<>();
		//시간만큼 돌면서
		for (int t = 0; t < k; t++) {
			//세포 리스트만큼 돌자.
			while (!list.isEmpty()) {
				Cell c = list.pollFirst();
				int x = c.x, y = c.y, v = c.v;
				int time = c.time, status = c.status;
				//방문표시 해주자.
				visited[y][x] = true;
				//죽은세포는 걸러주자.
				if (status == 2) continue;
				//활성세포인 경우.
				if (c.status == 1) {
					//번식.
					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						//방문한 좌표는 걸러주자.
						if (visited[ny][nx]) continue;
						newList.add(new Cell(ny, nx, v));
						visited[ny][nx] = true;
					}
				}
				//시간 단축해주고,
				time = time - 1;
				//비활성->활성, 활성->죽음으로 상태변경.
				if (time == 0) {
					status = status +1;
					time = v;
				}
				//변경된 세포들을 리스트에 넣어주자.
				newList.addLast(new Cell(y, x, v, time, status));
			}
			list.addAll(newList);
			//생명력 수치가 높은 순서대로 정렬하자.
			Collections.sort(list);
			newList = new LinkedList<>();
		}
	}
}
//생명력 순으로 정렬하기 위해 Comparable를 상속받자.
class Cell implements Comparable<Cell> {
	int y,x,v,time;
	//0 - 비활성, 1 - 활성, 2 - 죽은셀.
	int status = 0;
	public Cell(int y, int x, int v) {
		// TODO Auto-generated constructor stub
		this.y = y; this.x = x; this.v = v; this.time = v;
	}
	public Cell(int y, int x, int v, int now, int status) {
		// TODO Auto-generated constructor stub
		this.y = y; this.x = x; this.v = v; this.time = now; this.status = status;
	}
	@Override
	public int compareTo(Cell o) {
		// TODO Auto-generated method stub
		return o.v - this.v;
	}
}