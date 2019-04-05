
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 시간초과.
 * 1. 범위가 0부터 100000까지인데, 십만 이상의 숫자가 리스트에 추가되고, 계산됨.
 * 2. 0 이하의 숫자들도 리스트에 추가되고, 계산되어짐.
 * 
 * @author quadcore
 *
 */
public class Main{
	public static int time = 1;
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int subin = sc.nextInt();
    	int sister = sc.nextInt();
    	
    	bfs(subin, sister);
    	System.out.println(time-1);
    }
    
    public static void bfs(int subin, int sister) {
    	LinkedList<Integer> list = new LinkedList<>();
    	list.add(subin);
    	while (!list.contains(sister)) {
    		LinkedList<Integer> tmp = list;
    		list = new LinkedList<>();
    		for (int i = 0; i < tmp.size(); i++) {
				list.add(tmp.get(i)+1);
				list.add(tmp.get(i)-1);
				list.add(tmp.get(i)*2);
			}
    		time++;
		}
    }
}