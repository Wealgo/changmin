import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	public static int n;
	public static int m;
	public static int output = 99999;
	public static LinkedList<Home> homes = new LinkedList<>();
	public static LinkedList<Chicken> chickens = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		//입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				String tmp = st.nextToken();
				if (tmp.equals("1")) {
					Home home = new Home(i, j);
					homes.add(home);
				} else if (tmp.equals("2")) {
					Chicken chicken = new Chicken(i, j);
					chickens.add(chicken);
				}
			}
		}
		boolean [] visited = new boolean[chickens.size()];
		comchicken(visited, m, 0);
		System.out.println(output);
	}
	//치킨거리 계산하는 함수.
	public static int calchi(boolean[] visited, Home home) {
		int cd = 99999;
			for (int j = 0; j < visited.length; j++) {		
				if (!visited[j]) continue;
				int x = Math.abs(home.x - chickens.get(j).x);
				int y = Math.abs(home.y - chickens.get(j).y);
				int tmp = x + y;
				if (cd > tmp ) {
					cd = tmp;
				}
			}
		return cd;
	}
	/*
	 * 폐업되지 않을 치킨집의 조합을 구하는 함수.
	 * 백트레킹을 사용.
	 */
	public static void comchicken(boolean visited[], int cnt, int idx) {
		//치킨집조합완성.
		if (cnt == 0) {
			int tmp = 0;
			for (int i = 0; i < homes.size(); i++) {
				tmp = tmp + calchi(visited, homes.get(i));
			}
			if (tmp < output) {
				output = tmp;
			}
			return;
		}
		//치킨집선정.
		if (idx > visited.length-1) {
			return;
		}
		visited[idx] = true;
		comchicken(visited, cnt-1, idx+1);
		visited[idx] = false;
		comchicken(visited, cnt, idx+1);
	}
}
class Home {
	int x,y;
	public Home(int y, int x) {
		// TODO Auto-generated constructor stub
		this.y = y;
		this.x = x;
	}
}
class Chicken {
	int y,x;
	public Chicken(int y, int x) {
		// TODO Auto-generated constructor stub
		this.y = y;
		this.x = x;
	}
}