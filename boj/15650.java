import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 침착하자.
 * @author quadcore
 *
 */
public class Main {
	public static int n,m;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken())+1;
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		te(0, m);
	}
	public static void te(int idx, int cnt) {
		if (idx >= n) return;
		if (cnt == 0) {
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					System.out.print((i+1)+" ");
				}
			}
			System.out.println();
			return;
		}
		visited[idx] = true;
		te(idx+1, cnt-1);
		visited[idx] = false;
		te(idx+1, cnt);
	}
	
}