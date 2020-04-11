import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int garo, sero;
	public static boolean[] map;
	public static int sackPaper;	//사용가능한 색종이의 
	public static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		sackPaper = Integer.parseInt(br.readLine());
		int cnt = Integer.parseInt(br.readLine());
		map = new boolean[garo];
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken())-1;
			if (answer < y) {
				answer = y;
			}
			map[x] = true;
		}
		int tmp = 0;
		while (true) {
			if (answer > map.length) break;
			tmp = start();
			if (tmp <= sackPaper) break;
			answer++;
		}
		if (tmp > answer) {
			System.out.println();
		}
		System.out.println(answer);
	}
	
	public static int start() {
		int output = 0;
		int idx = 0;
		while (idx <= map.length) {
			if (!map[idx]) {idx++; continue;}
			output++;
			idx += answer;
		}
		return output;
	}
}
