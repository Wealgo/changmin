import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
/**
 * 습관적인 리스트사용을 지양하자.
 * 나무를 리스트로 관리하였기 때문에 시간초과 발생.
 * 리스트 -> 덱으로 변경하니 통과.
 * 이 문제를 해결하기 위해 2시간 소비.
 * @author quadcore
 *
 */
public class Main {
	public static int n,m,k;
	public static int[][] map, emap;
	public static Deque<Tree> trees,dTrees;
	public static int[] dx = {0,0,1,-1,1,1,-1,-1};
	public static int[] dy = {1,-1,0,0,1,-1,1,-1};
	public static void main(String[] args) throws IOException {
		// 입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		trees = new ArrayDeque<>();
		dTrees = new ArrayDeque<>();
		map = new int[n][n];
		emap = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				emap[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			trees.add(new Tree(y, x, age));
		}
		
		for (int i = 0; i < k; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(trees.size());
	}
	//봄
	public static void spring() {
		//Collections.sort(trees);
		Deque<Tree> newTrees = new ArrayDeque<>();
		while (!trees.isEmpty()) {
			Tree tmp = trees.pollFirst();
			int x = tmp.x;
			int y = tmp.y;
			int age = tmp.age;
			if (map[y][x] >= age) {
				map[y][x] = map[y][x] - age;
				//나이를 먹는 나무들은 뒤로 배치해주자.
				newTrees.addLast(new Tree(y, x, age+1));
			} else {
				dTrees.add(tmp);
			}
		}
		trees.addAll(newTrees);
	}
	//여름
	public static void summer() {
		while (!dTrees.isEmpty()) {
			Tree tmp = dTrees.poll();
			int x = tmp.x;
			int y = tmp.y;
			int age = tmp.age;
			map[y][x] = map[y][x] + age/2;
		}
	}
	//가을
	public static void fall() {
		Deque<Tree> newTree = new ArrayDeque<>();
		while (!trees.isEmpty()) {
			Tree tmp = trees.poll();
			int x = tmp.x;
			int y = tmp.y;
			int age = tmp.age;
			if (age%5 == 0) {
				for (int d = 0; d < 8; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
						//새로 생겨난 나무들은 앞으로 배치해주자.
						newTree.addFirst(new Tree(ny, nx, 1));
					}
				}
			}
			newTree.addLast(tmp);
		}
		trees.addAll(newTree);
	}
	//겨울
	public static void winter() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = map[i][j] + emap[i][j];
			}
		}
	}
}
class Tree{
	int y,x;
	int age;
	public Tree(int y, int x, int age) {
		this.y = y;
		this.x = x;
		this.age = age;
	}
}