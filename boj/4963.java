import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	public static int[][] map;
	public static boolean[][] visited;
	public static int output = 0;
	public static int h,w;
    //상하좌우대각선 총 8방향.
	public static int[] dx = {0,0,1,-1,1,-1,1,-1};
	public static int[] dy = {1,-1,0,0,1,-1,-1,1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated constructor stub
        //입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
            //0 0이 들어오면 탈출하자
			if (w == 0 && h == 0) break;
            //맵 초기화
			map = new int[h][w];
			//방문표시할 맵 초기화
            visited = new boolean[h][w];
			output = 0;
            //맵 상태 입력받자~
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
            //섬이 몇개인지 카운트하고
			countIsland();
            //정답출력!
			System.out.println(output);
		}
	}
    //섬이 몇개인지 카운트하는 함수
	public static void countIsland() {
        //맵 쭉 돌면서
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				//육지이면서 방문을 하지 않은 좌표면
                if (map[i][j] == 0 || visited[i][j]) continue;
				//탐색 가즈아~
                bfs(i,j);
                //섬이 생성되었으니 +1 해주자.
				++output;
			}
		}
	}
    //넓이우선탐색
    public static void bfs(int y, int x) {
        //처음 들어온 좌표는 방문했다고 해주자.
		visited[y][x] = true;
        //좌표 만들어주고
		Pair tmp = new Pair(y, x);
		//좌표를 담을 리스트 생성
        LinkedList<Pair> list = new LinkedList<>();
		list.add(tmp);
        //리스트가 텅빌때까지 돌자.
		while (!list.isEmpty()) {
            //리스트에서 하나 뽑아내고
			Pair p = list.poll();
            //상하좌우대각선 보면서
			for (int i = 0; i < dx.length; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				//맵 밖으로 벗어나지 않고
                if (ny >= 0 && nx >= 0 && ny < h && nx < w) {
					//이미 방문한 좌표는 pass~
                    if (visited[ny][nx]) continue;
					//육지가 아닌곳은 pass~
                    if (map[ny][nx] == 0) continue;
                    //방문표시 해주고
					visited[ny][nx] = true;
					//리스트에 넣어주자.
                    list.add(new Pair(ny, nx));
				}
			}
		}
	}
}
//좌표 구현체
class Pair {
	int x, y;
	public Pair(int y, int x) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}