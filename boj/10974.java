import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 
 * @author quadcore
 */
class Main {
	public static int n;
	public static boolean[] visited;
	public static int[] arr;
	public static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		arr = new int[n];
		backtracking(n, 0);
		bw.flush();
	}

	public static void backtracking(int cnt, int idx) throws IOException {
		if (cnt == 0) {
			for (int i = 0; i < arr.length; i++) {
				StringBuilder sb = new StringBuilder();
				sb.append(arr[i]+1);
				sb.append(" ");
				bw.write(sb.toString());
			}
			bw.newLine();
		}
		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			arr[idx] = i;
			backtracking(cnt-1, idx+1);
			visited[i] = false;
		}
	}
}