import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new boolean[n+1][n+1];
		int root;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int del = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp == -1) {
				del = tmp;
				continue;
			}
			map[tmp][i] = true;
			map[i][tmp] = true;
		}
	}
}
