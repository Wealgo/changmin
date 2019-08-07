import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 제발 문제 좀 꼼꼼히 읽자!
 * 청소를 끝낸 장소와 벽을 동일시 해서 로봇이 벽을 지나 갈 수 있게 함.
 * map을 boolean형으로 선언하여 벽과 청소된 부분을 false로 둠.
 * -> 즉 청소된 부분을 따로 처리하지 않았기 때문에 벽과 청소를 끝낸 장소의 판별이 불가능.
 * 위의 이유로 문제를 풀지 못하여 하루를 날려먹음.
 * @author quadcore
 *
 */
class Main {
	public static int garo;
	public static int sero;
	public static int map[][];
	public static int max = 1;
	public static boolean end = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		map = new int[sero][garo];
		st = new StringTokenizer(sc.nextLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		Robot robot = new Robot(y, x, dir);
		for (int i = 0; i < sero; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < garo; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(robot);
		System.out.println(max);
	}
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};
	public static int[] bx = {0,-1,0,1};
	public static int[] by = {1,0,-1,0};
	public static void clean(Robot robot) {
		map[robot.y][robot.x] = 2;
		int dir = robot.dir;
		for (int i = 0; i < 4; i++) {
			dir = (dir + 3) % 4;
			int nx = robot.x + dx[dir];
			int ny = robot.y + dy[dir];
			if (nx >= 0 && nx < garo && ny < sero && ny >= 0 && map[ny][nx] == 0) {
				Robot nRobot = new Robot(ny, nx, dir);
				max = max + 1;
				clean(nRobot);
				return;
			}
		}
		
		int nx = robot.x + bx[robot.dir];
		int ny = robot.y + by[robot.dir];
		if (nx >= 0 && nx < garo && ny >= 0 && ny < sero && map[ny][nx] != 1) {
			Robot nRobot = new Robot(ny, nx, robot.dir);
			clean(nRobot);
		}
	}

}
class Robot {
	int x,y;
	int dir;
	public Robot(int y, int x, int dir) {
		// TODO Auto-generated constructor stub
		this.dir = dir;
		this.x = x;
		this.y = y;
	}
	
}