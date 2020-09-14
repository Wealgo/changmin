import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 반례 1 4
 * not EZ
 * @author quadcore
 */
class Main {
	public static int n, sister;
	public static int cnt, time;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		sister = Integer.parseInt(st.nextToken());
		visited = new boolean[200002];
		time = -1;
		cnt = 0;
		bfs(n);
		System.out.println(time);
		System.out.println(cnt);
	}

	public static void bfs(int start) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(start);
		while (!list.isEmpty()) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				int subin = list.poll();
				if (subin == sister) cnt++;
				if (subin > 100000) continue;
				if (subin < 0) continue;
				visited[subin] = true;
				if (subin-1 >= 0 && !visited[subin-1]) list.add(subin-1);
				if (!visited[subin+1] && subin+1 <= 100000) list.add(subin+1);
				if (!visited[subin*2] && subin*2 <= 100000) list.add(subin*2);	
			}
			time++;
			if (cnt != 0) return;
		}
	}
}