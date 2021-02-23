import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Ez
 * @author quadcore
 */
class Main {
	public static int n, d, k, c;
	public static int[] map, list;
	public static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		list = new int[n];
		map = new int[d+1];
		visited = new boolean[d+1];
		for (int i = 0; i < n; i++) list[i] = Integer.parseInt(br.readLine());
		sliceWindow();
		System.out.println(output);
	}
	public static int output;
	public static void sliceWindow() {
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			map[list[i]]++;
			if (visited[list[i]]) continue;
			visited[list[i]] = true;
			cnt++;
		}
		output = cnt;
		int start = 1;
		int end = k;
		for (int i = 0; i < n; i++) {
			if (end >= n) break;
			map[list[start]]--;
			map[list[end]]++;
			if (map[list[start]] == 0) cnt--;
			if (map[list[end]] == 1) cnt++;
			start++;
			end++;
			if (map[c] != 0) {
				cnt++;
				output = Math.max(output, cnt);
				if (cnt == 7) System.out.println("I:"+i);
				cnt--;
			} else {
				output = Math.max(output, cnt);
			}
			
		}
	}
}