import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * 제발 문제좀 꼼꼼히 읽자!
 * 0은 공간 1은 벽 2는 바이러스!
 * @author quadcore
 *
 */
public class Main{
	public static int n;	//sero
	public static int m;	//garo
	public static int output = 0;
	public static int[] dy = {0,0,1,-1};
	public static int[] dx = {1,-1,0,0};
	public static int[][]map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int [n][m];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		threeBlock(3, 0);
		System.out.println(output);
	}
	/*
	 * 맵에 벽을 3개 세우는 경우의 수를 구하는 함수.
	 * 백트레킹 사용.
	 */
	public static void threeBlock(int cnt, int start) {
		if (cnt == 0) {
			virus();
			return;
		}
		/*
		 * 본 문제의 핵심로직이라 본다.
		 * 2차원배열을 탐색하려 2중 for문 사용 대신에 아래와 같은 로직을 사용하자
		 * 0부터 가로*세로 만큼 탐색하면서, i의 값을 가로로 나누자.
		 * 몫은 y좌표, 나머지는 x좌표가 나올것이다.
		 */
		for (int i = start; i < m*n; i++) {
			int ny = i / m;
			int nx = i % m;
			if (map[ny][nx] == 0) {
				map[ny][nx] = 1;
				//threeBlock(cnt, start); <- 내가 했던 실수.
				threeBlock(cnt-1, i+1);
				map[ny][nx] = 0;
			}
		}
	}
	//안전영역을 카운트하는 함수.
	public static void cnt0(int[][] tmap) {
		int tmp = 0;
		for (int i = 0; i < tmap.length; i++) {
			for (int j = 0; j < tmap[0].length; j++) {
				if (tmap[i][j] == 0) {
					tmp = tmp + 1;
				}
			}
		}
		if (output < tmp) {
			output = tmp;
		}
	}
	//바이러스를 퍼트리는 함수.
	public static void virus() {
		LinkedList<Pair> list = new LinkedList<>();
		int[][]tmap = new int[n][m];
		for (int i = 0; i < tmap.length; i++) {
			for (int j = 0; j < tmap[0].length; j++) {
				tmap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (tmap[i][j] == 2) {
					Pair pair = new Pair(i, j);
					list.add(pair);
				}
			}
		}
		while (!list.isEmpty()) {
			Pair pair = list.poll();
			tmap[pair.y][pair.x] = 2;
			for (int i = 0; i < 4; i++) {
				int nx = pair.x + dx[i];
				int ny = pair.y + dy[i];
				if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
					if (tmap[ny][nx] == 0) {
						Pair nPair = new Pair(ny, nx);
						list.add(nPair);
					}
				}
			}
		}
		cnt0(tmap);
	}
}
class Pair {
	int y;
	int x;
	public Pair(int y, int x) {
		// TODO Auto-generated constructor stub
		this.y = y;
		this.x = x;
	}
}