import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
	public static int[][] map;
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < testcase; i++) {
			int k = Integer.parseInt(sc.nextLine());
			int len = (int) Math.pow(2, k);
			map = new int[len][len];
			LinkedList<Integer> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			while (st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			recursive(list, 0);
			System.out.print("#"+(i+1)+" ");
			for (int j = 0; j < map.length; j++) {
				for (int j2 = 0; j2 < map.length; j2++) {
					if (map[j][j2] != 0) {
						System.out.print(map[j][j2]+" ");
					}
				}
				if (map[j][0] != 0) {
					System.out.println();
				}
				
			}
		}
		
	}
    public static void recursive(LinkedList<Integer> list, int high) {
    	if (list.size() < 2) {
			int index = 0;
			for (int i = 0; i < map.length; i++) {
				if (map[high][i] == 0) {
					index = i;
					break;
				}
			}
			map[high][index] = list.get(0);
    		return;
		}
    	LinkedList<Integer> sibal = new LinkedList<>();
    	for (int i = 0; i < list.size(); i++) {
			sibal.add(list.get(i));
		}
    	int index = 0;
    	for (int i = 0; i < map.length; i++) {
			if (map[high][i] == 0) {
				index = i;
				break;
			}
		}
    	map[high][index] = sibal.get((sibal.size()/2));
    	LinkedList<Integer> tmp1 = new LinkedList<>();
    	for (int i = 0; i < sibal.size()/2; i++) {
			tmp1.add(sibal.get(i));
		}
    	LinkedList<Integer> tmp2 = new LinkedList<>();
    	for (int i = (sibal.size()/2)+1; i < sibal.size(); i++) {
			tmp2.add(sibal.get(i));
		}
    	recursive(tmp1, high+1);
    	recursive(tmp2, high+1);
    }
}