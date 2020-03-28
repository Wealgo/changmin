import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int computers;
	public static int networks;
	public static boolean map[][];
	public static boolean visited[];
	public static int output = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		computers = Integer.parseInt(br.readLine());
		networks = Integer.parseInt(br.readLine());
		map = new boolean[computers][computers];
		visited = new boolean[computers];
		for (int i = 0; i < networks; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			map[y][x] = true;
			map[x][y] = true;
		}
		bfs(0);
		System.out.println(output);
	}
	public static void bfs(int start) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(start);
		visited[start] = true;
		while (!list.isEmpty()) {
			int tmp = list.poll();
			for (int i = 0; i < map.length; i++) {
				if (!map[tmp][i]) continue;
				if (visited[i]) continue;
				visited[i] = true;
				list.add(i);
				output++;
			}
		}
	}
}