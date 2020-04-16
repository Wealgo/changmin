import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int d,w,k;
	public static boolean[][] map, copyMap;
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
			copyMap = new boolean[d][w];
			visited = new boolean[d];
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					if (st.nextToken().equals("0")) {
						map[i][j] = true;
						copyMap[i][j] = true;
					}
				}
			}
			if (isTong(map) || k == 1) {
				System.out.println("#"+(t+1)+" "+0);
				continue;
			}
			int cnt = 1;
			while (!ise) {
				
				back(cnt, 0, copyMap);
				cnt++;
			}
			System.out.println("#"+(t+1)+" "+(cnt-1));
		}
	}
	public static void back(int cnt, int idx, boolean[][] map) {
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
		inj(map, idx, false);
		back(cnt-1, idx+1, copyMap);
		inj(map, idx, true);
		back(cnt-1, idx+1, copyMap);
		recover(idx);
	}
	public static void inj(boolean[][] map, int idx, boolean yak) {
		Arrays.fill(copyMap[idx], yak);
	}
	public static void recover(int idx) {
		copyMap[idx] = map[idx].clone();
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
			if (i > cnt) {
				return false;
			}
		}
		if (cnt == w) {
			return true;
		}
		return false;
	}
}
