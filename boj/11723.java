import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * not EZ
 * @author quadcore
 */
class Main {
	public static int n;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[21];
		boolean[] nv = new boolean[21];
		for (int i = 0; i < nv.length; i++) {
			nv[i] = true;
		}
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.startsWith("r")) {
				int tmp = Integer.parseInt(st.nextToken());
				if (visited[tmp]) {
					visited[tmp] = false;
				}
			} else if (command.startsWith("c")) {
				int tmp = Integer.parseInt(st.nextToken());
				if (visited[tmp]) {
					bw.append('1');
					bw.append('\n');
				} else {
					bw.append('0');
					bw.append('\n');
				}
			} else if (command.startsWith("t")) {
				int tmp = Integer.parseInt(st.nextToken());
				if (visited[tmp]) {
					visited[tmp] = false;
				} else {
					visited[tmp] = true;
				}
			} else if (command.startsWith("e")) {
				visited = new boolean[21];
			} else if (command.equals("all")) {
				visited = nv.clone();
			} else {
				int tmp = Integer.parseInt(st.nextToken());
				if (!visited[tmp]) {
					visited[tmp] = true;
				}
			}
		}
		bw.flush();
	}
}