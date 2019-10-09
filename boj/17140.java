import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * 정렬하는것이 이 문제의 핵심.
 * Comparable과 Comparator을 알면 쉽게 정렬 할 수 있다.
 * @author quadcore
 *
 */
public class Main {
	public static int[][] map = new int[100][100];
	public static int r,c,k;
	public static void main(String[] args) throws IOException {
		// 입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int output = 0;
		//map[r][c]의 값이 k일때까지 돌자~.
		while (map[r][c] != k) {
			//만약 100번을 넘어가면 더이상 반복하지 않게 해주자.
			if (output > 100) {
				output = -1;
				break;
			}
			output = output + 1;
			if (checkRC() == 'R') {
				doR();
			} else {
				doC();
			}
		}
		System.out.println(output);
	}
	//R연산인지 C연산인지 체크하는 함수.
	public static char checkRC() {
		//r 가로, c 세로의 개수.
		int r = 0,c = 0;
		//세로의 개수를 세는 반복문.
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] != 0) {
					c= c + 1;
					break;
				}
			}
		}
		//가로의 개수.
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[j][i] != 0) {
					r = r + 1;
					break;
				}
			}
		}
		if (c >= r) {
			return 'R';
		} else {
			return 'C';
		}
	}
	//C연산.
	public static void doC() {
		//새로운 맵 선언.
		int[][] newmap = new int[100][100];
		for (int i = 0; i < 100; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			//열을 돌면서 0이 아닌것들은 리스트에 담아두자.
			for (int j = 0; j < 100; j++) {
				if (map[j][i] == 0) continue;
				list.add(map[j][i]);
			}
			//리스트가 비어있다면 탈출~
			if (list.isEmpty()) break;
			//정렬시켜주고.
			Collections.sort(list);
			//"n이라는 숫자가 k개 있다"라는 것을 알기 위해 구조체 리스트 선언.
			LinkedList<Pair> sibal = new LinkedList<>();
			sibal.add(new Pair(list.get(0), 0));
			for (int j = 0; j < list.size(); j++) {
				//정렬된 리스트를 돌기 때문에 가장 마지막리스트의 값이 바뀌었는지 아닌지 확인.
				if (sibal.getLast().f == list.get(j)) {
					++sibal.getLast().b;
				} else {
					sibal.add(new Pair(list.get(j), 1));
				}
			}
			Collections.sort(sibal);
			int id = 0, b = 1;
			for (int j = 0; j < sibal.size(); j++) {
				newmap[id][i] = sibal.get(j).f;
				newmap[b][i] = sibal.get(j).b;
				b = b + 2;
				id = id + 2;
			}
		}
		map = newmap;
	}
	//R연산.
	public static void doR() {
		int[][] newmap = new int[100][100];
		for (int i = 0; i < 100; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 0) continue;
				list.add(map[i][j]);
			}
			if (list.isEmpty()) break;
			Collections.sort(list);
			LinkedList<Pair> sibal = new LinkedList<>();
			sibal.add(new Pair(list.get(0), 0));
			for (int j = 0; j < list.size(); j++) {
				if (sibal.getLast().f == list.get(j)) {
					++sibal.getLast().b;
				} else {
					sibal.add(new Pair(list.get(j), 1));
				}
			}
			Collections.sort(sibal);
			int id = 0, b = 1;
			for (int j = 0; j < sibal.size(); j++) {
				newmap[i][id] = sibal.get(j).f;
				newmap[i][b] = sibal.get(j).b;
				b = b + 2;
				id = id + 2;
			}
		}
		map = newmap;
	}
}
class Pair implements Comparable<Pair>{
	int f,b;
	public Pair(int f, int b) {
		// TODO Auto-generated constructor stub
		this.f = f;
		this.b = b;
	}
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return this.b - o.b;
	}
}