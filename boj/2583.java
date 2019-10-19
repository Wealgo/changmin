import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 기본적인 탐색문제.
 * @author quadcore
 *
 */
public class Main {
	public static int n,m,k;	//n = garo, m = sero, k = 사각형의 개수;
	public static boolean[][] map;
	public static boolean[][] visited;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static LinkedList<Integer> output = new LinkedList<>();
	public static int result;
	public static void main(String[] args) throws IOException {
		//입력 받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		visited = new boolean[n][m];
		for (int t = 0; t < k; t++) {
			st = new StringTokenizer(br.readLine());
			int dx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			int ux = Integer.parseInt(st.nextToken());
			int uy = Integer.parseInt(st.nextToken());
			//사각형 그리자
			for (int i = dy; i < uy; i++) {
				for (int j = dx; j < ux; j++) {
					map[i][j] = true;
				}
			}
		}
		//맵돌면서 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				//탐색 시작 할 수 있는 위치면 탐색가자!
				if (!map[i][j] && !visited[i][j]) {
					result = 1;
					dfs(i, j);
					output.add(result);
				}
			}
		}
		System.out.println(output.size());
		//오름차순 정렬시켜주고.
		Collections.sort(output);
		//출력.
		for (int i = 0; i < output.size(); i++) {
			bw.write(output.get(i)+" ");
		}
		bw.flush();
	}
	public static void dfs(int y, int x) {
		//들어왓으면 방문표시 찍어주고.
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			//맵 벗어나지 않게 해주고.
			if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
				//방문표시 되어잇지 않은 좌표이면서 탐색 가능한 좌표이면.
				if (!visited[ny][nx] && !map[ny][nx]) {
					//탐색한 영역 추가해주고.
					result = result + 1;
					//다시 들어가즈아.
					dfs(ny, nx);
				}
			}
		}
	}
}