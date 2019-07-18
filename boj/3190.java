
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 문제를 꼼꼼히 읽어보지 않아 생긴 실수들.
 * 1. 구슬탈출(13460) 문제처럼 맵 가장자리에 벽이 있다고 넘겨짚음.
 * 2. "맨위맨좌측(1행1열)"이라는 단어를 보지 못하고 0,0에서 시작점을 잡음.
 *   -> 당연히 사과의 위치도 잘못입력받게됨.
 * 
 * 문제를 꼼꼼히 읽지않아 시간지연이 많이 됨.
 */
public class Main{
	public static int time = 0;
	public static int n;
	public static boolean[][] map;
	public static snake snake;
	public static LinkedList<Integer> applex;
	public static LinkedList<Integer> appley;
	public static HashMap<Integer, String> cd = new HashMap<>();
	public static int dir = 1; //상 = 0, 우 = 1, 하 = 2, 좌 = 3.
	public static void main(String[] args) {
		snake = new snake(0, 0, 0);
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		n = Integer.parseInt(sc.nextLine());
		map = new boolean[n][n];
		//map 초기화
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = true;
			}
		}
		int k = Integer.parseInt(sc.nextLine());
		applex = new LinkedList<>();
		appley = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(sc.nextLine());
			appley.add(Integer.parseInt(st.nextToken())-1);
			applex.add(Integer.parseInt(st.nextToken())-1);
		}
		int l = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(sc.nextLine());
			cd.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		map[0][0] = false;
		go(0, 1);
		System.out.println(time+1);
	}
	public static void go(int y, int x) {
		/*
		 * 들어왔으면 map에 false해주고,
		 * 뱀에 좌표 넣어주고,
		 * 사과 체크하고(당기는것도)99-
		 * 시간 체크-> 방향나오니까, 다음에 갈 위치 go(y,x);
		 */
		if (y < 0 || y > n-1 || x < 0 || x > n-1) return;
		if (map[y][x] == false) return;
		map[y][x] = false;
		snake.xlist.add(x);
		snake.ylist.add(y);
		time++;
		//사과먹었니?
		boolean isApple = false;
		for (int i = 0; i < applex.size(); i++) {
			if (applex.get(i).equals(x) && appley.get(i).equals(y)) {
				
				isApple = true;
				applex.remove(i);
				appley.remove(i);
				break;
			}
		}
		//못먹었다면 당겨주자.
		if (isApple == false) {
			int tmpx = snake.xlist.removeFirst();
			int tmpy = snake.ylist.removeFirst();
			map[tmpy][tmpx] = true;
		}
		String way = "";
		if (cd.containsKey(time)) {
			way = cd.get(time);
		}
		//right
		if (way.equals("D")) {
			
			if (dir == 3) {
				dir = 0;
			} else { 
				dir = dir + 1;
			}
		}
		//left
		if (way.equals("L")) {
			if (dir == 0) {
				dir = 3;
			} else {
				dir = dir - 1;
			}
		}
		int tmpx = 0;
		int tmpy = 0;
		switch (dir) {
		case 0:
			tmpy = y - 1;
			tmpx = x;
			break;
		case 1:
			tmpx = x + 1;
			tmpy = y;
			break;
		case 2: 
			tmpy = y + 1;
			tmpx = x;
			break;
		case 3:
			tmpx = x - 1;
			tmpy = y;
			break;
		default:
			break;
		}
		go(tmpy, tmpx);
	}
}
class snake{
	LinkedList<Integer> xlist = new LinkedList<>();
	LinkedList<Integer> ylist = new LinkedList<>();
	int size;
	public snake(int x, int y, int size) {
		// TODO Auto-generated constructor stub
		xlist.add(x);
		ylist.add(y);
		this.size = size;
	}
}