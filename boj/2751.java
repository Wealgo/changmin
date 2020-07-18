import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[2000001];
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine())+1000000;
			visited[tmp] = true;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) continue;
			bw.append((i-1000000)+"\n");
		}
		bw.flush();
	}
}