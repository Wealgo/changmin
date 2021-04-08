import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int n, x;
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		int start = 0;
		int end = n-1;
		int output = 0;
		
		while (start < end) {
			if (arr[start] + arr[end] >= x) {
				if (arr[start]+arr[end] == x) output++;
				end--;
			} else start++;
		}
		bw.append(output+"");
		bw.flush();
	}
}
