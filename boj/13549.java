import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 여러 시도 끝에 통과.
 * not EZ
 * @author quadcore
 */
class Main {
	public static int n, sister;
	public static int time;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		sister = Integer.parseInt(st.nextToken());
		visited = new boolean[100002];
		time = -1;
		System.out.println(bfs(n));
		
	}

	public static int bfs(int start) {
		int output = 999999;
		LinkedList<Pair> list = new LinkedList<>();
		list.add(new Pair(start, 0));
		while (!list.isEmpty()) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				Pair subin = list.poll();
				int idx = subin.idx;
				int time = subin.time;
				if (idx == sister) output = Math.min(output, time);
				if (idx > 100000) continue;
				if (idx < 0) continue;
				visited[idx] = true;
				if (idx-1 >= 0 && !visited[idx-1]) list.add(new Pair(idx-1, time+1));
				if (idx+1 <= 100000 && !visited[idx+1]) list.add(new Pair(idx + 1, time+1));
				if (idx*2 <= 100000 && !visited[idx*2]) list.add(new Pair(idx * 2, time));								
			}
		}
		return output;
	}
}
class Pair {
	int time, idx;
	public Pair(int idx, int time) {
		// TODO Auto-generated constructor stub
		this.time = time;
		this.idx = idx;
	}
}