import java.util.LinkedList;
import java.util.Scanner;
/**
 * boj/13460과 유형이 비슷한 문제.
 * 해당 코드는 476ms이 걸림.
 * 해당 문제 1위는 108ms.
 * 같은 방향으로 여러번 연속되도 값이 똑같으니 이부분을 배제하는 로직을 추가해보자.
 * @author quadcore
 *
 */
public class Main{
	public static int output = 0;
	
	public static int n;
	public static void main(String[] args) {
    	//입력받고~
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	int[][] map;
    	map = new int [n][n];
    	for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
    	//상하좌우로 돌아보자~
    	for (int i = 0; i < 4; i++) {
			dfs(i, 0, map);
		}
    	System.out.println(output);
	}
	/**
	 * dir == 방향(상하좌우), cnt == 탐색횟수.
	 */
	public static void dfs(int dir, int cnt, int [][] map) {
		//횟수가 5이상 넘어가서 탐색하지 않도록 기저조건 선언.
		if (cnt > 4) return;
		//들어왔으면 횟수늘려주고~.
		cnt++;
		//맵을 가지고 다녀하야 하기 때문에 선언.
		int[][] tmap = new int[n][n];
		for (int i = 0; i < tmap.length; i++) {
			for (int j = 0; j < tmap.length; j++) {
				tmap[i][j] = map[i][j];
			}
		}
		//상.
		if (dir == 0) {
			//맵을 탐색해보자~.
			for (int i = 0; i < tmap.length; i++) {
				//리스트를 사용하는 이유는, 중간에 0이 있는 경우를 쉽게 처리하기 위해 사용했음.
				//ex) {2 0 2} -> [2,2]
				LinkedList<Integer> list = new LinkedList<>();
				for (int j = 0; j < tmap.length; j++) {
					//탐색하면서 0이 아닌것들은 싹다 리스트에 넣어주자.
					if (tmap[j][i] != 0) {
						list.add(tmap[j][i]);
						//뽑아낸 값은 0으로바꿔주고.
						tmap[j][i] = 0;
					}
				}
				//리스트 돌아보자.
				for (int j = 0; j < list.size()-1; j++) {
					//처음에 if조건을 list.get(j) == list.get(j+1)로 하였음.
					//당연히 작동이 안됨. 다음부턴 equals로 같은지 확인하자.
					if (list.get(j).equals(list.get(j+1))) {
						//해당값과 앞의 값이 같으면 *2해주고.
						list.set(j, list.get(j)*2);
						//더해준 값을 삭제하자.
						list.remove(j+1);
					}
				}
				//완성된 리스트의 값을 다시 맵에 뿌려주자.
				for (int j = 0; j < list.size(); j++) {
					tmap[j][i] = list.get(j);
				}
			}
		}
		//하.
		//상의 로직과 유사.
		if (dir == 1) {
			for (int i = 0; i < tmap.length; i++) {
				LinkedList<Integer> list = new LinkedList<>();
				for (int j = tmap.length-1; j >= 0; j--) {
					if (tmap[j][i] != 0) {
						list.add(tmap[j][i]);
						tmap[j][i] = 0;
					}
				}
				for (int j = 0; j < list.size()-1; j++) {
					if (list.get(j).equals(list.get(j+1))) {
						list.set(j, list.get(j)*2);
						list.remove(j+1);
					}
				}
				for (int j = tmap.length-1; j >= 0; j--) {
					if (list.isEmpty()) {
						break;
					}
					tmap[j][i] = list.removeFirst();
				}
			}
		}
		//left
		if (dir == 2) {
			for (int i = 0; i < tmap.length; i++) {
				LinkedList<Integer> list = new LinkedList<>();
				for (int j = 0; j < tmap.length; j++) {
					if (tmap[i][j] != 0) {
						list.add(tmap[i][j]);
						tmap[i][j] = 0;
					}
				}
				for (int j = 0; j < list.size()-1; j++) {
					if (list.get(j).equals(list.get(j+1))) {
						list.set(j, list.get(j)*2);
						list.remove(j+1);
					}
				}
				for (int j = 0; j < list.size(); j++) {
					tmap[i][j] = list.get(j);
				}
			}
		}
		//right
		if (dir == 3) {
			for (int i = 0; i < tmap.length; i++) {
				LinkedList<Integer> list = new LinkedList<>();
				for (int j = tmap.length-1; j >= 0; j--) {
					if (tmap[i][j] != 0) {
						list.add(tmap[i][j]);
						tmap[i][j] = 0;
					}
				}
				for (int j = 0; j < list.size()-1; j++) {
					if (list.get(j).equals(list.get(j+1))) {
						list.set(j, list.get(j)*2);
						list.remove(j+1);
					}
				}
				for (int j = tmap.length-1; j >= 0; j--) {
					if (list.isEmpty()) {
						break;
					}
					tmap[i][j] = list.removeFirst();
				}
			}
		}
		for (int i = 0; i < tmap.length; i++) {
			for (int j = 0; j < tmap.length; j++) {
				if (output < tmap[i][j]) {
					output = tmap[i][j];
				}
			}
		}
		//다시 상하좌우로 탬색 가즈아~
		for (int i = 0; i < 4; i++) {
			dfs(i, cnt, tmap);
		}

	}
}