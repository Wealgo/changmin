import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n;
	public static int m;
	public static boolean[] visited;
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		sb = new StringBuilder();
		rec(0, 0, "");
		System.out.println(sb);
	}
	public static void rec(int cnt, int idx, String str) {
		if (cnt == m) {
			sb.append(str.trim()+"\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			rec(cnt+1, i, str+" "+(i+1));
		}
	}

}
