import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * not EZ
 * @author quadcore
 */
class Main {
	public static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Pair[] arr = new Pair[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(start, end);
		}
		Arrays.sort(arr);
		int cnt = 1;
		int end = arr[0].end;
		for (int i = 1; i < n; i++) {
			if (arr[i].start >= end) {
				cnt++;
				end = arr[i].end;
			}
		}
		System.out.println(cnt);
	}
}
class Pair implements Comparable<Pair>{
	int start, end;

	public Pair(int start, int end) {
		// TODO Auto-generated constructor stub
		this.end = end;
		this.start = start;
	}

	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		int diff = this.end - o.end;
		if (diff == 0) {
			diff = this.end - o.end;
		}
		return diff;
	}
}