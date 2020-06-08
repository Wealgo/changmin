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
	public static int n,m;
	public static boolean[] visited = new boolean[200000000];
	public static LinkedList<Integer> list = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			visited[10000000+Integer.parseInt(st.nextToken())] = true;
		}
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			if (visited[10000000 + list.get(i)]) sb.append(1 + " ");
			else sb.append(0 + " ");
		}
		System.out.println(sb.toString());
	}
}