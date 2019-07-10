import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 해당 코드는 2236ms걸림
 * 해당문제 1위는 72ms.
 * 이전 방향과 같은 방향으로 2번 이상 움직이는 부분을 제외해주면 시간이 줄어들듯.
 * @author quadcore
 *
 */
public class Main {
	public static int time;
	public static int sero, garo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//구슬이 구멍을 통과하는 최소 횟수를 체크하기 위한 값.
		time = 999;
		//입력받고~
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		Point R = new Point();
		Point B = new Point();
		char [][] map = new char[sero][garo];
		for (int i = 0; i < map.length; i++) {
			String tmp = sc.nextLine();
			for (int j = 0; j < tmp.length(); j++) {
				if (tmp.charAt(j) == 'R') {
					R.y = i;
					R.x = j;
				}
				if (tmp.charAt(j) == 'B') {
					B.y = i;
					B.x = j;
				}
				map[i][j] = tmp.charAt(j);
			}
		}
		//자 dfs로 풀어보자.
		for (int i = 0; i < 4; i++) {
			dfs(map, R, B, 1, i);
		}
		//10번 내에 구슬이 통과하지 못할 경우.
		if (time == 999) {
			time = -1;;
		}
		System.out.println(time);
	}
	public static void dfs(char[][] map, Point R, Point B, int cnt, int dir) {
		//10번이상 탐색이 되지 않도록 해주자.
		if (cnt > 10) return;
		/*이부분.
		 *해당 부분에서 순간 java가 call by reference인가 찾아봤음.
		 *dfs에서 함수 안으로 들어가면 맵을 가지고 들어가야함. 
		 */
		char[][] tmap = new char [sero][garo];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				tmap[i][j] = map[i][j];
			}
		}
		
		Point nR = new Point();
		Point nB = new Point();
		//up
		if (dir == 0) {
			//B구슬과 R구슬의 높낮이를 비교하여,
			//높은 위치에 있는 구슬부터 먼저 올려주기 위해 if로 비교.
			if (R.y < B.y) {
				//red 구슬 먼저.
				
				//R구슬이 먼저 구멍을 통과한 뒤에 B구슬이 통과하면 꽝이기 때문에 체크하기 위한 변수.
				boolean redgoal = false;
				for (int i = R.y; i >= 0; i--) {
					if (tmap[i][R.x] == 'O') {
						redgoal = true;
						tmap[R.y][R.x] = '.';
						break;
					}
					if (tmap[i][R.x] == '#') {
						tmap[R.y][R.x] = '.';
						tmap[i+1][R.x] = 'R';
						nR.y = i+1;
						nR.x = R.x;
						break;
					}
				}
				for (int i = B.y; i >= 0; i--) {
					if (tmap[i][B.x] == 'O') {
						return;
					}
					if (tmap[i][B.x] == '#' || tmap[i][B.x] == 'R') {
						tmap[B.y][B.x] = '.';
						tmap[i+1][B.x] = 'B';
						nB.y = i+1;
						nB.x = B.x;
						if (redgoal) {
							if (cnt < time) {
								time = cnt;
							}
							return;
						}
						break;
					}
				}
			} else {
				//black 구슬 먼저.
				for (int i = B.y; i >= 0; i--) {
					if (tmap[i][B.x] == 'O') {
						return;
					}
					if (tmap[i][B.x] == '#') {
						tmap[B.y][B.x] = '.';
						tmap[i+1][B.x] = 'B';
						nB.y = i+1;
						nB.x = B.x;
						break;
					}
				}
				for (int i = R.y; i >= 0; i--) {
					if (tmap[i][R.x] == 'O') {
						if (cnt < time) {
							time = cnt;
						}
						return;
					}
					if (tmap[i][R.x] == '#' || tmap[i][R.x]  == 'B') {
						tmap[R.y][R.x] = '.';
						tmap[i+1][R.x] = 'R';
						nR.y = i+1;
						nR.x = R.x;
						break;
					}
				}
			}
		//down
		} else if (dir == 1) {
			//up의 로직과 거의 같다.
			if (R.y < B.y) {
				//black first
				for (int i = B.y; i < sero; i++) {
					if (tmap[i][B.x] == 'O') {
						tmap[B.y][B.x] = '.';
						return;
					}
					if (tmap[i][B.x] == '#') {
						tmap[B.y][B.x] = '.';
						tmap[i-1][B.x] = 'B';
						nB.y = i-1;
						nB.x = B.x;
						break;
					}
				}
				for (int i = R.y; i < sero; i++) {
					if (tmap[i][R.x] == 'O') {
						if (cnt < time) {
							time = cnt;
						}
						return;
					}
					if (tmap[i][R.x] == '#' || tmap[i][R.x] == 'B') {
						tmap[R.y][R.x] = '.';
						tmap[i-1][R.x] = 'R';
						nR.y = i-1;
						nR.x = R.x;
						break;
					}
				}
			} else {
				//red first
				boolean redgoal = false;
				for (int i = R.y; i < sero; i++) {
					if (tmap[i][R.x] == 'O') {
						tmap[R.y][R.x] = '.';
						redgoal = true;
						break;
					}
					if (tmap[i][R.x] == '#') {
						tmap[R.y][R.x] = '.';
						tmap[i-1][R.x] = 'R';
						nR.y = i-1;
						nR.x = R.x;
						break;
					}
				}
				for (int i = B.y; i < sero; i++) {
					if (tmap[i][B.x] == 'O') {
						return;
					}
					if (tmap[i][B.x] == '#' || tmap[i][B.x] == 'R') {
						tmap[B.y][B.x] = '.';
						tmap[i-1][B.x] = 'B';
						nB.x = B.x;
						nB.y = i-1;
						if (redgoal) {
							if (cnt < time) {
								time = cnt;
							}
							return;
						}
						break;
					}
				}
			}
		} else if (dir == 2) {
			//left
			if (R.x < B.x) {
				// red first
				boolean redgoal = false;
				for (int i = R.x; i >= 0; i--) {
					if (tmap[R.y][i] == 'O') {
						redgoal = true;
						tmap[R.y][R.x] = '.';
						break;
					}
					if (tmap[R.y][i] == '#') {
						tmap[R.y][R.x] = '.';
						tmap[R.y][i+1] = 'R';
						nR.x = i+1;
						nR.y = R.y;
						break;
					}
				}
				for (int i = B.x; i >= 0; i--) {
					if (tmap[B.y][i] == 'O') {
						return;
					}
					if (tmap[B.y][i] == '#' || tmap[B.y][i] == 'R') {
						tmap[B.y][B.x] = '.';
						tmap[B.y][i+1] = 'B';
						nB.x = i+1;
						nB.y = B.y;
						if (redgoal) {
							if (cnt < time) {
								time = cnt;
							}
							return;
						}
						break;
					}
				}
			} else {
				// black first
				for (int i = B.x; i >= 0; i--) {
					if (tmap[B.y][i] == 'O') {
						return;
					}
					if (tmap[B.y][i] == '#') {
						tmap[B.y][B.x] = '.';
						tmap[B.y][i+1] = 'B';
						nB.x = i+1;
						nB.y = B.y;
						break;
					}
				}
				for (int i = R.x; i >= 0; i--) {
					if (tmap[R.y][i] == 'O') {
						if (cnt < time) {
							time = cnt;
						}
						return;
					}
					if (tmap[R.y][i] == '#' || tmap[R.y][i] == 'B') {
						tmap[R.y][R.x] = '.';
						tmap[R.y][i+1] = 'R';
						nR.y = R.y;
						nR.x = i+1;
						break;
					}
				}
			}
		} else {
			//right
			if (R.x < B.x) {
				// black first
				for (int i = B.x+1; i < garo; i++) {
					if (tmap[B.y][i] == 'O') {
						tmap[B.y][B.x] = '.';
						return;
					}
					if (tmap[B.y][i] == '#') {
						tmap[B.y][B.x] = '.';
						tmap[B.y][i-1] = 'B';
						nB.y = B.y;
						nB.x = i-1;
						break;
					}
				}
				for (int i = R.x+1; i < garo; i++) {
					if (tmap[R.y][i] == 'O') {
						if (cnt < time) {
							time = cnt;
						}
						return;
					}
					if (tmap[R.y][i] == '#' || tmap[R.y][i] == 'B') {
						tmap[R.y][R.x] = '.';
						tmap[R.y][i-1] = 'R';
						nR.y = R.y;
						nR.x = i-1;
						break;
					}
				}
			} else {
				//red first
				boolean redgoal = false;
				for (int i = R.x+1; i < garo; i++) {
					if (tmap[R.y][i] == 'O') {
						redgoal = true;
						tmap[R.y][R.x] = '.';
						break;
					}
					if (tmap[R.y][i] == '#') {
						tmap[R.y][R.x] = '.';
						tmap[R.y][i-1] = 'R';
						nR.x = i-1;
						nR.y = R.y;
						break;
					}
				}
				for (int i = B.x+1; i < garo; i++) {
					if (tmap[B.y][i] == 'O') {
						return;
					}
					if (tmap[B.y][i] == '#' || tmap[B.y][i] == 'R') {
						tmap[B.y][B.x] = '.';
						tmap[B.y][i-1] = 'B';
						nB.x = i-1;
						nB.y = B.y;
						if (redgoal) {
							if (cnt < time) {
								time = cnt;
							}
							return;
						}
						break;
					}
				}
			}
		}
		cnt++;
		for (int i = 0; i < 4; i++) {
			dfs(tmap, nR, nB, cnt, i);
		}
	}

}
class Point{
	int x,y;
	public Point() {
		// TODO Auto-generated constructor stub
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
