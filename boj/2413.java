import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Ez
 * @author quadcore
 */
class Main {
	public static int n;
	public static int[] arr, output;
	public static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		output = new int[n];
		visited = new boolean[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
		greedy();
		for (int i = 0; i < output.length; i++) {
			bw.append(arr[i] + " ");
		}
		bw.flush();
	}
	public static void greedy() {
		int tmp;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if(arr[i]-1 != arr[j] || visited[j]) continue;
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				visited[j] = true;
				break;
			}
		}
	}
}