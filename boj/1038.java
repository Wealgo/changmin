import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Ez
 * @author quadcore
 */
class Main {
	public static int n;
	public static boolean[] visited;
	public static LinkedList<Integer> list = new LinkedList<>();
	public static int[] map = new int[100000000];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		int i = 1;
		while (list.size() <= n) {
			visited = new boolean[1000001];
			backtracking(0, 9, i);
			i++;
		}
	}
	public static void backtracking(int idx, int cnt, int m) {
		if (idx > m) return;
		if (cnt == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					System.out.print((i+1)+" ");
					sb.append((i+1));
				}
			}
			list.add(Integer.parseInt(sb.toString()));
			System.out.println();
			return;
		}
		visited[idx] = true;
		backtracking(idx+1, cnt-1, m);
		visited[idx] = false;
		backtracking(idx+1, cnt, m);
	}
}