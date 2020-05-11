import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 인접행렬의 함정.
 * 들어올 수 있는 도시의 크기가 최대 30만이다.
 * 이걸 int 타입 인접행렬로 표시하려면 4 * 30만^2이므로 메모리가 초과된다.
 * 따라서 인접행렬보단 리스트행렬로 표현해야 메모리초과가 발생하지 않는다.
 * @author quadcore
 */
class Main {
	public static int n, m, k, start;
	public static LinkedList<Integer>[] map;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken())-1;
		map = new LinkedList[n];
		visited = new boolean[n];
		for (int i = 0; i < map.length; i++) {
			map[i] = new LinkedList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			if (map[from] == null) {
				map[from] = new LinkedList<>();
			}
			map[from].add(to);
		}
		
		bfs();
	}
	public static void bfs() {
		LinkedList<Integer> list = new LinkedList<>();
		visited[start] = true;
		list.add(start);
		int phase = 0;
		
		while (!list.isEmpty()) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				int p = list.poll();
				
				for (int j = 0; j < map[p].size(); j++) {
					int n = map[p].get(j);
					if (visited[n]) continue;
					visited[n] = true;
					list.add(map[p].get(j));
				}
			}
			phase++;
			if (phase == k) {
				if (list.size() == 0) {
					System.out.println(-1);
					return;
				}
				Collections.sort(list);
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i)+1);
				}
				return;
			}
		}
		System.out.println(-1);
	}
}