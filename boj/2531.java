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
	public static int n, d, k, c;
	public static int[] wheel, map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken())-1;
		wheel = new int[n*2+1];
		map = new int[30001];
		for (int i = 0; i < n; i++) wheel[i] = Integer.parseInt(br.readLine())-1;
		for (int i = 0; i < n; i++) wheel[n+i] = wheel[i];
		for (int i = 0; i < wheel.length; i++) {
			System.out.print(wheel[i]+" ");
		}
		System.out.println();
		System.out.println(slideWindow());
		
	}
	public static int slideWindow() {
		int start = 0;
		int sum = 0;
		int output = 0;
		
		for (int i = 0; i < n+k; i++) {
			map[wheel[i]]++;
			if (map[wheel[i]] == 1) sum++;
			
			if (i >= k) {
				map[wheel[start]]--;
				if (map[wheel[start]] == 0) sum--;
				start++;
			}
			int tmp = 1;
			if (!(map[c] > 0)) {
				tmp = tmp + sum;
				output = Math.max(output, tmp);
			} else output = Math.max(output, sum);
		}
		return (output);
	}
}