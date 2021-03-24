import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Ez
 * @author quadcore
 */
class Main {
	public static int[] arr, map;
	public static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		map = new int[80001];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			arr[i] = tmp;
			sum += tmp;
			map[tmp+4000]++;
		}
		Arrays.sort(arr);
		int max = 0;
		int idx = 0;
		int cnt = 0;
		int ridx = 0;
		for (int i = map.length-1; i >= 0; i--) {
			if (map[i] == max) {
				idx = i;
				cnt++;
				if (cnt == 2) ridx = i;
			}
			if (map[i] > max) {
				cnt = 0;
				idx = i;
				max = map[i];
			}
		}
		
		bw.append((sum/n)+" ");
		bw.append((arr[n/2]+1)+" ");
		if (cnt > 1) {
			bw.append((ridx - 4000) + " ");
		} else {
			bw.append((idx - 4000)+" ");
		}
		
		bw.append((arr[n] - arr[0]) + " ");
		bw.flush();
	}
}
