import java.util.LinkedList;
import java.util.Scanner;

public class Main{
    public static int[][] map;
    public static int[][] newMap;
    public static int num;
	private static Scanner sc;
    public static void main(String[] args) {
    	sc = new Scanner(System.in);
    	int testcase = sc.nextInt();
    	
    	for (int i = 0; i < testcase; i++) {
			num = 0;
    		int sero = sc.nextInt();
			int garo = sc.nextInt();
			int cabbage = sc.nextInt();
			map = new int[sero][garo];
			newMap = new int [sero][garo];
			
			for (int j = 0; j < cabbage; j++) {
				map[sc.nextInt()][sc.nextInt()] = 1;	
			}
			for (int k = 0; k < cabbage; k++) {
				LinkedList<Integer> start = findStart();
				dfs(start);			
			}
			int output = 0;
			for (int j = 0; j < newMap.length; j++) {
				for (int j2 = 0; j2 < newMap[j].length; j2++) {
					if (newMap[j][j2] > output) {
						output = newMap[j][j2];
					}
				}
			}
			System.out.println(output);
        }
    	sc.close();
    }
    public static void dfs(LinkedList<Integer> position) {
		
		if (position.isEmpty()) {

		} else {
		    try {
		    	newMap[position.getFirst()][position.getLast()] = num;
		    	//right
				if (map[position.getFirst()][position.getLast()+1] == 1 && newMap[position.getFirst()][position.getLast()+1] == 0) {
					LinkedList<Integer> list = new LinkedList<>();
					list.addAll(position);
					list.set(1, position.getLast()+1);
					dfs(list);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		    try {
				//left
				if (map[position.getFirst()][position.getLast()-1] == 1 && newMap[position.getFirst()][position.getLast()-1] == 0) {
					LinkedList<Integer> list = new LinkedList<>();
					list.addAll(position);
					list.set(1, position.getLast()-1);
					dfs(list);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		    try {
				//up
				if (map[position.getFirst()-1][position.getLast()] == 1 && newMap[position.getFirst()-1][position.getLast()] == 0) {
					LinkedList<Integer> list = new LinkedList<>();
					list.addAll(position);
					list.set(0, position.getFirst()-1);
					dfs(list);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		    try {
				//down
				if (map[position.getFirst()+1][position.getLast()] == 1 && newMap[position.getFirst()+1][position.getLast()] == 0) {
					
					LinkedList<Integer> list = new LinkedList<>();
					list.addAll(position);
					list.set(0, position.getFirst()+1);
					dfs(list);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		    
		}
	}
    
    public static LinkedList<Integer> findStart() {
    	num++;
		LinkedList<Integer> start = new LinkedList<>();
    	for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1 && newMap[i][j] == 0) {
					start.add(i);
					start.add(j);
					return start;
				}
			}
		}
    	return start;
	}

}

