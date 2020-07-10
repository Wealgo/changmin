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
		int max = 0;
		int min = 9999999;
		boolean[] visited = new boolean[2000001];
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine())+1000000;
			max = Math.max(tmp, max);
			min = Math.min(min, tmp);
			visited[tmp] = true;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = max; i >= min; i--) {
			if (!visited[i]) continue;
			bw.append((i-1000000)+"\n");
		}
		bw.flush();
	}
}