import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static int a, b;
	public static int n, m;
	public static int answer = 0;
	public static boolean[] visited = new boolean[1000000];
	public static int dx[] = new int[6];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dx[0] = 1;
		dx[1] = -1;
		dx[2] = a;
		dx[3] = -a;
		dx[4] = b;
		dx[5] = -b;
		bfs(n);
		if (n == m) {
			System.out.println(0);
			return;
		}
		System.out.println(answer+1);
	}
	
	public static void bfs(int start) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(start);
		while (!list.isEmpty()) {
			int div = list.size();
			for (int i = 0; i < div; i++) {
				int now = list.poll();
				for (int d = 0; d < dx.length; d++) {
					int next = now + dx[d];
					if (next == m) return;
					if (next < 0 || next > 100000) continue;
					if (visited[next]) continue;
					visited[next] = true;
					list.add(next);
				}
				int superPower = now * a;
				if (superPower < 100000) {
					if (superPower == m) return;
					if (!visited[superPower]) {
						visited[superPower] = true;
						list.add(superPower);
					}
				}
				superPower = now * b;
				if (superPower < 100000) {
					if (superPower == m) return;
					if (!visited[superPower]) {
						visited[superPower] = true;
						list.add(superPower);
					}
				}
			}
			answer++;
		}
	}
}