import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		visited = new int[20000000];
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken()) + 10000000;
			visited[tmp]++;
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int tmp = Integer.parseInt(st.nextToken()) + 10000000;
			sb.append(visited[(tmp)]);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}