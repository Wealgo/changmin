import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static int garo;
	public static int sero;
	public static int time;
	public static int max;
	public static Shark[][] map;
	public static int move[] = {1,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sero = Integer.parseInt(st.nextToken());
		garo = Integer.parseInt(st.nextToken());
		int xspeed = (garo * 2)-2;
		int yspedd = (sero * 2)-2;
		int nShark = Integer.parseInt(st.nextToken());
		map = new Shark[sero][garo];
		
		for (int i = 0; i < nShark; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			if (dir == 1 || dir == 2) {
				speed = speed % yspedd;
			} else {
				speed = speed % xspeed;
			}
			Shark shark = new Shark(speed, dir, size);
			map[y][x] = shark;
		}
		for (int i = 0; i < garo; i++) {
			fishing();
			move();
			time++;
		}
		System.out.println(max);
	}
	public static void move() {
		Shark[][] newmap = new Shark[sero][garo];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if ((map[i][j] != null)) {
					Shark shark = map[i][j];
					int cnt = shark.speed;
					int x = j;
					int y = i;
					int dir = shark.dir;
					int size = shark.size;
					
					//
					while (cnt > 0) {
						cnt--;
						if (dir == 1) {
							int ny = y + move[1];
							if (ny < 0) {
								dir = 2;
								y = 1;
							} else {
								y = ny;
							}
						} else if (dir == 2) {
							int ny = y + move[0];
							if (ny >= sero) {
								dir = 1;
								y = sero - 2;
							} else {
								y = ny;
							}
						} else if (dir == 3) {
							int nx = x + move[0];
							if (nx >= garo) {
								dir = 4;
								x = garo - 2;
							} else {
								x = nx;
							}
						} else if (dir == 4) {
							int nx = x + move[1];
							if (nx < 0) {
								dir = 3;
								x = 1;
							} else {
								x = nx;
							}
						}
					}
					
					Shark newShark = new Shark(shark.speed, dir, size);
					if (newmap[y][x] == null) {
						newmap[y][x] = newShark;
					} else {
						if (newmap[y][x].size < newShark.size) {
							newmap[y][x] = newShark;
						}
					}
				}
			}
		}
		map = newmap;
	}
	public static void fishing() {
		for (int i = 0; i < sero; i++) {
			if (map[i][time] != null) {
				max = max + map[i][time].size;
				map[i][time] = null;
				break;
				
			}
		}
	}
}
class Shark {
	int x,y;
	int speed;
	int dir;
	int size;
	public Shark(int speed, int dir, int size) {
		// TODO Auto-generated constructor stub
		this.speed = speed;
		this.dir = dir;
		this.size = size;
	}
	public Shark() {
		// TODO Auto-generated constructor stub
	}
}
