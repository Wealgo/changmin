import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


public class Main{
    public static int n;
    public static int[][] oldMap;
    public static int[][] newMap;
    public static HashMap<Integer, LinkedList<Integer>> map;
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int size = sc.nextInt();
    	map = new HashMap<>();
    	oldMap = new int [size][size];
    	newMap = new int [size][size];
    	LinkedList<Integer> list;
    	for (int i = 0; i < oldMap.length; i++) {	
			list = new LinkedList<>();
    		for (int j = 0; j < oldMap.length; j++) {
				oldMap[i][j] = sc.nextInt();
				if (oldMap[i][j] == 1) {
					list.add(j);
				}
			}
    		map.put(i, list);
		}

    	for (int i = 0; i < oldMap.length; i++) {
    		sibal = i;
			for (int j = 0; j < oldMap.length; j++) {
				list = new LinkedList<>();
				dfs(i, j, list);
			}
		}

    	for (int i = 0; i < newMap.length; i++) {
			for (int j = 0; j < newMap.length; j++) {
				System.out.print(newMap[i][j]+" ");
			}
			System.out.println();
		}
    }
    public static int sibal;
    public static void dfs(int start, int end, LinkedList<Integer> duplist) {
    	if (map.get(start).contains(end)) {
			newMap[sibal][end] = 1;
		} else {
			if (checkDu(duplist)) {
				duplist.removeLast();
			} else {
				for (int i = 0; i < map.get(start).size(); i++) {
			    	duplist.add(map.get(start).get(i));

					dfs(map.get(start).get(i), end, duplist);
				}
			}
		}
    }
    public static boolean checkDu(LinkedList<Integer> list) {
    	if (list.isEmpty() || list.size() == 1) {
			return false;
		} else {
			LinkedList<Integer> nimi = new LinkedList<>();
			nimi.addAll(list);
			Collections.sort(nimi);
			for (int i = 0; i < nimi.size()-1; i++) {
				if (nimi.get(i).equals(nimi.get(i+1))) {
					return true;
				}
			}
		}
    	return false;
    }
}