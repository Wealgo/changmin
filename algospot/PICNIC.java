import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int output;
	public static int n,m;
	public static boolean[][] areFriends;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < testcase; i++) {
			areFriends = new boolean [10][10];
			output = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				areFriends[y][x] = true;
				areFriends[x][y] = true;
			}
			boolean taken[] = new boolean[10];
			output = recursive(taken);
			System.out.println(output);
		}
	}
	public static int recursive(boolean[] taken) {
		int idx = -1;
		for (int i = 0; i < n; i++) {
			if (!taken[i]) {
				idx = i;
				break;
			}
		}
		if (idx == -1) return 1;
		int ret = 0;
		for (int i = idx+1; i < n; i++) {
			if (!taken[i] && areFriends[idx][i]) {
				taken[idx] = taken[i] = true;
				ret += recursive(taken);
				taken[idx] = taken[i] = false;
			}
		}
		return ret;
	}
}
