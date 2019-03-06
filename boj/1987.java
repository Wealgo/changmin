import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{
	//dx, dy의 같은 순서가 하나의 쌍이 되어 하나의 방향을 나타낸다.
	//즉 dx,dy의 첫번째 값들을 보면 (0,-1)인데, 아래를 뜻한다.
	//dx,dy의 두번째값들을 보자 (0,1)이다. 위쪽 방향을 뜻한다.
	//이렇게 위아래좌우를 나타낸다.
	public static int[] dy = {-1, 1, 0, 0};
	public static int[] dx = {0, 0, -1, 1};
	//방문한 배열 선언
	//알파벳의 총 갯수는 27개이니 크기도 27로 선언.
	//각각의 배열이 알파뱃의 위치/방문유무를 나타낸다.
	public static boolean[] visited = new boolean[27];
    //결과값.
	public static int output;
	//전체지도.
    public static char[][] map;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	//입력값 받고.
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int x = Integer.parseInt(st.nextToken());
    	int y = Integer.parseInt(st.nextToken());
    	map = new char[x][y];
    	output = 0;
    	for (int i = 0; i < map.length; i++) {
			String tmp = br.readLine();
    		for (int j = 0; j < map[0].length; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
    	br.close();
    	//0,0부터 탐색 시작한다.
    	dfs(0, 0, 0);
    	System.out.println(output);
    }
    public static void dfs(int y, int x, int cnt) {
    	//탐색해서 들어간 횟수를 cnt로 한다.
    	//만약 cnt값이 output보다 크면 output값으로 할당.
    	if (output < cnt) {
			output = cnt;
		}
    	//위아래좌우를 돌아본다.
    	for (int i = 0; i <= 3; i++) {
			//ny는 next y좌표를, nx는 next x좌표를 의미한다.
    		int ny = y+dy[i];
			int nx = x+dx[i];
			//다음 x와 y의 좌표가 0보다 작거나, 맵의 크기를 벗어나면,
			if (ny < 0 || ny >= map.length || nx < 0 || nx >=map[0].length) {
				//아무것도 안함ㅋ
				continue;
			} else {
				//맵의 좌표에 해당되는 알파뱃에 아스키코드 'A'를 빼면 visited배열의 위치를 알 수 있다.
				//만약 방문했다면,
				if (visited[map[y][x] - 'A']) {
					//아무고토 안함ㅋ
					continue;
				} else {
					//방문되지 않았다면,
					//방문했다고 표시해주고,
					visited[map[y][x] - 'A'] = true;
					//한번 방문되지 않은 위치로 들어간다.
					//방문을 뜻하는 cnt도 한번 더 들어가니 ++해주자.
					dfs(ny, nx, cnt+1);
					//백트래킹에선 방문되지 않았다고 표시해야니 다시 false로 바꿔준다.
					visited[map[y][x] - 'A'] = false;
				}
			}
		}
    }
    
}