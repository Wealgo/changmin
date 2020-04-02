import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * EZ
 * @author quadcore
 *
 */
public class Main {
	public static int n;
	public static int[][] map;
	public static boolean[] visited;
	public static int output = 99999;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[n];
		divideTeam(0, n/2);
		System.out.println(output);
	}
	public static void divideTeam(int idx, int cnt) {
		if (idx >= n) return;
		if (cnt == 0) {
			LinkedList<Integer> startTeam = new LinkedList<>();
			LinkedList<Integer> linkTeam = new LinkedList<>();
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					startTeam.add(i);
				} else {
					linkTeam.add(i);
				}
			}
			int startPower = cal(startTeam);
			int linkPower = cal(linkTeam);
			if (output > Math.abs(startPower - linkPower)) {
				output = Math.abs(startPower - linkPower);
			}
			return;
		}
		visited[idx] = true;
		divideTeam(idx+1, cnt-1);
		visited[idx] = false;
		divideTeam(idx+1, cnt);
	}
	public static int cal(LinkedList<Integer> list) {
		int cnt = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i == j) continue;
				cnt += map[list.get(i)][list.get(j)];
			}
		}
		return cnt;
	}
}