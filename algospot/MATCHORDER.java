import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * 
 */
public class Main {
	public static LinkedList<Integer> teamrussian;
	public static LinkedList<Integer> teamkorean;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int i = 0; i < testcase; i++) {
			int num = sc.nextInt();
			LinkedList<Integer> tmpkorean = new LinkedList<>();
			LinkedList<Integer> tmprussian = new LinkedList<>();
			for (int j = 0; j < num; j++) {
				tmprussian.add(sc.nextInt());
			}
			teamrussian = tmprussian;
			for (int j = 0; j < num; j++) {
				tmpkorean.add(sc.nextInt());
			}
			wjdfuf(tmpkorean);
			System.out.println(compare());
			teamrussian = new LinkedList<>();
			teamkorean = new LinkedList<>();
		}
	}
	//
	public static void wjdfuf(LinkedList<Integer> korean) {
		Collections.sort(korean);
		
		LinkedList<Integer> tmplist = new LinkedList<>();
		for (int i = 0; i < teamrussian.size(); i++) {
			int itmp = 0;	
			if (teamrussian.get(i) > korean.getLast()) {
				tmplist.add(korean.getFirst());
				korean.removeFirst();
			} else {
				for (int j = 0; j < korean.size(); j++) {
					if (teamrussian.get(i) > korean.get(j)) {
						itmp++;
					}
				}
				tmplist.add(korean.get(itmp));
				korean.remove(itmp);
			}
		}
		teamkorean = tmplist;
	}
	public static int compare() {
		int output = 0;
		for (int i = 0; i < teamkorean.size(); i++) {
			if (teamkorean.get(i) >= teamrussian.get(i)) {
				output++;
			}
		}
		return output;
	}
	
}
