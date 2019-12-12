import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
 * bfs로 접근.
 * 인접배열로 헛간 관계를 표현.
 * "어떤 헛간에서 다른 헛간으로는 언제나 도달 가능하다"라고 명시되어 있으니 방문 못하는 헛간은 제외.
 */
public class Main {
	//헛간 개수와 간선의 개수.
	public static int n,m;
	//방문배열을 거리로 표현하자.
	public static int[] visited;
	//인접배열로 헛간을 표현.
	public static boolean[][] map;
	public static void main(String[] args) throws IOException {
		//입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken())+1;
		m = Integer.parseInt(st.nextToken());
		visited = new int[n];
		map = new boolean[n][n];
		//간선의 개수만큼 입력받즈아~
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
			map[b][a] = true;
		}
		//bfs돌자.
		bfs();
		//maximum distance 최대거리.
		int md = 0;
		//좌표.
		int idx = 0;
		//같은 최대거리를 가지고 있는 헛간의 개수.
		int cnt = 0;
		//헛간의 개수만큼 돌면서~
		for (int i = 0; i < n; i++) {
			//최대거리 걸러내자.
			if (visited[i] > md) {
				md = visited[i];
				idx = i;
				cnt = 0;
			}
			//만약 최대거리와 같다면 ++해주자.
			if (visited[i] == md) {
				++cnt;
			}
		}
		//첫번째 헛간의 거리를 1로 해주었으니 최대거리에서 -1 해주자.
		System.out.println(idx + " " + (md-1) + " " + cnt);
	}
	public static void bfs() {
		LinkedList<Pair> list = new LinkedList<>();
		//리스트에 넣고.
		list.add(new Pair(1, 1));
		//방문표시 해주고.
		visited[1] = 1;
		//탐색 가즈아~
		while (!list.isEmpty()) {
			Pair p = list.poll();
			int idx = p.idx, cnt = p.cnt;
			//각 헛간을 보면서.
			for (int i = 0; i < n; i++) {
				//해당 헛간에서 갈 수 없다면 pass.
				if (!map[idx][i]) continue;
				//방문한 헛간도 pass.
				if (visited[i] != 0) continue;
				list.add(new Pair(i, cnt+1));
				visited[i] = cnt+1;
			}
		}
	}
}
class Pair {
	int idx,cnt;
	public Pair(int idx, int cnt) {
		// TODO Auto-generated constructor stub
		this.cnt = cnt;
		this.idx = idx;
	}
}