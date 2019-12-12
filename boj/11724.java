import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n,m,output = 0;
	//방문표시할 배열.
    public static boolean visited[];
    //그래프를 인접배열로!
	public static boolean map[][];
	public static void main(String args[]) throws IOException{
        //입력받고~
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		map = new boolean[n][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			map[y][x] = true;
			map[x][y] = true;
		}
        //노드들 쭉 둘러보면서
		for (int i = 0; i < n; i++) {
			//방문했으면 pass~
            if (visited[i]) continue;
			//재귀호출하자.
            recursive(i);
            //연결된 노드들의 집합을 찾아냈으니 +1 해주자.
			output++;
		}
		System.out.println(output);
	}
    //재귀로 가즈아~
	public static void recursive(int r) {
		for (int i = 0; i < n; i++) {
            //만약 가는길이 없다면 pass~
			if (!map[r][i]) continue;
            //방문했던 노드라면 pass~
            if (visited[i]) continue;
            //방문표시 해주고
			visited[i] = true;
            //다시 탐색 가즈아~
			recursive(i);
		}
	}
}
