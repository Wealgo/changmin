
import java.util.LinkedList;
import java.util.Scanner;


public class Main{
	//상하좌우로 돌기 위해 dx, dy배열을 사용함.
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {-1,1,0,0};
	public static int m,n;
	public static int[][] box;
	//방문배열을 활용함.
	public static int[][] visit;
	public static int day = 0;
    public static void main(String[] args) {
    	//입력받고~
    	Scanner sc = new Scanner(System.in);
    	m = sc.nextInt();
    	n = sc.nextInt();
    	box = new int [n][m];
    	visit = new int [n][m];
    	
    	for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[0].length; j++) {
				box[i][j] = sc.nextInt();
			}
		}
    	//x,y를 받을 리스트 선언~
    	LinkedList<Integer> xlist = new LinkedList<>();
    	LinkedList<Integer> ylist = new LinkedList<>();
    	
    	//상자를 쭉 돌면서 익은 사과는 리스트에 담고, 방문배열에 넣는다.
    	for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[0].length; j++) {
				if (box[i][j] == 1) {
					ylist.add(i);
					xlist.add(j);
					visit[i][j] = 1;
				}
				//토마토가 들어 있지 않은 칸은 방문하지 말아야 하기에 표기해두었다.
				if (box[i][j] == -1) {
					visit[i][j] = -1;
				}
			}
		}
    	
    	bfs(xlist, ylist);
    	
    	int output = 0;
    	int tmp = 0;
    	for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[0].length; j++) {
				if (visit[i][j] == 0) {
					output = -1;
					break;
				}
				if (tmp < visit[i][j]) {
					tmp = visit[i][j];
				}
			}
		}
    	if (output == -1) {
			System.out.println(output);
		} else {
			System.out.println(tmp-1);
		}
    }
    
    public static void bfs(LinkedList<Integer> xlist, LinkedList<Integer> ylist) {
    	while (!xlist.isEmpty()) {
			int x = xlist.poll();
			int y = ylist.poll();
			
    		for (int i = 0; i < dx.length; i++) {
    			//해당 좌표에 방문해서 상하좌우를 본다.
    			int nx = x+dx[i];
    			int ny = y+dy[i];
    			
    			//박스의 범위를 벗어나지 않기 위해 if로 거른다.
    			if (nx >= 0 && ny >= 0 && nx < m && ny < n ) {
    				//갈 수 있는 방향들 중, 방문하지 않은 칸들로만 걸렀다.
					if (box[ny][nx] == 0 && visit[ny][nx] == 0) {
						//다음으로 이동할 칸은 전 칸보다 하루 더 있어야 토마토가 익기에 +1을 해두었다.
						visit[ny][nx] = visit[y][x] + 1;
						//다음에 이동할 칸들이기에 리스트에 담는다.
						xlist.add(nx);
						ylist.add(ny);
					}
					
				}
			}
		}
    }
}