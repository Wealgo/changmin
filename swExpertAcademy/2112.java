import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int d,w,k;
	public static boolean[][] map;
	public static boolean[] visited;
	public static boolean ise = false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testcase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			ise = false;
			map = new boolean[d][w];
			visited = new boolean[d];
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					if (st.nextToken().equals("0")) map[i][j] = true;
				}
			}
			if (isTong(map)) {
				System.out.println("#"+(t+1)+" "+0);
				continue;
			}
			int cnt = 1;
			while (!ise) {
				back(cnt, 0, map);
				cnt++;
			}
			System.out.println("#"+(t+1)+" "+(cnt-1));
		}
	}
	public static void back(int cnt, int idx, boolean[][] map) {
//		System.out.println("bia");
		if (cnt == 0) {
			if (isTong(map)) {
				ise = true;
			}
			return;
		}
		if (idx >= d) return;
		visited[idx] = false;
		back(cnt, idx+1, map);
		visited[idx] = true;
		boolean[][] nm = inj(map, idx, false);
		back(cnt-1, idx+1, nm);
		nm = inj(map, idx, true);
		back(cnt-1, idx+1, nm);
	}
	public static boolean[][] inj(boolean[][] map, int idx, boolean yak) {
		boolean[][] nm = new boolean[d][w];
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < w; j++) {
				nm[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < w; i++) {
			nm[idx][i] = yak;
		}
		return nm;
	}
	//good
	public static boolean isTong(boolean[][] map) {
		int cnt = 0;
		for (int i = 0; i < w; i++) {
			boolean tmp = map[0][i];
			int col = 1;
			for (int j = 1; j < d; j++) {
				if (map[j][i] != tmp) {
					col = 1;
					tmp = map[j][i];
				} else {
					col++;
				}
				if (col == k) {
					cnt++;
					break;
				}
			}
		}
		if (cnt == w) {
			return true;
		}
		return false;
	}
}
