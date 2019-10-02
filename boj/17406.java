import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 백트레킹으로 회전연산의 순서를 정하는것이 문제의 핵심.
 * 회전을 구현하는 부분에서 시간을 많이 소요함.
 * @author quadcore
 *
 */
public class Main {
	public static int tmap[][];
	public static int n,m,k;
	public static ArrayList<Wheel> wheels = new ArrayList<Wheel>();
	public static int[] order;
	public static boolean visited[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		tmap = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				tmap[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[k];
		order = new int[k];
		//회전연산 받아주고~
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			wheels.add(new Wheel(r,c,d));
		}
		//회전연산 시작해보자.
		sequence(0, 0);
		System.out.println(output);
	}
	public static int output = 999999999;
	//백트레킹으로 회전연산을 실행할 순서 정하기.
	public static void sequence(int idx, int cnt) {
		if (cnt > k-1) {
			//order의 순서대로 가즈아~
			int newmap[][] = tmap;
			for (int i = 0; i < order.length; i++) {
				newmap = rotate(newmap, wheels.get(order[i]));
			}
			count(newmap);
			return;
		}
		for (int i = 0; i < k; i++) {
			if (!visited[i]) {
				visited[i] = true;
				order[cnt] = i;
				sequence(i+1, cnt+1);
				visited[i] = false;
			}
		}
	}
	//각 행의 최소값을 확인하는 함수.
	public static void count(int[][] map) {
		for (int i = 0; i < n; i++) {
			int tmp = 0;
			for (int j = 0; j < m; j++) {
				tmp = tmp + map[i][j];
			}
			if (tmp < output) {
				output = tmp;
			}
		}
	}
	//회전연산.
	public static int[][] rotate(int[][] map, Wheel magic) {
		int[][] newmap = new int[n][m];
		int y = magic.y;
		int x = magic.x;
		int dic = magic.dic;
		for (int k = 1; k <= dic; k++) {
			int tmp = x - k + 1;
			for (int i = 0; i < k*2; i++) {
				newmap[y-k][tmp+i] = map[y-k][tmp+i-1];
			}
			tmp = x + k - 1;
			for (int i = 0; i < k*2; i++) {
				newmap[y+k][tmp-i] = map[y+k][tmp-i+1];
			}
			tmp = y - k + 1;
			for (int i = 0; i < k*2; i++) {
				newmap[tmp+i][x+k] = map[tmp+i-1][x+k];
			}
			tmp = y + k - 1;
			for (int i = 0; i < k*2; i++) {
				newmap[tmp-i][x-k] = map[tmp-i+1][x-k];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (newmap[i][j] == 0) {
					newmap[i][j] = map[i][j];
				}
			}
		}
		return newmap;
	}
}
class Wheel {
	int y,x;
	int dic;
	public Wheel(int y, int x, int dic) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.dic = dic;
	}
}