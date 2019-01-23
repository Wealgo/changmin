
import java.util.LinkedList;
import java.util.Scanner;

public class Main{
    public static int[][] map;
    public static int[][] newMap;
    public static int num = 0;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
//    	int testcase = sc.nextInt();
    	
    	int sero = sc.nextInt();
		int garo = sc.nextInt();
		int cabbage = sc.nextInt();
		
		map = new int[sero][garo];
		newMap = new int [sero][garo];
		for (int i = 0; i < cabbage; i++) {
			map[sc.nextInt()][sc.nextInt()] = 1;
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {	
			}
		}
		
    	/**
    	for (int i = 0; i < testcase; i++) {
			int sero = sc.nextInt();
			int garo = sc.nextInt();
			int cabbage = sc.nextInt();
			
			map = new int[sero][garo];
			for (int j = 0; j < cabbage; j++) {
				map[sc.nextInt()][sc.nextInt()] = 1;	
			}
			
        }
		/**/
		
    	for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
    }
    public static void re(LinkedList<Integer> position) {
		newMap[position.getFirst()][position.getLast()] = num;
		
    	for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1 && newMap[i][j] == 0) {
					//up
					re(position);
					//down
					re(position);
					//left
					re(position);
					//right
					re(position);
				}
			}
		}
	}
    
    public static LinkedList<Integer> findStart() {
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

